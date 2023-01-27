package com.user.service.UserService.controller;

import com.user.service.UserService.Repository.UserRepository;
import com.user.service.UserService.entity.User;
import com.user.service.UserService.userService.UserService;
import com.user.service.UserService.userexception.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Users")
public class UserResponseController {


    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;


//saving the user data.
    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User saveUser = userService.saveUsr(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveUser);
    }

    //get user by id.
    @GetMapping("/getBy/{userId}")
    public ResponseEntity<User> getUser(@PathVariable String userId) {
        User getUser = userService.getUserById(userId);
        return ResponseEntity.ok(getUser);
    }

    //Getting all the user data.
    @GetMapping("/gettingAllUser")
    public ResponseEntity<List<User>> getAllUser() {
        List<User> listUser = userService.getAllUser();
        return ResponseEntity.ok(listUser);
    }

    //Delete the data based on the userId.
    @DeleteMapping("/delete/{userId}")
    public String deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
        return "Deleted successfully";
    }

    //Update the data based on the userId.
    @PutMapping("update/{userId}")
    public ResponseEntity<User> updateUserById(@PathVariable String userId, @RequestBody User user) {
        User updateUser;
        if(userRepository.existsById(userId)) {
            updateUser = userService.updateByUserId(user, userId);
        }
        else{
            throw new UserException("Requested User id is not available");
        }
        return ResponseEntity.status(HttpStatus.OK).body(updateUser);
    }
}