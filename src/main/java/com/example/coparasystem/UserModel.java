package com.example.coparasystem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "usersCore")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {
    @Id
    private ObjectId id;
    private String email;
    private String password;
    private String name;
    private String surname;
    private String nickName;
}
