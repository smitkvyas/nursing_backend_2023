package com.quiz.nursing.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class QuizServiceTest {

    @Autowired
    QuizService quizService;

    @Test
    void createQuiz() {
        System.out.println(quizService.createQuiz(1L, 20));
    }
}