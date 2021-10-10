package com.example.usermanager;

import com.example.usermanager.model.UserSpringModel;
import com.example.usermanager.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserResource {
    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserSpringModel>> getAllUsers(){
        List<UserSpringModel> userSpringModels = userService.findAllUsers();
        return new ResponseEntity<>(userSpringModels, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<UserSpringModel> getUserById(@PathVariable("id") Long id){
        UserSpringModel userSpringModel = userService.findUserById(id);
        return new ResponseEntity<>(userSpringModel, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<UserSpringModel> addUser(@RequestBody UserSpringModel userSpringModel){
        UserSpringModel newUserSpringModel = userService.addUser(userSpringModel);
        return new ResponseEntity<>(newUserSpringModel, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<UserSpringModel> updateUser(@RequestBody UserSpringModel userSpringModel){
        UserSpringModel updateUserSpringModel = userService.updateUser(userSpringModel);
        return new ResponseEntity<>(updateUserSpringModel, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
