package uz.pdp.akshamnurserver.contoller.abs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Test {

    private MultipartFile image;
    private String name;
}
