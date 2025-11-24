package com.yx.note_app.utils.mapper;

import com.yx.note_app.dto.Dto;
import com.yx.note_app.dto.NoteDto;
import com.yx.note_app.models.Note;

public class Note2NoteDto implements Model2Dto<Note, NoteDto> {
    @Override
    public NoteDto toResponse(Note note) {
        NoteDto noteDto = new NoteDto();
        noteDto.setId(note.getId());
        noteDto.setTitle(note.getTitle());
        noteDto.setContent(note.getContent());
        noteDto.setAuthorName(note.getAuthor().getUsername());
        noteDto.setDateCreated(note.getDateCreated());
        noteDto.setDateModified(note.getDateModified());
        return noteDto;
    }
}
