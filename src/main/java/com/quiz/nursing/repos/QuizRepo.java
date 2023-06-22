package com.quiz.nursing.repos;

import com.quiz.nursing.models.Quiz;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.ArrayList;

@Repository
public interface QuizRepo extends CrudRepository<Quiz, Long> {

    ArrayList<Quiz> findByActiveFromBetweenAndTypeAndStatus(Timestamp start, Timestamp end, int type, int status);
}
