package com.yx.note_app.services.request;

public class GetSingleSharedNoteRequest extends ApiRequest{
    private Integer sharedNoteId;

    public Integer getSharedNoteId() {
        return sharedNoteId;
    }

    public void setSharedNoteId(Integer sharedNoteId) {
        this.sharedNoteId = sharedNoteId;
    }
}
