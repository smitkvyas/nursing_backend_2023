package com.quiz.nursing.models;

import jakarta.persistence.*;

@Entity
@Table(name = "topics")
public class Topic {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "topic_name")
    private String name;

    public Long getId() {
        return id;
    }

    public Topic setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Topic setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
