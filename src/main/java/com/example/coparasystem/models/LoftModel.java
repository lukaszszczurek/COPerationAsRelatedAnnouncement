package com.example.coparasystem.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.annotation.Collation;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "lofts")

public class LoftModel {


    @Id
    private ObjectId id;
    private String name;
    private String description;
    private String photoUrl;
    private ObjectId ownerId;
    // create a collection of users that have access to this loft and their role authorization with a token
    // first value is email of user and the second the role
    //private Map<String, String> users;
    private List<ObjectId> userIds;



}
