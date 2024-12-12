package org.project.gsapi.entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Data
public class Exercise {
    @Id
    private ObjectId id;
    private String name;
    private String muscle;
    private String equipment;
    private String difficulty;
    private String instructions;
}
