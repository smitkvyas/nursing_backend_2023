package com.quiz.nursing.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NursingActsServiceTest {

    @Autowired
    private NursingActsService nursingActsService;

    @Test
    void getActiveActs() {
        nursingActsService.getActiveActs().forEach(System.out::println);
    }

    @Test
    void saveAct() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(nursingActsService.saveAct("Test act", "1999"));
        }
    }
}