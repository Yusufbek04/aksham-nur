package uz.pdp.akshamnurserver.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uz.pdp.akshamnurserver.entity.Product;
import uz.pdp.akshamnurserver.exceptions.RestException;
import uz.pdp.akshamnurserver.payload.ApiResult;
import uz.pdp.akshamnurserver.payload.ProductDTO;
import uz.pdp.akshamnurserver.repository.ProductRepository;
import uz.pdp.akshamnurserver.service.abs.ImageService;
import uz.pdp.akshamnurserver.service.abs.ProductService;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final ImageService imageService;

    @Override
    public ApiResult<List<ProductDTO>> getAll() {
        List<ProductDTO> productDTOS = ProductDTO.mapToDTOs(productRepository.findAll());

        return ApiResult.successResponse(productDTOS);
    }

    @Override
    public ApiResult<ProductDTO> get(Integer id) {
        Product product = productRepository.findById(id).orElseThrow(() -> RestException.restThrow("Product not found"));
        return ApiResult.successResponse(ProductDTO.mapToDTO(product));
    }

    @Override
    public ApiResult<ProductDTO> add(ProductDTO productDTO, MultipartFile image) {
        checkAddDTO(productDTO, image);
        try {
            InputStream inputStream = image.getInputStream();
            BufferedImage read = ImageIO.read(inputStream);
            ImageIO.write(read, "png", new File("templates/" + productDTO.getName() + ".png"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Product product = ProductDTO.mapToProduct(productDTO);
        productRepository.save(product);
        return ApiResult.successResponse(ProductDTO.mapToDTO(product));
    }

    private void checkAddDTO(ProductDTO productDTO,MultipartFile image) {
        if (Objects.isNull(image))
            throw RestException.restThrow("image must be not null");
        if (!Objects.equals(image.getContentType(), "image/png"))
            throw RestException.restThrow("image content type must be png");
        if (productDTO.getPrice()<=0)
            throw RestException.restThrow("price must be more zero");
        if (productRepository.existsByName(productDTO.getName()))
            throw RestException.restThrow(productDTO.getName() + " already exists");
    }

    @Override
    public ApiResult<ProductDTO> edit(ProductDTO productDTO) {
        return null;
    }

    @Override
    public void delete(Integer id) {
        productRepository.deleteById(id);
    }

}
