package org.project.gsapi.service;

import org.project.gsapi.abstracts.service.IExerciseService;
import org.project.gsapi.client.ExerciseClient;
import org.project.gsapi.dto.response.ExerciseResponse;
import org.project.gsapi.entity.Exercise;
import org.project.gsapi.entity.Muscle;
import org.project.gsapi.repository.ExerciseRepository;
import org.project.gsapi.repository.MuscleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ExerciseService implements IExerciseService {
    private final ExerciseRepository exerciseRepository;
    private final ExerciseClient exerciseClient;
    private final MuscleRepository muscleRepository;

    public ExerciseService(ExerciseRepository exerciseRepository, ExerciseClient exerciseClient, MuscleRepository muscleRepository) {
        this.exerciseRepository = exerciseRepository;
        this.exerciseClient = exerciseClient;
        this.muscleRepository = muscleRepository;
    }

    @Override
    @Transactional
    public Boolean synchronizeExercises() {
        List<Muscle> muscles = muscleRepository.findAll();

        for (Muscle muscle : muscles) {
            List<Exercise> exercises = exerciseClient.getExerciseByMuscle(muscle.getName());
            exerciseRepository.saveAll(exercises);
        }
        return true;
    }

    @Override
    public List<ExerciseResponse> getExercises() {
        List<Exercise> exercises = exerciseRepository.findAll();
        return exercises.stream().map(exercise -> new ExerciseResponse(exercise.getId(), exercise.getName(), exercise.getMuscle(), exercise.getEquipment(), exercise.getDifficulty(), exercise.getInstructions())).toList();
    }

    @Override
    public ExerciseResponse getExerciseByName(String name) {
        Optional<Exercise> result = exerciseRepository.findByName(name);
        if (result.isPresent()) {
            Exercise exercise = result.get();
            return new ExerciseResponse(exercise.getId(), exercise.getName(), exercise.getMuscle(), exercise.getEquipment(), exercise.getDifficulty(), exercise.getInstructions());
        }
        return null;
    }
}
