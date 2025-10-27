package com.yx.note_app.utils.mapper;

import com.yx.note_app.dto.Dto;
import com.yx.note_app.models.Model;

public interface Model2Dto<TargetModel extends Model, TargetDto extends Dto> {
    Dto toResponse(TargetModel model);
}
