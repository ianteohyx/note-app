package com.yx.note_app.services;

import com.yx.note_app.enums.ResponseOutcome;
import com.yx.note_app.services.reponse.ApiResponse;
import com.yx.note_app.services.reponse.ResponseDirectory;
import com.yx.note_app.services.request.ApiRequest;
import com.yx.note_app.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class Service<Request extends ApiRequest, Response extends ApiResponse> {
     private boolean needTokenValidation;
     private String userUsingTheService;

     @Autowired
     protected JwtUtils jwtUtils;

     public abstract Response doService(Request request);
     public abstract boolean paramCheck(Request request);
     public abstract void determineIfNeedTokenValidation();

    private boolean isNeedTokenValidation() {
        return needTokenValidation;
    }

    public void setNeedTokenValidation(boolean needTokenValidation) {
        this.needTokenValidation = needTokenValidation;
    }

    public void setUserUsingTheService(String token){
        userUsingTheService = jwtUtils.getUsernameFromToken(token);
    }

    public String getUserUsingTheService() {
        return userUsingTheService;
    }

    public ApiResponse execute(Request request){
         if (isNeedTokenValidation()){
             setUserUsingTheService(request.getToken());
             if (!jwtUtils.validateToken(request.getToken())) {
                 return ResponseDirectory.buildFailResponse(ResponseOutcome.TOKEN_INVALID);
             }
         }

         if (!paramCheck(request)){
             return ResponseDirectory.buildFailResponse(ResponseOutcome.PARAM_ILLEGAL);
         }

         else{
             return doService(request);
         }
     }
}
