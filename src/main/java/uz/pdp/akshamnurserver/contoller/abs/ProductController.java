package uz.pdp.akshamnurserver.contoller.abs;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.pdp.akshamnurserver.entity.Product;
import uz.pdp.akshamnurserver.payload.ApiResult;
import uz.pdp.akshamnurserver.payload.ProductDTO;

import java.util.List;

@RequestMapping(ProductController.BASE_PATH)
public interface ProductController {

    String BASE_PATH = "/product";

    String GET_ALL_PATH = "/all";
    String GET_PATH = "/{id}";

    @GetMapping(GET_ALL_PATH)
    ApiResult<List<ProductDTO>> getProduct();

    @GetMapping(GET_PATH)
    ApiResult<ProductDTO> getProduct(@PathVariable String id);
}
