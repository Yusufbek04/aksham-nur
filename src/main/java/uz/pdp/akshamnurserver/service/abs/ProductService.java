package uz.pdp.akshamnurserver.service.abs;

import uz.pdp.akshamnurserver.entity.Product;
import uz.pdp.akshamnurserver.payload.ApiResult;
import uz.pdp.akshamnurserver.payload.ProductDTO;

import java.util.List;

public interface ProductService {
    ApiResult<List<ProductDTO>> getAll();

    ApiResult<ProductDTO> get(String id);
}
