package com.yx.note_app.controllers;

import com.yx.note_app.services.service.LogInService;
import com.yx.note_app.services.service.SignUpService;
import com.yx.note_app.services.reponse.ApiResponse;
import com.yx.note_app.services.request.LoginRequest;
import com.yx.note_app.services.request.SignUpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private SignUpService signUpService;

    @Autowired
    private LogInService logInService;

    @PostMapping("/signup")
    public ApiResponse createUser(@RequestBody SignUpRequest signUpRequest) {
        return signUpService.execute(signUpRequest);
    }

    @PostMapping("/login")
    public ApiResponse verifyUser(@RequestBody LoginRequest loginRequest){
        return logInService.execute(loginRequest);
    }
}
