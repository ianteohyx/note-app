package com.yx.note_app.controllers;

import com.yx.note_app.models.User;
import com.yx.note_app.services.SignUpService;
import com.yx.note_app.services.reponse.ApiResponse;
import com.yx.note_app.services.reponse.SignUpResponse;
import com.yx.note_app.services.request.SignUpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private SignUpService signUpService;

    @PostMapping("/signup")
    public ApiResponse createUser(@RequestBody User user) {
        SignUpRequest request = new SignUpRequest();
        request.setUsername(user.getUsername());
        request.setPassword(user.getPassword());

        return signUpService.execute(request);
    }
}
