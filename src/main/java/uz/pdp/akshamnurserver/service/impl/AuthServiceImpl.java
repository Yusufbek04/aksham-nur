package uz.pdp.akshamnurserver.service.impl;

import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.pdp.akshamnurserver.entity.User;
import uz.pdp.akshamnurserver.payload.ApiResult;
import uz.pdp.akshamnurserver.payload.SignDTO;
import uz.pdp.akshamnurserver.payload.TokenDTO;
import uz.pdp.akshamnurserver.repository.UserRepository;
import uz.pdp.akshamnurserver.security.JwtTokenProvider;
import uz.pdp.akshamnurserver.service.abs.AuthService;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthServiceImpl implements AuthService {

    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;

    private final Map<String, String> smsCode = new HashMap<>();

    public AuthServiceImpl(JwtTokenProvider jwtTokenProvider,
                           @Lazy AuthenticationManager authenticationManager,
                           UserRepository userRepository) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> getUserById(UUID id) {
        return userRepository.findById(id);
    }

    @Override
    public ApiResult<TokenDTO> signUp(SignDTO signDTO) {
        return null;
    }

    @Override
    public ApiResult<TokenDTO> signIn(SignDTO signDTO) {
        return null;
    }

    @Override
    public ApiResult<Boolean> setSmsCode(String sms, String phoneNum) {
        if (sms.isBlank() || phoneNum.isBlank())
            return ApiResult.errorResponse();
        if (checkPhoneNumber(phoneNum))
            return ApiResult.errorResponse();

        return null;
    }

    private boolean checkPhoneNumber(String phoneNum) {
        if (phoneNum.length()!=12)
            return false;
        if (!phoneNum.startsWith("+998"))
            return false;
        return true;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository
                .findByPhoneNumber(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
