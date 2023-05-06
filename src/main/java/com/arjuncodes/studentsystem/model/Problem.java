package com.arjuncodes.studentsystem.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Objects;
@Entity
@Table(name = "problem")

public class Problem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public Problem() {
    }

    private String title;
    private String description;
    private String difficulty;
    private String hint;
    private String tags;

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Problem problem = (Problem) o;
        return id == problem.id && Objects.equals(title, problem.title) && Objects.equals(description, problem.description) && Objects.equals(difficulty, problem.difficulty) && Objects.equals(hint, problem.hint) && Objects.equals(tags, problem.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, difficulty, hint, tags);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Problem(String title, String description, String difficulty, String hint,String tags) {
        this.title = title;
        this.description = description;
        this.difficulty = difficulty;
        this.hint = hint;
        this.tags = tags;
    }
}
