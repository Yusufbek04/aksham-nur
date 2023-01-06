package uz.pdp.akshamnurserver.service.impl;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.pdp.akshamnurserver.exceptions.RestException;
import uz.pdp.akshamnurserver.service.abs.ImageService;

import java.io.IOException;
import java.util.List;
@Service
public class ImageServiceImpl implements ImageService {
    @Override
    public ResponseEntity<InputStreamResource> getImage(String name) {
        ClassPathResource classPathResource = new ClassPathResource("templates/" + name + ".png");
        InputStreamResource inputStreamResource = null;
        try {
            inputStreamResource = new InputStreamResource(classPathResource.getInputStream());
        } catch (IOException e) {
            throw RestException.restThrow("image not found", HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(inputStreamResource);
    }
}
