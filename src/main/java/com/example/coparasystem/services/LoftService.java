package com.example.coparasystem.services;


import com.example.coparasystem.models.LoftModel;
import com.example.coparasystem.models.UserModel;
import com.example.coparasystem.repositoriesI.ILoftRepository;
import com.example.coparasystem.repositoriesI.IUserRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Service
public class LoftService {
    private final ILoftRepository loftRepository;


    public LoftService(ILoftRepository loftRepository) {
        this.loftRepository = loftRepository;
    }


    public LoftModel getLoftById(ObjectId loftId) throws Exception {
      Optional<LoftModel> loft =  loftRepository.findById(loftId);
      if(!loft.isPresent())
        {
            throw  new Exception("Loft not found");
        }
      LoftModel existingLoft = loft.get();
      return  existingLoft;
    }

    public Optional<LoftModel> getLoftByName(String loftName) {
        return loftRepository.findLoftModelByLoftName(loftName);
    }


    public void createNewLoft(LoftModel loftModel) {

        loftRepository.save(loftModel);

    }

    public Boolean IsUserLoftMember(ObjectId userId, ObjectId loftId)
    {
        Optional<LoftModel>  OptionalLoft = loftRepository.findById(loftId);

        if(!OptionalLoft.isPresent())
            {
                return false;
            }

            LoftModel loftModel = OptionalLoft.get();
            List<ObjectId> usersIds = loftModel.getUserIds();

        if(!usersIds.contains(userId))
           {
               return false;
           }

       return true;
    }

    public void UpdateLoft(LoftModel loftModel){
        loftRepository.save(loftModel);
    }
}

