package com.yx.note_app.services.request;

public class GetSharedToUsersRequest extends ApiRequest{
    private Integer noteId;

    public Integer getNoteId() {
        return noteId;
    }

    public void setId(Integer noteId) {
        this.noteId = noteId;
    }
}
