package com.example.coparasystem.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "loftMembers")
public class LoftMemberModel {

    @Id
    ObjectId id;
    String userEmail;
    String role;
    Date dataOfJoining;

}
