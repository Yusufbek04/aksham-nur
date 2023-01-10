package uz.pdp.akshamnurserver.contoller.abs;

import org.springframework.web.bind.annotation.*;
import uz.pdp.akshamnurserver.payload.ApiResult;
import uz.pdp.akshamnurserver.payload.SignDTO;
import uz.pdp.akshamnurserver.payload.TokenDTO;

import javax.validation.Valid;

@RequestMapping(AuthController.BASE_PATH)
public interface AuthController {
    String BASE_PATH = "/auth";
    String SIGN_UP_PATH = "/sign-up";
    String SIGN_IN_PATH = "/sign-in";

    @PostMapping(SIGN_UP_PATH)
    ApiResult<TokenDTO> signUp(@RequestBody @Valid SignDTO signDTO);

    @PostMapping(SIGN_IN_PATH)
    ApiResult<TokenDTO> signIn(@RequestBody @Valid SignDTO signDTO);

    @PostMapping("/get-sms-code")
    ApiResult<Boolean> setSmsCode(@RequestBody String sms, @RequestBody String phoneNum);

}
