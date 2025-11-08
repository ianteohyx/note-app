package com.yx.note_app.services.reponse;

import com.yx.note_app.dto.SharedNoteDto;
import java.util.List;

public class GetAllSharedToMeResponse extends ApiResponse{
    List<SharedNoteDto> sharedNotes;

    public List<SharedNoteDto> getSharedNotes() {
        return sharedNotes;
    }

    public void setSharedNotes(List<SharedNoteDto> sharedNotes) {
        this.sharedNotes = sharedNotes;
    }
}
