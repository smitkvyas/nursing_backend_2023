package com.quiz.nursing.models;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "question", nullable = false)
    private String question;

    @Column(name = "option_a", nullable = false)
    private String optionA;

    @Column(name = "option_b", nullable = false)
    private String optionB;

    @Column(name = "option_c", nullable = false)
    private String optionC;

    @Column(name = "option_d", nullable = false)
    private String optionD;

    @Column(name = "answer", nullable = false)
    private String answer;

    @Column(name = "subject")
    private Long subject;

    @Column(name = "field", nullable = false)
    private Long field;

    @Column(name = "topic")
    private Long topic;

    @Column(name = "created_on", nullable = false)
    private Timestamp createdOn;

    @Column(name = "updated_on", nullable = false)
    private Timestamp updatedOn;

    @Column(name = "created_by", nullable = false)
    private Long createdBy;

    @Column(name = "remarks")
    private String remarks;

    @Column(name = "status", nullable = false)
    private Long status;

    @Column(name = "language", nullable = false)
    private Long language;

    //<editor-fold desc="Getter - Setter">
    public Long getId() {
        return id;
    }

    public Question setId(Long id) {
        this.id = id;
        return this;
    }

    public String getQuestion() {
        return question;
    }

    public Question setQuestion(String question) {
        this.question = question;
        return this;
    }

    public String getOptionA() {
        return optionA;
    }

    public Question setOptionA(String optionA) {
        this.optionA = optionA;
        return this;
    }

    public String getOptionB() {
        return optionB;
    }

    public Question setOptionB(String optionB) {
        this.optionB = optionB;
        return this;
    }

    public String getOptionC() {
        return optionC;
    }

    public Question setOptionC(String optionC) {
        this.optionC = optionC;
        return this;
    }

    public String getOptionD() {
        return optionD;
    }

    public Question setOptionD(String optionD) {
        this.optionD = optionD;
        return this;
    }

    public String getAnswer() {
        return answer;
    }

    public Question setAnswer(String answer) {
        this.answer = answer;
        return this;
    }

    public Long getSubject() {
        return subject;
    }

    public Question setSubject(Long subject) {
        this.subject = subject;
        return this;
    }

    public Long getField() {
        return field;
    }

    public Question setField(Long field) {
        this.field = field;
        return this;
    }

    public Long getTopic() {
        return topic;
    }

    public Question setTopic(Long topic) {
        this.topic = topic;
        return this;
    }

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public Question setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public Timestamp getUpdatedOn() {
        return updatedOn;
    }

    public Question setUpdatedOn(Timestamp updatedOn) {
        this.updatedOn = updatedOn;
        return this;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public Question setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public String getRemarks() {
        return remarks;
    }

    public Question setRemarks(String remarks) {
        this.remarks = remarks;
        return this;
    }

    public Long getStatus() {
        return status;
    }

    public Question setStatus(Long status) {
        this.status = status;
        return this;
    }

    public Long getLanguage() {
        return language;
    }

    public Question setLanguage(Long language) {
        this.language = language;
        return this;
    }

    //</editor-fold>


    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", optionA='" + optionA + '\'' +
                ", optionB='" + optionB + '\'' +
                ", optionC='" + optionC + '\'' +
                ", optionD='" + optionD + '\'' +
                ", answer='" + answer + '\'' +
                ", subject=" + subject +
                ", field=" + field +
                ", topic=" + topic +
                ", createdOn=" + createdOn +
                ", updatedOn=" + updatedOn +
                ", createdBy=" + createdBy +
                ", remarks='" + remarks + '\'' +
                ", status=" + status +
                ", language='" + language + '\'' +
                '}';
    }
}
