package uz.pdp.akshamnurserver.payload;

import lombok.*;
import uz.pdp.akshamnurserver.entity.Product;

import java.util.List;
import java.util.stream.Collectors;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private Integer id;

    private String imagePath;

    private String name;

    private String description;

    private Float price;

    public static ProductDTO mapToDTO(Product product) {
        return ProductDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .imagePath(product.getImagePath())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
    public static List<ProductDTO> mapToDTOs(List<Product> products) {
        return products
                .stream()
                .map(product -> mapToDTO(product))
                .collect(Collectors.toList());
    }
}
