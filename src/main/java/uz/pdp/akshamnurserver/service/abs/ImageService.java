package uz.pdp.akshamnurserver.service.abs;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

public interface ImageService {
    ResponseEntity<InputStreamResource> getImage(String name);
}
