package com.quiz.nursing.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SubjectServiceTest {

    @Autowired
    private SubjectService subjectService;

    @Test
    void saveNewSubject() {
        System.out.println(subjectService.saveNewSubject("Nursing"));
    }

    @Test
    void getAllSubjects() {
        subjectService.getAllSubjects().forEach(System.out::println);
    }
}