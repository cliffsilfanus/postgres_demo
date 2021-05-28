package com.example.postgresdemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

@Entity
@Table(name = "answers")
public class Answer extends AuditModel {
    @Id
    @GeneratedValue(generator = "answer_generator")
    @SequenceGenerator(
            name = "answer_generator",
            sequenceName = "answer_sequence",
            initialValue = 1000
    )
    private Long id;

    @Column(columnDefinition = "text")
    private String text;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "question_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Question question;

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long newId) {
        id = newId;
    }

    public String getText() {
        return text;
    }

    public void setText(String newText) {
        text = newText;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question newQuestion) {
        question = newQuestion;
    }
}
