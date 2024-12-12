package org.project.gsapi.api;

import org.project.gsapi.abstracts.service.IExerciseService;
import org.project.gsapi.dto.response.ExerciseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/exercises")
public class ExerciseAPI {
    private final IExerciseService exerciseService;

    public ExerciseAPI(IExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @GetMapping
    public ResponseEntity<List<ExerciseResponse>> getExercises() {
        return ResponseEntity.ok(exerciseService.getExercises());
    }

    @GetMapping("/{name}")
    public ResponseEntity<ExerciseResponse> getExerciseByName(@PathVariable("name") String name) {
        return ResponseEntity.ok(exerciseService.getExerciseByName(name));
    }

    @PostMapping("/sync")
    public ResponseEntity<Void> synchronize() {
        Boolean synchronizeResult = exerciseService.synchronizeExercises();
        if (synchronizeResult) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } else {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
        }
    }


}
