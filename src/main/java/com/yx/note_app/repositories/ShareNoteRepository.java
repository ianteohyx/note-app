package com.yx.note_app.repositories;

import com.yx.note_app.models.SharedNote;
import com.yx.note_app.models.compositekeys.SharedNoteId;
import com.yx.note_app.models.User;
import com.yx.note_app.models.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ShareNoteRepository extends JpaRepository<SharedNote, SharedNoteId>{
    // Find all notes shared to a specific user
    List<SharedNote> findBySharedToUser(User user);

    // Find all users a note has been shared with
    List<SharedNote> findByNote(Note note);
}
