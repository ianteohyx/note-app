package com.yx.note_app.controllers;

import com.yx.note_app.services.request.*;
import com.yx.note_app.services.service.*;
import com.yx.note_app.services.reponse.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/note")
public class NoteController {
    @Autowired
    private AddNoteService addNoteService;

    @Autowired
    private GetAllNotesService getAllNotesService;

    @Autowired
    private GetSingleNoteService getSingleNoteService;

    @Autowired
    private UpdateNoteService updateNoteService;

    @Autowired
    private DeleteNoteService deleteNoteService;

    @PostMapping("/add")
    public ApiResponse createNote(@RequestBody AddNoteRequest addNoteRequest) {
        return addNoteService.execute(addNoteRequest);
    }

    @GetMapping("/getAll")
    public ApiResponse getAllNotes(@RequestBody ApiRequest apiRequest){
        return getAllNotesService.execute(apiRequest);
    }

    @GetMapping("/getSingle")
    public ApiResponse getNoteById(@RequestBody GetSingleNoteRequest getSingleNoteRequest) {
        return getSingleNoteService.execute(getSingleNoteRequest);
    }

    @PatchMapping("/update")
    public ApiResponse updateNoteById(@RequestBody UpdateNoteRequest updateNoteRequest) {
        return updateNoteService.execute(updateNoteRequest);
    }

    @DeleteMapping("/delete")
    public ApiResponse deleteNoteById(@RequestBody DeleteNoteRequest deleteNoteRequest) {
        return deleteNoteService.execute(deleteNoteRequest);
    }
}
