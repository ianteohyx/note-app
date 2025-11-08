package com.yx.note_app.services.reponse;

import com.yx.note_app.dto.SharedNoteDto;

public class GetSingleSharedNoteResponse extends ApiResponse{
    private SharedNoteDto sharedNote;

    public SharedNoteDto getSharedNote() {
        return sharedNote;
    }

    public void setSharedNote(SharedNoteDto sharedNote) {
        this.sharedNote = sharedNote;
    }
}
