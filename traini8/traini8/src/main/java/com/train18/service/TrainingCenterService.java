package com.train18.service;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.train18.model.TrainingCenter;
import com.train18.repository.TrainingCenterRepository;

@Service
public class TrainingCenterService {
    
    @Autowired
    private TrainingCenterRepository repository;

    public TrainingCenter createTrainingCenter(TrainingCenter trainingCenter) {
        trainingCenter.setCreatedOn(Instant.now()); // ✅ FIXED
        return repository.save(trainingCenter);
    }

    public List<TrainingCenter> getAllTrainingCenters() {
        return repository.findAll();
    }
}
