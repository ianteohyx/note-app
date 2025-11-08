package com.yx.note_app.services.request;

import com.yx.note_app.dto.NoteDto;

public class UpdateNoteRequest extends ApiRequest{
    private Integer noteId;
    private String noteTitle;
    private String noteContent;

    public Integer getNoteId() {
        return noteId;
    }

    public void setNoteId(Integer notId) {
        this.noteId = notId;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public String getNoteContent() {
        return noteContent;
    }

    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }
}
