package com.train18.controller;

import java.net.URI;
import java.util.List;

import jakarta.validation.Valid; // Ensure you're using the correct import for Spring Boot 3+
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.train18.model.TrainingCenter;
import com.train18.service.TrainingCenterService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*") // Enables CORS (Optional, but useful for frontend integration)
public class TrainingCenterController {

    @Autowired
    private TrainingCenterService service;

    // Create a new training center
    @PostMapping("/training-centers")
    public ResponseEntity<TrainingCenter> createTrainingCenter(@Valid @RequestBody TrainingCenter trainingCenter) {
        TrainingCenter savedCenter = service.createTrainingCenter(trainingCenter);
        return ResponseEntity.created(URI.create("/api/training-centers/" + savedCenter.getId()))
                .body(savedCenter);
    }

    // Get all training centers
    @GetMapping("/training-centers")
    public ResponseEntity<List<TrainingCenter>> getAllTrainingCenters() {
        List<TrainingCenter> centers = service.getAllTrainingCenters();
        return ResponseEntity.ok(centers);
    }
}
