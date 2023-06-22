package com.quiz.nursing.services;

import com.quiz.nursing.models.Topic;
import com.quiz.nursing.repos.TopicRepo;
import com.quiz.nursing.util.StatusResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {

    private static final Logger logger = LogManager.getLogger(TopicService.class);


    @Autowired
    private final TopicRepo topicRepo;

    public TopicService(TopicRepo subjectRepo) {
        this.topicRepo = subjectRepo;
    }

    public StatusResponse saveNewTopic(String name) {
        List<Topic> topics = topicRepo.findByNameIgnoreCase(name);
        if (topics.isEmpty()) {
            Topic savedTopic = topicRepo.save(new Topic().setName(name));
            return new StatusResponse().setSuccess(savedTopic);
        }

        return new StatusResponse().setMessage("Topic " + name + " already exists");
    }

    public Iterable<Topic> getAllTopics(){
        return topicRepo.findAll();
    }
}
