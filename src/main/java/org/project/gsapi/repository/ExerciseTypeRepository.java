package org.project.gsapi.repository;

import org.bson.types.ObjectId;
import org.project.gsapi.entity.ExerciseType;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExerciseTypeRepository extends MongoRepository<ExerciseType, ObjectId> {
}
