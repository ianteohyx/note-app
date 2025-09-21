package com.yx.note_app.models.compositekeys;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SharedNoteId implements Serializable {
    private int noteId;
    private int sharedToUserId;

    public SharedNoteId() {}
    public SharedNoteId(int noteId, int sharedToUserId) {
        this.noteId = noteId;
        this.sharedToUserId = sharedToUserId;
    }

    // equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SharedNoteId)) return false;
        SharedNoteId that = (SharedNoteId) o;
        return noteId == that.noteId && sharedToUserId == that.sharedToUserId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(noteId, sharedToUserId);
    }
}
