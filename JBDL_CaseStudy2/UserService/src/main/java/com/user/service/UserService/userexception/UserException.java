package com.user.service.UserService.userexception;

public class UserException extends RuntimeException{


    public UserException(String message) {
        super(message);
    }

    public UserException() {
        super();
    }
}
