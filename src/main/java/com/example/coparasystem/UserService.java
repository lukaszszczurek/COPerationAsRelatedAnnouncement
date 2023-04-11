package com.example.coparasystem;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<UserModel> allUsers(){
        return userRepository.findAll();
    }

    public void createUser(UserModel userModel){
        String email = userModel.getEmail();
        Optional<UserModel> userByEmail = userRepository.findUserModelByEmail(userModel.getEmail());
        if(userByEmail.isPresent()){
            throw new IllegalStateException("User Exist");
        }
        userRepository.save(userModel);
            System.out.println(userModel);

    }

    public Optional<UserModel> findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    @Transactional
    public void UpdateUserProfilePicture(ObjectId id, String photoUrl){
        UserModel userModel = userRepository.findById(id).orElseThrow(()->new IllegalStateException("student with " + id + " doesn't exist"));
        System.out.println(String.valueOf(userModel));
        if(photoUrl != null && photoUrl.length()>0){
            userModel.setPhotoUrl(photoUrl);
            System.out.println(String.valueOf(userModel));
        }
        else {
            System.out.printf("Error updating model");
        }
    }

}
