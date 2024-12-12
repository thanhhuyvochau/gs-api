package org.project.gsapi.abstracts.service;

import org.project.gsapi.dto.response.ExerciseResponse;

import java.util.List;

public interface IExerciseService {
    Boolean synchronizeExercises();

    List<ExerciseResponse> getExercises();

    ExerciseResponse getExerciseByName(String name);

}
