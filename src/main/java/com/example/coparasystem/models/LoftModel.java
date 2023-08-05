package com.example.coparasystem.models;

import com.example.coparasystem.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.el.parser.Token;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

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
    private ObjectId ownerId;
    // create a collection of users that have access to this loft and their role authorization with a token
    private Map<String, String> users;



}
