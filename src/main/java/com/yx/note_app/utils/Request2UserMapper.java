package com.yx.note_app.utils;

import com.yx.note_app.models.Model;
import com.yx.note_app.models.User;
import com.yx.note_app.services.request.ApiRequest;
import com.yx.note_app.services.request.SignUpRequest;

public class Request2UserMapper implements Request2ModelMapper <User, SignUpRequest>{

    @Override
    public User map(SignUpRequest request) {
        User newUser = new User();
        newUser.setUsername(request.getUsername());
        newUser.setPassword(request.getPassword());
        return newUser;
    }
}
