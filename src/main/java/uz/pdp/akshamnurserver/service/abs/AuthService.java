package uz.pdp.akshamnurserver.service.abs;


import org.springframework.security.core.userdetails.UserDetailsService;
import uz.pdp.akshamnurserver.entity.User;
import uz.pdp.akshamnurserver.payload.ApiResult;
import uz.pdp.akshamnurserver.payload.SignDTO;
import uz.pdp.akshamnurserver.payload.TokenDTO;

import java.util.Optional;
import java.util.UUID;

public interface AuthService extends UserDetailsService {

    Optional<User> getUserById(UUID id);


    ApiResult<TokenDTO> signUp(SignDTO signDTO);

    ApiResult<TokenDTO> signIn(SignDTO signDTO);

    ApiResult<Boolean> setSmsCode(String sms,String phoneNum);
}
