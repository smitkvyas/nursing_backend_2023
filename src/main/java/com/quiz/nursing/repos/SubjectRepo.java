package com.quiz.nursing.repos;

import com.quiz.nursing.models.Subject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubjectRepo extends CrudRepository<Subject,Long> {
    List<Subject> findByNameIgnoreCase(String name);
}
