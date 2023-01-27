package com.user.service.UserService.userexception;

import com.user.service.UserService.entity.User;
import com.user.service.UserService.payload.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class globalExceptionHandler {

    @ExceptionHandler(UserException.class)
    public ResponseEntity<APIResponse> userNotFoundException(UserException userException){
        APIResponse resultResponse= APIResponse.builder().success(true)
                .httpStatus(HttpStatus.NOT_FOUND)
                .message("User not found with user").build();
        return new ResponseEntity<>(resultResponse,HttpStatus.NOT_FOUND);

    }
}
