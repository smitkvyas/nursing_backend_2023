package com.quiz.nursing.models;

import jakarta.persistence.*;

@Entity
@Table(name = "fields")
public class Field {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "field_name")
    private String name;

    public Long getId() {
        return id;
    }

    public Field setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Field setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "Field{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
