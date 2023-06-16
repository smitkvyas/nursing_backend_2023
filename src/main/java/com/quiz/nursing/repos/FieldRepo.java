package com.quiz.nursing.repos;

import com.quiz.nursing.models.Field;
import com.quiz.nursing.models.Subject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FieldRepo extends CrudRepository<Field,Long> {
    List<Field> findByNameIgnoreCase(String name);
}
