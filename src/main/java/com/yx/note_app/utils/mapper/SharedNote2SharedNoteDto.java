package com.yx.note_app.utils.mapper;

import com.yx.note_app.dto.Dto;
import com.yx.note_app.dto.NoteDto;
import com.yx.note_app.dto.SharedNoteDto;
import com.yx.note_app.models.Model;
import com.yx.note_app.models.SharedNote;

public class SharedNote2SharedNoteDto implements Model2Dto<SharedNote, SharedNoteDto>{
    @Override
    public SharedNoteDto toResponse(SharedNote sharedNote) {
        SharedNoteDto sharedNoteDto = new SharedNoteDto();

        // convert note to noteDto
        Note2NoteDto note2NoteDto = new Note2NoteDto();
        NoteDto noteDto = note2NoteDto.toResponse(sharedNote.getNote());

        // set shared note dto
        sharedNoteDto.setId(sharedNote.getId());
        sharedNoteDto.setNote(noteDto);
        sharedNoteDto.setPermission(sharedNote.getPermission());

        return sharedNoteDto;
    }
}
