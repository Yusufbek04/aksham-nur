package uz.pdp.akshamnurserver.contoller.abs;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uz.pdp.akshamnurserver.payload.ApiResult;
import uz.pdp.akshamnurserver.payload.ProductDTO;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RequestMapping(ProductController.BASE_PATH)
public interface ProductController {

    String BASE_PATH = "/product";

    String GET_ALL_PATH = "/all";
    String GET_PATH = "/{id}";
    String ADD_PATH = "/add";
    String EDIT_PATH = "/edit";
    String DELETE_PATH = "/{id}";

    @GetMapping(GET_ALL_PATH)
    ApiResult<List<ProductDTO>> getProduct();

    @GetMapping(GET_PATH)
    ApiResult<ProductDTO> getProduct(@PathVariable Integer id);

    @PostMapping(ADD_PATH)
    ApiResult<ProductDTO> add(
            @RequestParam MultipartFile image,
            @RequestParam String name,
            @RequestParam String description,
            @RequestParam String aboutProduct,
            @RequestParam Float price
    );

    @PostMapping(EDIT_PATH)
    ApiResult<ProductDTO> edit(@RequestBody @Valid ProductDTO productDTO);

    @DeleteMapping(DELETE_PATH)
    void delete(@PathVariable @NotNull Integer id);

    @PostMapping(value = "/test")
    boolean test(@ModelAttribute Test test);
}