package com.yx.note_app.models;

import jakarta.persistence.*;

import java.util.Objects;

@MappedSuperclass
public abstract class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object model) {
        if (this == model) return true;
        if (!(model instanceof Model otherModel)) return false;
        return Objects.equals(id, otherModel.id);
    }
}
