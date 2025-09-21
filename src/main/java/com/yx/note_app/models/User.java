package com.yx.note_app.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Note> notes;

    @OneToMany(mappedBy = "sharedToUser", cascade = CascadeType.ALL)
    private List<SharedNote> sharedNotes;

    public User() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public List<SharedNote> getSharedNotes() {
        return sharedNotes;
    }

    public void setSharedNotes(List<SharedNote> sharedNotes) {
        this.sharedNotes = sharedNotes;
    }
}
