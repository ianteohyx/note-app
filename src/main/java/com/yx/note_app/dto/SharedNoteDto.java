package com.yx.note_app.dto;

import com.yx.note_app.enums.Permission;

public class SharedNoteDto extends Dto{
    private NoteDto note;
    private Permission permission;

    public NoteDto getNote() {
        return note;
    }

    public void setNote(NoteDto note) {
        this.note = note;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }
}
