package com.yx.note_app.services.service;

import com.yx.note_app.enums.ResponseOutcome;
import com.yx.note_app.models.User;
import com.yx.note_app.repositories.UserRepository;
import com.yx.note_app.services.reponse.ApiResponse;
import com.yx.note_app.services.reponse.ResponseDirectory;
import com.yx.note_app.services.request.ApiRequest;
import com.yx.note_app.utils.log.DefaultLogger;
import com.yx.note_app.utils.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;
import java.util.Optional;

public abstract class Service<Request extends ApiRequest, Response extends ApiResponse> {
     private boolean needTokenValidation;
     private User userUsingTheService;
     private final DefaultLogger logger = new DefaultLogger(this.getClass());

     @Autowired
     protected JwtUtils jwtUtils;
     @Autowired
     private UserRepository userRepository;

     public abstract Response doService(Request request);
     public abstract void determineIfNeedTokenValidation();

    public boolean paramCheck(Request request){return Objects.nonNull(request);}

    private boolean isNeedTokenValidation() {
        return needTokenValidation;
    }

    public void setNeedTokenValidation(boolean needTokenValidation) {
        this.needTokenValidation = needTokenValidation;
    }

    public void setUserUsingTheService(String token){
        String username = jwtUtils.getUsernameFromToken(token);
        Optional<User> user = userRepository.findByUsername(username);
        user.ifPresent(value -> userUsingTheService = value);
    }

    public User getUserUsingTheService() {
        return userUsingTheService;
    }

    public ApiResponse execute(Request request){
         determineIfNeedTokenValidation();
         if (isNeedTokenValidation()){
             try {
                 jwtUtils.validateToken(request.getToken());
                 setUserUsingTheService(request.getToken());
             }
             catch (Exception e){
                 System.out.println(e.getMessage());
                 logger.log(e.getMessage());
                 return ResponseDirectory.buildFailResponse(ResponseOutcome.TOKEN_INVALID);
             }
         }

         if (!paramCheck(request)){
             return ResponseDirectory.buildFailResponse(ResponseOutcome.PARAM_ILLEGAL);
         }

         else{
             try {
                 return doService(request);
             }

             catch (Exception e){
                 System.out.println(e.getMessage());
                 logger.log(e.getMessage());
                 return ResponseDirectory.buildFailResponse(ResponseOutcome.PROCESS_FAIL);
             }
         }
     }
}
