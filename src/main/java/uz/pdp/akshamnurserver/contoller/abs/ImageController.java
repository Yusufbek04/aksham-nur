package uz.pdp.akshamnurserver.contoller.abs;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uz.pdp.akshamnurserver.entity.Product;
import uz.pdp.akshamnurserver.payload.ApiResult;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

@RequestMapping(ImageController.BASE_PATH)
public interface ImageController {
    String BASE_PATH = "/image";
    String GET_PATH = "/{name}";

    @GetMapping(GET_PATH)
    ResponseEntity<InputStreamResource> getImage(@PathVariable String name);

    @PostMapping("/p")
    boolean img(@RequestParam("image") MultipartFile image);

}
