package com.yx.note_app.services.reponse;

import com.yx.note_app.dto.NoteDto;

public class GetSingleNoteResponse extends ApiResponse{
    private NoteDto noteDto;

    public NoteDto getNoteDto() {
        return noteDto;
    }

    public void setNoteDto(NoteDto noteDto) {
        this.noteDto = noteDto;
    }
}
