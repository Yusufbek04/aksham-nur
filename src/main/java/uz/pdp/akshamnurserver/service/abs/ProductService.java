package uz.pdp.akshamnurserver.service.abs;

import org.springframework.web.multipart.MultipartFile;
import uz.pdp.akshamnurserver.payload.ApiResult;
import uz.pdp.akshamnurserver.payload.ProductDTO;

import java.util.List;

public interface ProductService {
    ApiResult<List<ProductDTO>> getAll();

    ApiResult<ProductDTO> get(Integer id);

//    ApiResult<ProductDTO> add(AddProductDTO productDTO);
    ApiResult<ProductDTO> add(ProductDTO productDTO, MultipartFile image);

    ApiResult<ProductDTO> edit(ProductDTO productDTO);

    void delete(Integer id);
}
