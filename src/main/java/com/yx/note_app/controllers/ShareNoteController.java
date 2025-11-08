package com.yx.note_app.controllers;

import com.yx.note_app.services.reponse.ApiResponse;
import com.yx.note_app.services.request.*;
import com.yx.note_app.services.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/shared")
public class ShareNoteController {

    @Autowired
    ShareNoteToOthersService shareNoteToOthersService;

    @Autowired
    GetAllSharedToMeService getAllSharedToMeService;

    @Autowired
    GetSingleSharedNoteService getSingleSharedNoteService;

    @Autowired
    EditSharedNoteService editSharedNoteService;

    @Autowired
    GetSharedToUsersService getSharedToUsersService;

    @Autowired
    UnshareNoteService unshareNoteService;

    @Autowired
    UpdateShareNotePermissionService updateShareNotePermissionService;

    @PostMapping("/toOther")
    public ApiResponse shareToOther(@RequestBody ShareNoteToRequest shareNoteToRequest) {
        return shareNoteToOthersService.execute(shareNoteToRequest);
    }

    @GetMapping("/getAllSharedToMe")
    public ApiResponse getAllSharedToMe(@RequestBody ApiRequest request){
        return getAllSharedToMeService.execute(request);
    }

    @GetMapping("/getSingleSharedNote")
    public ApiResponse getSingleSharedNote(@RequestBody GetSingleSharedNoteRequest request){
        return getSingleSharedNoteService.execute(request);
    }

    @PatchMapping("/editSharedNote")
    public ApiResponse editSharedNote(@RequestBody EditShareNoteRequest request){
        return editSharedNoteService.execute(request);
    }

    @GetMapping("/getAllSharedToUser")
    public ApiResponse getSharedToUser(@RequestBody GetSharedToUsersRequest request){
        return getSharedToUsersService.execute(request);
    }

    @DeleteMapping("/unshareUser")
    public ApiResponse unshareNote(@RequestBody UnshareNoteRequest request){
        return unshareNoteService.execute(request);
    }

    @PatchMapping("/updatePermission")
    public ApiResponse updatePermission(@RequestBody UpdateShareNotePermissionRequest request){
        return updateShareNotePermissionService.execute(request);
    }

}
