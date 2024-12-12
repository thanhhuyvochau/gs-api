package org.project.gsapi.entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Data
public class Muscle {
    @Id
    private ObjectId id;
    private String name;
}
