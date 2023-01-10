package uz.pdp.akshamnurserver.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import uz.pdp.akshamnurserver.contoller.abs.AuthController;
import uz.pdp.akshamnurserver.contoller.abs.ImageController;
import uz.pdp.akshamnurserver.contoller.abs.ProductController;

public interface RestConstants {

    ObjectMapper objectMapper = new ObjectMapper();

    String AUTHENTICATION_HEADER = "Authorization";

    String AUTHORIZATION_HEADER = "Authorization";

    String REQUEST_ATTRIBUTE_CURRENT_USER = "User";
    String REQUEST_ATTRIBUTE_CURRENT_USER_ID = "UserId";
    String REQUEST_ATTRIBUTE_CURRENT_USER_PERMISSIONS = "Permissions";

    String[] OPEN_PAGES = {
            "/*",
            AuthController.BASE_PATH + "/**",
//            ProductController.BASE_PATH + ProductController.GET_ALL_PATH,
            ProductController.BASE_PATH + "/**",
            ImageController.BASE_PATH + "/**",

    };
}
