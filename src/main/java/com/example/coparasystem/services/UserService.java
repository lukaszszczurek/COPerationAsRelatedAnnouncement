package com.example.coparasystem.services;

import com.example.coparasystem.repositoriesI.IUserRepository;
import com.example.coparasystem.models.UserModel;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
//@Slf4j
public class UserService {
    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
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
        userModel.setPhotoUrl("https://static.wikia.nocookie.net/shaunthesheep/images/e/eb/Shaun.png/revision/latest/thumbnail/width/360/height/450?cb=20160427172317");
        userRepository.save(userModel);
            System.out.println(userModel);
    }

    public Optional<UserModel> findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    @Transactional
    public void UpdateUserProfilePicture(ObjectId id, String photoUrl){
        UserModel userModel = userRepository.findById(id).orElseThrow(()->new IllegalStateException("student with " + id + " doesn't exist"));
        if(photoUrl != null && photoUrl.length()>0){
            userModel.setPhotoUrl(photoUrl);
            userRepository.save(userModel);
        }
        else {
            System.out.println("Error updating model");
        }
    }




}
