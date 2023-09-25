package com.example.coparasystem.repositoriesI;

import com.example.coparasystem.models.UserModel;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends MongoRepository<UserModel, ObjectId> {

    @Query("{email:?0}")
    Optional<UserModel> findUserModelByEmail(String email);
    Optional<UserModel> findByEmail(String email);
    Optional<UserModel> findById(ObjectId id);


}
