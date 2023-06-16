package com.quiz.nursing.repos;

import com.quiz.nursing.models.Field;
import com.quiz.nursing.models.Topic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicRepo extends CrudRepository<Topic,Long> {
    List<Topic> findByNameIgnoreCase(String name);
}
