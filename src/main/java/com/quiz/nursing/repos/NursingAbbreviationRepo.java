package com.quiz.nursing.repos;

import com.quiz.nursing.models.NursingAbbreviations;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface NursingAbbreviationRepo extends CrudRepository<NursingAbbreviations, Long> {

    ArrayList<NursingAbbreviations> findAllByStatus(int status);
}
