package org.project.gsapi.repository;

import org.bson.types.ObjectId;
import org.project.gsapi.entity.Muscle;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MuscleRepository extends MongoRepository<Muscle, ObjectId> {
}
