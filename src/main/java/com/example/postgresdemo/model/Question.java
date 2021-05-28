package com.example.postgresdemo.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "questions")
public class Question extends AuditModel {

    // @SequenceGenerator to generate question's id, but you could
    // also use PostgreSQL SERIAL: @GeneratedValue(strategy=GenerationType.IDENTITY
    // but @SequenceGenerator performs better in this case
    @Id
    @GeneratedValue
    @SequenceGenerator(
            name = "question_generator",
            sequenceName = "question_sequence",
            initialValue = 1000
    )
    private Long id;

    @NotBlank
    @Size(min = 3, max = 100)
    private String title;

    @Column(columnDefinition = "text")
    private String description;

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long newId) {
        id = newId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String newTitle) {
        title = newTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String newDesc) {
        description = newDesc;
    }
}
