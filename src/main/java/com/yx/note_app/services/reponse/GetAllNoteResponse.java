package com.yx.note_app.services.reponse;

import com.yx.note_app.dto.NoteDto;
import java.util.List;

public class GetAllNoteResponse extends ApiResponse {
    private List<NoteDto> notes;

    public List<NoteDto> getNotes() {
        return notes;
    }

    public void setNotes(List<NoteDto> notes) {
        this.notes = notes;
    }
}
