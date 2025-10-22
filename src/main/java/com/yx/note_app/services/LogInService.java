package com.yx.note_app.services;

import com.yx.note_app.enums.ResponseOutcome;
import com.yx.note_app.models.User;
import com.yx.note_app.repositories.UserRepository;
import com.yx.note_app.services.reponse.ApiResponse;
import com.yx.note_app.services.reponse.ResponseDirectory;
import com.yx.note_app.services.request.LoginRequest;
import com.yx.note_app.utils.DefaultLogger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;
import java.util.Optional;

@org.springframework.stereotype.Service
public class LogInService extends Service<LoginRequest, ApiResponse>{
    @Autowired
    private UserRepository userRepository;
    private final DefaultLogger logger = new DefaultLogger(this.getClass());

    @Override
    public boolean paramCheck(LoginRequest request) {
        return Objects.nonNull(request) && Objects.nonNull(request.getUsername()) && Objects.nonNull(request.getPassword());
    }

    @Override
    public ApiResponse doService(LoginRequest request) {
        try{
            Optional<User> actualUser = userRepository.findByUsername(request.getUsername());

            if (actualUser.isPresent() && request.getPassword().equals(actualUser.get().getPassword())) {
                logger.log("login success: " + request.getUsername());
                return ResponseDirectory.buildSuccessResponse();
            }

            logger.log("login fail: " + request.getUsername());
            return ResponseDirectory.buildFailResponse(ResponseOutcome.LOGIN_FAIL);
        }

        catch (Exception e){
            return ResponseDirectory.buildFailResponse(ResponseOutcome.PROCESS_FAIL);
        }
    }

}
