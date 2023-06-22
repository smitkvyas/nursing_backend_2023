package com.quiz.nursing.repos;

import com.quiz.nursing.models.Question;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface QuestionRepo extends CrudRepository<Question, Long> {
    List<Question> findByFieldAndStatusAndLanguage(Long field, Long status, Long language);

    List<Question> findByField(Long field);

    List<Question> findByFieldAndLastAddedInQuizBeforeOrLastAddedInQuizIsNull(Long field, Timestamp endTime, Pageable pageable);
}
