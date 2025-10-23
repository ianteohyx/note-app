package com.yx.note_app.services.reponse;

public class LoginResponse extends ApiResponse{
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
