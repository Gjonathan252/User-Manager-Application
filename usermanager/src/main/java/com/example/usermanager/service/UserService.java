package com.example.usermanager.service;

import com.example.usermanager.exception.UserNotFoundException;
import com.example.usermanager.model.UserSpringModel;
import com.example.usermanager.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public UserSpringModel addUser(UserSpringModel userSpringModel){
        userSpringModel.setUserCode(UUID.randomUUID().toString());
        return userRepo.save(userSpringModel);
    }

    public List<UserSpringModel> findAllUsers(){
        return userRepo.findAll();
    }

    public UserSpringModel updateUser(UserSpringModel userSpringModel){
        return userRepo.save(userSpringModel);
    }

    public UserSpringModel findUserById(Long id){
        return userRepo.findUserById(id)
                .orElseThrow(() -> new UserNotFoundException("UserSpringModel by id " + id + " not found"));
    }

    @Transactional
    public void deleteUser(Long id){
        userRepo.deleteUserById(id);
    }
}
