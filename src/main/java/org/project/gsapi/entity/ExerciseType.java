package org.project.gsapi.entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Data
public class ExerciseType {
    @Id
    private ObjectId id;
    private String name;
}
