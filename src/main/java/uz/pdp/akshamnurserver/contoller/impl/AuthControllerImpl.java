package uz.pdp.akshamnurserver.contoller.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.akshamnurserver.contoller.abs.AuthController;
import uz.pdp.akshamnurserver.payload.ApiResult;
import uz.pdp.akshamnurserver.payload.SignDTO;
import uz.pdp.akshamnurserver.payload.TokenDTO;
import uz.pdp.akshamnurserver.service.abs.AuthService;

@RestController
@RequiredArgsConstructor
public class AuthControllerImpl implements AuthController {

    private final AuthService authService;

    @Override
    public ApiResult<TokenDTO> signUp(SignDTO signDTO) {
        return authService.signUp(signDTO);
    }

    @Override
    public ApiResult<TokenDTO> signIn(SignDTO signDTO) {
        return authService.signIn(signDTO);
    }

    @Override
    public ApiResult<Boolean> setSmsCode(String sms, String phoneNum) {
        return authService.setSmsCode(sms,phoneNum);
    }
}
