package com.example.coparasystem;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<UserModel, ObjectId> {

    @Query("{email:?0}")
    Optional<UserModel> findUserModelByEmail(String email);

   // Optional<UserModel> findByEmail(String email);
}
