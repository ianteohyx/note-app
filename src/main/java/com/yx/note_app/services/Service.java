package com.yx.note_app.services;

import com.yx.note_app.enums.ErrorCode;
import com.yx.note_app.services.reponse.ApiResponse;
import com.yx.note_app.services.request.ApiRequest;

public abstract class Service<Request extends ApiRequest, Response extends ApiResponse> {
     public abstract Response doService(Request request);
     public abstract boolean paramCheck(Request request);

     public ApiResponse execute(Request request){
         if (!paramCheck(request)){
             ApiResponse response = new ApiResponse();
             response.setSuccess(false);
             response.setErrorCode(ErrorCode.PARAM_ILLEGAL.getCode());
             response.setErrorDesc(ErrorCode.PARAM_ILLEGAL.getDesc());
             return response;
         }

         else{
             return doService(request);
         }
     }
}
