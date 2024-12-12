package org.project.gsapi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.bson.types.ObjectId;

@Data
@AllArgsConstructor
public class ExerciseResponse {
    private ObjectId id;
    private String name;
    private String muscle;
    private String equipment;
    private String difficulty;
    private String instructions;
}
