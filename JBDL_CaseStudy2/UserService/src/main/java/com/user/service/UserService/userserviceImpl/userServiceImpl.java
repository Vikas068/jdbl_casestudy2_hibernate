package com.user.service.UserService.userserviceImpl;

import com.user.service.UserService.Repository.UserRepository;
import com.user.service.UserService.entity.User;
import com.user.service.UserService.userService.UserService;
import com.user.service.UserService.userexception.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class userServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUsr(User user) {
        String uuid= UUID.randomUUID().toString();
        user.setUserId(uuid);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(String userId) {
       //get user from database with the help of user repository.
        return userRepository.findById(userId).orElseThrow(()->new UserException("Üser not found with the id"+userId));
    }

    @Override
    public User updateByUserId(User user, String userId) {
        User saveUser=userRepository.findById(userId).get();
        saveUser.setUserName(user.getUserName());
        saveUser.setEmail(user.getEmail());
        saveUser.setAbout(user.getAbout());
        return userRepository.save(saveUser);
    }
    @Override
    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }
}
