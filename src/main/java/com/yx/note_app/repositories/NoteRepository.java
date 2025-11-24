package com.yx.note_app.repositories;

import com.yx.note_app.models.Note;
import com.yx.note_app.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Integer>{
    // Find all notes by author
    List<Note> findByAuthor(User author);

    // Find notes by id
    Note findById(int id);

    //Delete notes by id
    void deleteById(int id);

    // Update note by id
    @Modifying
    @Transactional
    @Query("UPDATE Note n SET n.title = :title, n.content = :content WHERE n.id = :id")
    void updateNote(
            @Param("id") int id,
            @Param("title") String title,
            @Param("content") String content
    );
}
