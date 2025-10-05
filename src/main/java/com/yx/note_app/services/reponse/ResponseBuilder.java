package com.yx.note_app.services.reponse;

import com.yx.note_app.enums.ResponseOutcome;

public class ResponseBuilder {
    private ApiResponse apiResponse;

    public void setResponseOutcome(ResponseOutcome responseOutcome){
        this.apiResponse.setResponseOutcome(responseOutcome);
    }

    public void resetBuilder(){
        this.apiResponse = new ApiResponse();
    }

}
