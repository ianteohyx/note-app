package com.yx.note_app.services;

import com.yx.note_app.enums.ResponseOutcome;
import com.yx.note_app.repositories.UserRepository;
import com.yx.note_app.services.reponse.ApiResponse;
import com.yx.note_app.services.reponse.ResponseDirectory;
import com.yx.note_app.services.request.SignUpRequest;
import com.yx.note_app.utils.Request2UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Objects;

@org.springframework.stereotype.Service
public class SignUpService extends Service<SignUpRequest, ApiResponse>{
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean paramCheck(SignUpRequest request) {
        return (!Objects.isNull(request) && !Objects.isNull(request.getUsername()) && !request.getUsername().isBlank() &&
                !Objects.isNull(request.getPassword()) && !request.getPassword().isBlank());
    }

    @Override
    public ApiResponse doService(SignUpRequest request) {
        if (userRepository.existsByUsername(request.getUsername())){
            System.out.println("username already exist");
            return ResponseDirectory.buildFailResponse(ResponseOutcome.USERNAME_EXIST);
        }

        if (request.getPassword().length() < 8){
            return ResponseDirectory.buildFailResponse(ResponseOutcome.PASSWORD_INVALID);
        }

        try {
            Request2UserMapper request2UserMapper = new Request2UserMapper();
            userRepository.save(request2UserMapper.map(request));
            System.out.println("successfully sign up user");
        }
        catch (Exception e){
            System.out.println("add to database fail");
            return ResponseDirectory.buildFailResponse(ResponseOutcome.PROCESS_FAIL);
        }

        return ResponseDirectory.buildSuccessResponse();
    }
}
