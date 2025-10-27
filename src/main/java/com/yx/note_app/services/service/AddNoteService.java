package com.yx.note_app.services.service;

import com.yx.note_app.models.Note;
import com.yx.note_app.repositories.NoteRepository;
import com.yx.note_app.services.reponse.ApiResponse;
import com.yx.note_app.services.reponse.ResponseDirectory;
import com.yx.note_app.services.request.AddNoteRequest;
import com.yx.note_app.utils.log.DefaultLogger;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Objects;

@org.springframework.stereotype.Service
public class AddNoteService extends Service<AddNoteRequest, ApiResponse>{
    @Autowired
    private NoteRepository noteRepository;

    private final DefaultLogger logger = new DefaultLogger(this.getClass());

    @Override
    public ApiResponse doService(AddNoteRequest request) {
        request.setAuthor(getUserUsingTheService());
        noteRepository.save(buildNote(request));
        logger.log(getUserUsingTheService().getUsername() + " added a note with title: " + request.getTitle());
        return ResponseDirectory.buildSuccessResponse();
    }

    @Override
    public boolean paramCheck(AddNoteRequest request) {
        return super.paramCheck(request) && Objects.nonNull(request.getToken()) && Objects.nonNull(request.getTitle()) && Objects.nonNull(request.getContent());
    }

    @Override
    public void determineIfNeedTokenValidation() {
        setNeedTokenValidation(true);
    }

    public Note buildNote(AddNoteRequest request) {
        Note note = new Note();
        note.setTitle(request.getTitle());
        note.setContent(request.getContent());
        note.setAuthor(request.getAuthor());

        return note;
    }
}
