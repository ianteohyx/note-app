package com.yx.note_app.models;

import com.yx.note_app.models.compositekeys.SharedNoteId;
import jakarta.persistence.*;
import com.yx.note_app.enums.Permission;

@Entity
@Table(name = "SharedNote")
public class SharedNote {

    @EmbeddedId
    private SharedNoteId id;

    @ManyToOne
    @MapsId("noteId")
    @JoinColumn(name = "note_id")
    private Note note;

    @ManyToOne
    @MapsId("sharedToUserId")
    @JoinColumn(name = "shared_to_user_id")
    private User sharedToUser;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Permission permission;

    public SharedNote() {
    }

    public SharedNoteId getId() {
        return id;
    }

    public void setId(SharedNoteId id) {
        this.id = id;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    public User getSharedToUser() {
        return sharedToUser;
    }

    public void setSharedToUser(User sharedToUser) {
        this.sharedToUser = sharedToUser;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }
}
