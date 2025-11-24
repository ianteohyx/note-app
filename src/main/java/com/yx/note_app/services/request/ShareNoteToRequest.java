package com.yx.note_app.services.request;

import com.yx.note_app.enums.Permission;

public class ShareNoteToRequest extends ApiRequest{
    private Integer noteId;
    private String sharedToUsername;
    private Permission permission;

    public Integer getNoteId() {
        return noteId;
    }

    public void setNoteId(Integer noteId) {
        this.noteId = noteId;
    }

    public String getSharedToUsername() {
        return sharedToUsername;
    }

    public void setSharedToUsername(String sharedToUsername) {
        this.sharedToUsername = sharedToUsername;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }
}
