package com.yx.note_app.utils;

import com.yx.note_app.models.User;
import com.yx.note_app.services.reponse.ApiResponse;
import java.util.List;

public class User2ResponseMapper implements Model2ResponseMapper <ApiResponse, User>{

    @Override
    public ApiResponse mapSingle(User user) {
        return null;
    }

    @Override
    public ApiResponse mapMany(List<User> users) {
        return null;
    }

}
