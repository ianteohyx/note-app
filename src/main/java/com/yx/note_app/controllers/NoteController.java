package com.yx.note_app.controllers;

import com.yx.note_app.services.request.ApiRequest;
import com.yx.note_app.services.service.AddNoteService;
import com.yx.note_app.services.reponse.ApiResponse;
import com.yx.note_app.services.request.AddNoteRequest;
import com.yx.note_app.services.service.GetAllNotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/note")
public class NoteController {
    @Autowired
    private AddNoteService addNoteService;

    @Autowired
    private GetAllNotesService getAllNotesService;

    @PostMapping("/add")
    public ApiResponse createNote(@RequestBody AddNoteRequest addNoteRequest) {
        return addNoteService.execute(addNoteRequest);
    }

    @GetMapping("/get")
    public ApiResponse getAllNotes(@RequestBody ApiRequest apiRequest){
        return getAllNotesService.execute(apiRequest);
    }
}
