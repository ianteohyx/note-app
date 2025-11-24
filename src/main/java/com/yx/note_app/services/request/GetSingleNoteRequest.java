package com.yx.note_app.services.request;

public class GetSingleNoteRequest extends ApiRequest{
    private Integer noteId;

    public Integer getNoteId() {
        return noteId;
    }

    public void setNoteId(Integer id) {
        this.noteId = id;
    }
}
