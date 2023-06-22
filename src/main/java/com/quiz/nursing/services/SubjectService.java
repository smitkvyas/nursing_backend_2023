package com.quiz.nursing.services;

import com.quiz.nursing.models.Subject;
import com.quiz.nursing.repos.SubjectRepo;
import com.quiz.nursing.util.StatusResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {


    private static final Logger logger = LogManager.getLogger(SubjectService.class);


    @Autowired
    private final SubjectRepo subjectRepo;

    public SubjectService(SubjectRepo subjectRepo) {
        this.subjectRepo = subjectRepo;
    }

    public StatusResponse saveNewSubject(String name) {
        logger.info("saveNewSubject() called with: name = [" + name + "]");
        List<Subject> subjects = subjectRepo.findByNameIgnoreCase(name);
        if (subjects.isEmpty()) {
            Subject savedSubject = subjectRepo.save(new Subject().setName(name));
            return new StatusResponse().setSuccess(savedSubject);
        }

        return new StatusResponse().setMessage("Subject " + name + " already exists");
    }

    public Iterable<Subject> getAllSubjects() {
        logger.info("getAllSubjects() called");
        return subjectRepo.findAll();
    }
}
