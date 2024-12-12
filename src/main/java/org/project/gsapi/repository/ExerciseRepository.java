package org.project.gsapi.repository;

import org.bson.types.ObjectId;
import org.project.gsapi.entity.Exercise;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ExerciseRepository extends MongoRepository<Exercise, ObjectId> {
    Optional<Exercise> findByName(String name);
}
