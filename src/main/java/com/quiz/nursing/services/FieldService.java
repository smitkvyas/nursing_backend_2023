package com.quiz.nursing.services;

import com.quiz.nursing.models.Field;
import com.quiz.nursing.repos.FieldRepo;
import com.quiz.nursing.util.StatusResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FieldService {

    private static final Logger logger = LogManager.getLogger(FieldService.class);

    @Autowired
    private final FieldRepo fieldRepo;

    public FieldService(FieldRepo subjectRepo) {
        this.fieldRepo = subjectRepo;
    }

    public StatusResponse saveNewField(String name) {
        List<Field> fields = fieldRepo.findByNameIgnoreCase(name);
        if (fields.isEmpty()) {
            Field savedField = fieldRepo.save(new Field().setName(name));
            return new StatusResponse().setSuccess(savedField);
        }

        return new StatusResponse().setMessage("Field " + name + " already exists");
    }

    public Iterable<Field> getAllFields(){
        return fieldRepo.findAll();
    }
}
