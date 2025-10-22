package com.yx.note_app.services;

import com.yx.note_app.enums.ResponseOutcome;
import com.yx.note_app.repositories.UserRepository;
import com.yx.note_app.services.reponse.ApiResponse;
import com.yx.note_app.services.reponse.ResponseDirectory;
import com.yx.note_app.services.request.SignUpRequest;
import com.yx.note_app.utils.DefaultLogger;
import com.yx.note_app.utils.Request2UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Objects;

@org.springframework.stereotype.Service
public class SignUpService extends Service<SignUpRequest, ApiResponse>{
    @Autowired
    private UserRepository userRepository;

    private final DefaultLogger logger = new DefaultLogger(this.getClass());

    @Override
    public boolean paramCheck(SignUpRequest request) {
        return (!Objects.isNull(request) && !Objects.isNull(request.getUsername()) && !request.getUsername().isBlank() &&
                !Objects.isNull(request.getPassword()) && !request.getPassword().isBlank());
    }

    @Override
    public ApiResponse doService(SignUpRequest request) {
        if (userRepository.existsByUsername(request.getUsername())){
            logger.log("username already exist: " + request.getUsername());
            return ResponseDirectory.buildFailResponse(ResponseOutcome.USERNAME_EXIST);
        }

        if (request.getPassword().length() < 8){
            logger.log("password is invalid: " + request.getUsername());
            return ResponseDirectory.buildFailResponse(ResponseOutcome.PASSWORD_INVALID);
        }

        try {
            Request2UserMapper request2UserMapper = new Request2UserMapper();
            userRepository.save(request2UserMapper.map(request));
            logger.log("successfully sign up: " + request.getUsername());
            return ResponseDirectory.buildSuccessResponse();
        }
        catch (Exception e){
            logger.log("add to database fail: " + request.getUsername());
            return ResponseDirectory.buildFailResponse(ResponseOutcome.PROCESS_FAIL);
        }
    }
}
