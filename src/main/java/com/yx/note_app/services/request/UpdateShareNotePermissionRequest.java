package com.yx.note_app.services.request;

import com.yx.note_app.enums.Permission;

public class UpdateShareNotePermissionRequest extends ApiRequest{
    private String sharedToUsername;
    private Integer noteId;
    private Permission permission;

    public String getSharedToUsername() {
        return sharedToUsername;
    }

    public void setSharedToUsername(String shareToUsername) {
        this.sharedToUsername = shareToUsername;
    }

    public Integer getNoteId() {
        return noteId;
    }

    public void setNoteId(Integer noteId) {
        this.noteId = noteId;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }
}
