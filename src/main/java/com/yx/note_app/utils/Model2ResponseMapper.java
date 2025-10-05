package com.yx.note_app.utils;

import com.yx.note_app.models.Model;
import com.yx.note_app.models.User;
import com.yx.note_app.services.reponse.ApiResponse;

import java.util.List;

public interface Model2ResponseMapper <TargetResponse extends ApiResponse, TargetModel extends Model>{
    TargetResponse mapSingle(TargetModel model);

    TargetResponse mapMany(List<TargetModel> models);

}
