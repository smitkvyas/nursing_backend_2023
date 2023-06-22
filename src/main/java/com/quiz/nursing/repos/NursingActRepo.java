package com.quiz.nursing.repos;

import com.quiz.nursing.models.NursingActs;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface NursingActRepo extends CrudRepository<NursingActs, Long> {

    ArrayList<NursingActs> findAllByStatus(int status);
}
