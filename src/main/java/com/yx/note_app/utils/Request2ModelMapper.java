package com.yx.note_app.utils;

import com.yx.note_app.models.Model;
import com.yx.note_app.services.request.ApiRequest;

public interface Request2ModelMapper <TargetModel extends Model, TargetRequest extends ApiRequest>{
    TargetModel map(TargetRequest request);
}
