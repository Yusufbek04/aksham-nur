package uz.pdp.akshamnurserver.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.akshamnurserver.payload.ApiResult;
import uz.pdp.akshamnurserver.payload.ProductDTO;
import uz.pdp.akshamnurserver.repository.ProductRepository;
import uz.pdp.akshamnurserver.service.abs.ProductService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public ApiResult<List<ProductDTO>> getAll() {
        List<ProductDTO> productDTOS = ProductDTO.mapToDTOs(productRepository.findAll());

        return ApiResult.successResponse(productDTOS);
    }

    @Override
    public ApiResult<ProductDTO> get(String id) {
        return null;
    }
}
