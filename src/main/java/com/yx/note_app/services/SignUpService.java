package com.yx.note_app.services;

import com.yx.note_app.enums.ErrorCode;
import com.yx.note_app.models.User;
import com.yx.note_app.repositories.UserRepository;
import com.yx.note_app.services.reponse.SignUpResponse;
import com.yx.note_app.services.request.SignUpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Objects;
import java.util.Optional;

@org.springframework.stereotype.Service
public class SignUpService extends Service<SignUpRequest, SignUpResponse>{
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean paramCheck(SignUpRequest request) {
        return (!Objects.isNull(request) && !Objects.isNull(request.getUsername()) && !request.getUsername().isBlank() &&
                !Objects.isNull(request.getPassword()) && !request.getPassword().isBlank());
    }

    @Override
    public SignUpResponse doService(SignUpRequest request) {
        if (userRepository.existsByUsername(request.getUsername())){
            return buildSuccessSignUpResponse(request.getUsername(), false, ErrorCode.USERNAME_EXIST);
        }

        if (request.getPassword().length() < 8){
            return buildSuccessSignUpResponse(request.getUsername(), false, ErrorCode.PASSWORD_INVALID);
        }

        try {
            userRepository.save(buildNewUser(request));
        }
        catch (Exception e){
            return buildSuccessSignUpResponse(request.getUsername(), false, ErrorCode.PROCESS_FAIL);
        }

        return buildSuccessSignUpResponse(request.getUsername(), true, null);
    }

    public User buildNewUser(SignUpRequest request){
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        return user;
    }

    public SignUpResponse buildSuccessSignUpResponse(String username, boolean success, ErrorCode errorCode){
        SignUpResponse signUpResponse = new SignUpResponse();
        signUpResponse.setSuccess(success);
        signUpResponse.setUsername(username);
        Optional.ofNullable(errorCode).ifPresent(err -> signUpResponse.setErrorCode(err.getCode()));
        Optional.ofNullable(errorCode).ifPresent(err -> signUpResponse.setErrorDesc(err.getDesc()));
        return signUpResponse;
    }
}
