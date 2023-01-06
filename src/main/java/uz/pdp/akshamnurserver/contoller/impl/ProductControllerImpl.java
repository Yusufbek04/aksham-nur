package uz.pdp.akshamnurserver.contoller.impl;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.akshamnurserver.contoller.abs.ProductController;
import uz.pdp.akshamnurserver.entity.Product;
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
    public ApiResult<ProductDTO> getProduct(String id) {
        return productService.get(id);
    }
}
