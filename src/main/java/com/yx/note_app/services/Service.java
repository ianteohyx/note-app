package com.yx.note_app.services;

import com.yx.note_app.enums.ResponseOutcome;
import com.yx.note_app.services.reponse.ApiResponse;
import com.yx.note_app.services.reponse.ResponseDirectory;
import com.yx.note_app.services.request.ApiRequest;

public abstract class Service<Request extends ApiRequest, Response extends ApiResponse> {
     public abstract Response doService(Request request);
     public abstract boolean paramCheck(Request request);

     public ApiResponse execute(Request request){
         if (!paramCheck(request)){
             return ResponseDirectory.buildFailResponse(ResponseOutcome.PARAM_ILLEGAL);
         }

         else{
             return doService(request);
         }
     }
}
