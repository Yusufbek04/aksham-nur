package uz.pdp.akshamnurserver.payload;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
public class AddProductDTO {

//    @NotNull
//    private MultipartFile image;

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotBlank
    private String aboutProduct;

    @NotNull
    private Float price;
}
