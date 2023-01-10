package uz.pdp.akshamnurserver.payload;

import lombok.*;
import uz.pdp.akshamnurserver.entity.Product;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private Integer id;

    @NotBlank
    private String imagePath;

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotBlank
    private String aboutProduct;

    @NotNull
    private Float price;

    public static ProductDTO mapToDTO(Product product) {
        return ProductDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .imagePath(product.getImagePath())
                .description(product.getDescription())
                .aboutProduct(product.getAboutProduct())
                .price(product.getPrice())
                .build();
    }
    public static List<ProductDTO> mapToDTOs(List<Product> products) {
        return products
                .stream()
                .map(product -> mapToDTO(product))
                .collect(Collectors.toList());
    }

    public static Product mapToProduct(ProductDTO product) {
        return Product.builder()
                .id(product.getId())
                .name(product.getName())
                .imagePath(product.getImagePath())
                .description(product.getDescription())
                .aboutProduct(product.getAboutProduct())
                .price(product.getPrice())
                .build();
    }
    public static List<Product> mapToProducts(List<ProductDTO> products) {
        return products
                .stream()
                .map(product -> mapToProduct(product))
                .collect(Collectors.toList());
    }

}
