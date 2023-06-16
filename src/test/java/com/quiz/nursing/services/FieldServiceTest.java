package com.quiz.nursing.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class FieldServiceTest {

    @Autowired
    private FieldService fieldService;
    @Test
    void saveNewField() {
        System.out.println(fieldService.saveNewField("Test"));
    }

    @Test
    void getAllFields() {
        fieldService.getAllFields().forEach(System.out::println);
    }
}