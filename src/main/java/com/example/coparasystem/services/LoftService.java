package com.example.coparasystem.services;

import com.example.coparasystem.models.LoftModel;
import com.example.coparasystem.models.UserModel;
import com.example.coparasystem.repositoriesI.ILoftRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoftService {
    private final ILoftRepository loftRepository;

    public LoftService(ILoftRepository loftRepository) {
        this.loftRepository = loftRepository;
    }

    public Optional<LoftModel> getLoftById(ObjectId loftId) {
        loftRepository.findById(loftId);
        return loftRepository.findById(loftId);
    }

    public Optional<LoftModel> getLoftByName(String loftName) {
        System.out.println("hi in getLoftByName");
        return loftRepository.findLoftModelByLoftName(loftName);
    }

    public void createNewLoft(LoftModel loftModel) {

        loftRepository.save(loftModel);
    }

    public Optional<LoftModel> getLoftByEmail(String email) {
        // find all lofts by email
        return loftRepository.findLoftModelByEmail(email);
    }

    public List<Optional<LoftModel>> getLoftsByIds(List<ObjectId> loftIds) {

        var lofts = loftRepository.findAllById(loftIds);
        return lofts.stream().map(Optional::of).toList();
    }
}

