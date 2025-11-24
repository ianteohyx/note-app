package com.yx.note_app.services.reponse;

import com.yx.note_app.enums.ResponseOutcome;

public class ApiResponse{
    private ResponseOutcome responseOutcome;

    public void setResponseOutcome(ResponseOutcome responseOutcome) {
        this.responseOutcome = responseOutcome;
    }

    public ResponseOutcome getResponseOutcome() {
        return responseOutcome;
    }
}
