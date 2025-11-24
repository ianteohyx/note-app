package com.yx.note_app.repositories;

import com.yx.note_app.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer>{

    // Find by username for login
    Optional<User> findByUsername(String username);

    // Check if a username exists
    boolean existsByUsername(String username);

}
