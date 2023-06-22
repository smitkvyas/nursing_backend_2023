package com.quiz.nursing.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class QuestionServiceTest {

    @Autowired
    private QuestionService questionService;

    @Test
    void saveNewQuestion() {
        System.out.println(questionService.saveNewQuestion("Test Q", "OA", "OB",
                "OC", "OD", "A", 1L));
    }

    @Test
    void getQuestionFor() {
        questionService.getQuestionFor(1L).forEach(System.out::println);
    }

    @Test
    void getQuestionForQuiz() {
        questionService.getQuestionFroQuiz(1L, 20).forEach(System.out::println);
    }
}