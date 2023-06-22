package com.quiz.nursing.models;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "nursing_abbreviations")
public class NursingAbbreviations {
    private int id;
    private String shortForm;
    private String fullForm;
    private Timestamp createdOn;
    private Timestamp updatedOn;
    private int status;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public NursingAbbreviations setId(int id) {
        this.id = id;
        return this;
    }

    @Basic
    @Column(name = "short_form")
    public String getShortForm() {
        return shortForm;
    }

    public NursingAbbreviations setShortForm(String shortForm) {
        this.shortForm = shortForm;
        return this;
    }

    @Basic
    @Column(name = "full_form")
    public String getFullForm() {
        return fullForm;
    }

    public NursingAbbreviations setFullForm(String fullForm) {
        this.fullForm = fullForm;
        return this;
    }

    @Basic
    @Column(name = "created_on")
    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public NursingAbbreviations setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    @Basic
    @Column(name = "updated_on")
    public Timestamp getUpdatedOn() {
        return updatedOn;
    }

    public NursingAbbreviations setUpdatedOn(Timestamp updatedOn) {
        this.updatedOn = updatedOn;
        return this;
    }

    @Basic
    @Column(name = "status")
    public int getStatus() {
        return status;
    }

    public NursingAbbreviations setStatus(int status) {
        this.status = status;
        return this;
    }

    @Override
    public String toString() {
        return "NursingAbbreviations{" +
                "id=" + id +
                ", shortForm='" + shortForm + '\'' +
                ", fullForm='" + fullForm + '\'' +
                ", createdOn=" + createdOn +
                ", updatedOn=" + updatedOn +
                ", status=" + status +
                '}';
    }
}
