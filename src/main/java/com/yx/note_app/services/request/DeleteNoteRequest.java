package com.yx.note_app.services.request;

public class DeleteNoteRequest extends ApiRequest{
    private Integer noteId;

    public Integer getNoteId() {
        return noteId;
    }

    public void setId(Integer id) {
        this.noteId = id;
    }
}
