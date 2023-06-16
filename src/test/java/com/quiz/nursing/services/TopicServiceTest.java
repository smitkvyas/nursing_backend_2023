package com.quiz.nursing.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TopicServiceTest {

    @Autowired
    private TopicService topicService;

    @Test
    void saveNewTopic() {
        topicService.saveNewTopic("test");
    }

    @Test
    void getAllTopics() {
        topicService.getAllTopics().forEach(System.out::println);
    }
}