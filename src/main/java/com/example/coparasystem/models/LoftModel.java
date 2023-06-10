package com.example.coparasystem.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "lofts")

public class LoftModel {


    @Id
    private Object id;
    private String name;
    private String description;
    private String photoUrl;


}
