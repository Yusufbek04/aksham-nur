package uz.pdp.akshamnurserver.contoller.impl;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.akshamnurserver.contoller.abs.ImageController;
import uz.pdp.akshamnurserver.service.abs.ImageService;

@RestController
@RequiredArgsConstructor
public class ImageControllerImpl implements ImageController {

    private final ImageService imageService;

    @Override
    public ResponseEntity<InputStreamResource> getImage(String name) {
        return imageService.getImage(name);
    }
}
