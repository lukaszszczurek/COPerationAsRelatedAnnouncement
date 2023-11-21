package com.example.coparasystem.repositoriesI;

import com.example.coparasystem.models.LoftModel;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ILoftRepository extends MongoRepository<LoftModel, ObjectId> {

    @Query("{name:?0}")
    Optional<LoftModel> findLoftModelByLoftName(String loftName);

    @Query("{email:?0}")
    Optional<LoftModel> findLoftModelByEmail(String email);

}
