package com.quiz.nursing.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NursingAbbreviationServiceTest {

    @Autowired
    NursingAbbreviationService nursingAbbreviationService;

    @Test
    void getActiveAbbreviations() {
        nursingAbbreviationService.getActiveAbbreviations().forEach(System.out::println);
    }

    @Test
    void saveAbbreviation() {
        System.out.println(nursingAbbreviationService.saveAbbreviation("TIT", "This is test"));
    }
}