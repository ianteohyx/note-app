package com.yx.note_app.services.reponse;

import com.yx.note_app.enums.ResponseOutcome;

public class ResponseDirectory {

    public static ApiResponse buildFailResponse(ResponseOutcome responseOutcome){
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setResponseOutcome(responseOutcome);
        return apiResponse;
    }

    public static ApiResponse buildSuccessResponse(){
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setResponseOutcome(ResponseOutcome.SUCCESS);
        return apiResponse;
    }

}
