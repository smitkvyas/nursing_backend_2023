package com.quiz.nursing.models;


import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "quizzes")
public class Quiz {
    private long id;
    private String questionIds;
    private int type;
    private Timestamp createdOn;
    private Timestamp activeTill;
    private Timestamp activeFrom;
    private int status;
    private String description;
    private String title;

    //<editor-fold desc="Getter - Setter">
    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public Quiz setId(long id) {
        this.id = id;
        return this;
    }

    @Basic
    @Column(name = "question_ids")
    public String getQuestionIds() {
        return questionIds;
    }

    public Quiz setQuestionIds(String questionIds) {
        this.questionIds = questionIds;
        return this;
    }

    @Basic
    @Column(name = "type")
    public int getType() {
        return type;
    }

    public Quiz setType(int type) {
        this.type = type;
        return this;
    }

    @Basic
    @Column(name = "created_on")
    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public Quiz setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    @Basic
    @Column(name = "active_till")
    public Timestamp getActiveTill() {
        return activeTill;
    }

    public Quiz setActiveTill(Timestamp activeTill) {
        this.activeTill = activeTill;
        return this;
    }

    @Basic
    @Column(name = "active_from")
    public Timestamp getActiveFrom() {
        return activeFrom;
    }

    public Quiz setActiveFrom(Timestamp activeFrom) {
        this.activeFrom = activeFrom;
        return this;
    }

    @Basic
    @Column(name = "status")
    public int getStatus() {
        return status;
    }

    public Quiz setStatus(int status) {
        this.status = status;
        return this;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public Quiz setDescription(String description) {
        this.description = description;
        return this;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public Quiz setTitle(String title) {
        this.title = title;
        return this;
    }
    //</editor-fold>

    @Override
    public String toString() {
        return "Quiz{" +
                "id=" + id +
                ", questionIds='" + questionIds + '\'' +
                ", type=" + type +
                ", createdOn=" + createdOn +
                ", activeTill=" + activeTill +
                ", activeFrom=" + activeFrom +
                ", status=" + status +
                ", description='" + description + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}