package com.yx.note_app.repositories;

import com.yx.note_app.models.Note;
import com.yx.note_app.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Integer>{
    // Find all notes by author
    List<Note> findByAuthor(User author);

    // Find notes by title containing keyword
    List<Note> findByTitleContainingIgnoreCase(String keyword);
}
