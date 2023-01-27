package com.user.service.UserService.userService;

import com.user.service.UserService.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    //save the user data.
    User saveUsr(User user);

    //save the all user.
    List<User> getAllUser();

    //save the user ById.
    User getUserById(String userId);

    // Update.
    User updateByUserId(User user,String userId);

    // delete.
    void deleteUser(String userId);



}
