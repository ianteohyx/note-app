package com.yx.note_app.services.reponse;

import com.yx.note_app.enums.ResponseOutcome;
import com.yx.note_app.models.Model;
import com.yx.note_app.utils.Model2ResponseMapper;
import java.util.List;

public class ResponseDirectory {
    private static final ResponseBuilder responseBuilder = new ResponseBuilder();

    public static ApiResponse buildSuccessGetSingleResponse(Model model, Model2ResponseMapper<ApiResponse, Model> model2ResponseMapper) {
        responseBuilder.resetBuilder();
        ApiResponse response = model2ResponseMapper.mapSingle(model);
        responseBuilder.setResponseOutcome(ResponseOutcome.SUCCESS);
        return response;
    }

    public static ApiResponse buildSuccessGetManyResponse(List<Model> models, Model2ResponseMapper<ApiResponse, Model> model2ResponseMapper) {
        responseBuilder.resetBuilder();
        ApiResponse response = model2ResponseMapper.mapMany(models);
        response.setResponseOutcome(ResponseOutcome.SUCCESS);
        return response;
    }

    public static ApiResponse buildFailResponse(ResponseOutcome responseOutcome){
        responseBuilder.resetBuilder();
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setResponseOutcome(responseOutcome);
        return apiResponse;
    }

    public static ApiResponse buildSuccessResponse(){
        responseBuilder.resetBuilder();
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setResponseOutcome(ResponseOutcome.SUCCESS);
        return apiResponse;
    }
}
