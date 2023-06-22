package com.quiz.nursing.models;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "nursing_acts")
public class NursingActs {
    private int id;
    private String year;
    private String act;
    private Timestamp createdOn;
    private Timestamp updatedOn;
    private int status;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public NursingActs setId(int id) {
        this.id = id;
        return this;
    }

    @Basic
    @Column(name = "year")
    public String getYear() {
        return year;
    }

    public NursingActs setYear(String year) {
        this.year = year;
        return this;
    }

    @Basic
    @Column(name = "act")
    public String getAct() {
        return act;
    }

    public NursingActs setAct(String act) {
        this.act = act;
        return this;
    }

    @Basic
    @Column(name = "created_on")
    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public NursingActs setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    @Basic
    @Column(name = "updated_on")
    public Timestamp getUpdatedOn() {
        return updatedOn;
    }

    public NursingActs setUpdatedOn(Timestamp updatedOn) {
        this.updatedOn = updatedOn;
        return this;
    }

    @Basic
    @Column(name = "status")
    public int getStatus() {
        return status;
    }

    public NursingActs setStatus(int status) {
        this.status = status;
        return this;
    }

    @Override
    public String toString() {
        return "NursingActs{" +
                "id=" + id +
                ", year='" + year + '\'' +
                ", act='" + act + '\'' +
                ", createdOn=" + createdOn +
                ", updatedOn=" + updatedOn +
                ", status=" + status +
                '}';
    }
}
