package uz.pdp.akshamnurserver.contoller.abs;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.pdp.akshamnurserver.entity.Product;
import uz.pdp.akshamnurserver.payload.ApiResult;

@RequestMapping(ImageController.BASE_PATH)
public interface ImageController {
    String BASE_PATH = "/image";
    String GET_PATH = "/{name}";

    @GetMapping(GET_PATH)
    ResponseEntity<InputStreamResource> getImage(@PathVariable String name);
}
