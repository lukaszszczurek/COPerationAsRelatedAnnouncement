package com.example.coparasystem.services;


import com.example.coparasystem.models.LoftModel;
import com.example.coparasystem.repositoriesI.ILoftRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Service
public class LoftService {
    private final ILoftRepository loftRepository;


    public LoftService(ILoftRepository loftRepository) {
        this.loftRepository = loftRepository;
    }


    public void getLoftById(ObjectId loftId) {
        loftRepository.findById(loftId);
    }

    public Optional<LoftModel> getLoftByName(String loftName) {
        return loftRepository.findLoftModelByLoftName(loftName);
    }


    public void createNewLoft(LoftModel loftModel) {


        loftRepository.save(loftModel);

    }
}

