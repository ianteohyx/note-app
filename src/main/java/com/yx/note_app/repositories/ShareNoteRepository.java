package com.yx.note_app.repositories;

import com.yx.note_app.enums.Permission;
import com.yx.note_app.models.SharedNote;
import com.yx.note_app.models.User;
import com.yx.note_app.models.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ShareNoteRepository extends JpaRepository<SharedNote, Integer>{
    // Find all notes shared to a specific user
    List<SharedNote> findBySharedToUser(User user);

    // Find a specific shared note
    SharedNote findById(int id);

    // Find a specific shared note base on user & note
    SharedNote findByNoteIdAndSharedToUserId(int noteId, int sharedToUserId);

    // Delete by Id
    void deleteById(int id);

    // Check if duplicate exist
    boolean existsByNoteIdAndSharedToUserId(int noteId, int sharedToUserId);

    // Update permission of shared note
    @Modifying
    @Transactional
    @Query("UPDATE SharedNote n SET n.permission = :permission WHERE n.id = :id")
    void updateSharedNotePermission(
            @Param("id") int id,
            @Param("permission") Permission permission
    );
}
