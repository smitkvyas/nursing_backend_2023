package com.quiz.nursing.services;

import com.quiz.nursing.models.NursingAbbreviations;
import com.quiz.nursing.models.NursingActs;
import com.quiz.nursing.repos.NursingAbbreviationRepo;
import com.quiz.nursing.util.StatusResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;

@Service
public class NursingAbbreviationService {

    private final Logger LOG = LogManager.getLogger(NursingAbbreviationService.class);
    private final NursingAbbreviationRepo nursingAbbreviationRepo;
    private final int ENABLE_STATUS = 1;


    public NursingAbbreviationService(NursingAbbreviationRepo nursingAbbreviationRepo) {
        this.nursingAbbreviationRepo = nursingAbbreviationRepo;
    }

    public ArrayList<NursingAbbreviations> getActiveAbbreviations() {
        LOG.info("getActiveAbbreviations() called");
        return nursingAbbreviationRepo.findAllByStatus(ENABLE_STATUS);
    }

    public StatusResponse saveAbbreviation(String shortForm, String fullForm) {
        LOG.info("saveAbbreviation() called with: shortForm = [" + shortForm + "], fullForm = [" + fullForm + "]");
        try {
            NursingAbbreviations savedAbbreviation = nursingAbbreviationRepo.save(new NursingAbbreviations()
                    .setFullForm(fullForm).setShortForm(shortForm).setStatus(ENABLE_STATUS)
                    .setCreatedOn(Timestamp.from(Instant.now())).setUpdatedOn(Timestamp.from(Instant.now())));
            return new StatusResponse().setSuccess(savedAbbreviation);
        } catch (Exception e) {
            e.printStackTrace();
            return new StatusResponse().setError(e.getMessage());
        }
    }
}
