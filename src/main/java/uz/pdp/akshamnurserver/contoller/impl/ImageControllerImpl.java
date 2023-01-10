package uz.pdp.akshamnurserver.contoller.impl;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import uz.pdp.akshamnurserver.contoller.abs.ImageController;
import uz.pdp.akshamnurserver.service.abs.ImageService;

import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class ImageControllerImpl implements ImageController {

    private final ImageService imageService;

    @Override
    public ResponseEntity<InputStreamResource> getImage(String name) {
        return imageService.getImage(name);
    }

    @Override
    public boolean img(MultipartFile multipartFile) {

        System.out.println(multipartFile.getContentType());

        return true;
    }

}
