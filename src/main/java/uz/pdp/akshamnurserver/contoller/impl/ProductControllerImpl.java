package uz.pdp.akshamnurserver.contoller.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import uz.pdp.akshamnurserver.contoller.abs.ProductController;
import uz.pdp.akshamnurserver.contoller.abs.Test;
import uz.pdp.akshamnurserver.payload.ApiResult;
import uz.pdp.akshamnurserver.payload.ProductDTO;
import uz.pdp.akshamnurserver.service.abs.ProductService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductControllerImpl implements ProductController {

    private final ProductService productService;

    @Override
    public ApiResult<List<ProductDTO>> getProduct() {
        return productService.getAll();
    }

    @Override
    public ApiResult<ProductDTO> getProduct(Integer id) {
        return productService.get(id);
    }

    @Override
    public ApiResult<ProductDTO> add(MultipartFile image, String name, String description, String aboutProduct, Float price) {
        return productService.add(
                ProductDTO.builder()
                        .name(name)
                        .description(description)
                        .aboutProduct(aboutProduct)
                        .price(price)
                        .build()
                , image
        );
    }

    @Override
    public ApiResult<ProductDTO> edit(ProductDTO productDTO) {
        return productService.edit(productDTO);
    }

    @Override
    public void delete(Integer id) {
        productService.delete(id);
    }

    @Override
    public boolean test(Test test) {
        System.out.println(test);
        System.out.println(test.getImage());
        System.out.println(test.getName());
        return false;
    }
}
