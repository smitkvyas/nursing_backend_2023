package com.quiz.nursing.repos;

import com.quiz.nursing.models.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepo extends CrudRepository<Question,Long> {
    List<Question> findByFieldAndStatusAndLanguage(Long field, Long status, Long language);
    List<Question> findByField(Long field);
}
