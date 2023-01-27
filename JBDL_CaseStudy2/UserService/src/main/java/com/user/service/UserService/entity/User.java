package com.user.service.UserService.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class User {

    @Id
    private String userId;
    private String userName;
    private String Email;
    private String About;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAbout() {
        return About;
    }

    public User(String userId, String userName, String email, String about) {
        this.userId = userId;
        this.userName = userName;
        Email = email;
        About = about;
    }

    public User() {
    }

    public void setAbout(String about) {
        About = about;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", Email='" + Email + '\'' +
                ", About='" + About + '\'' +
                '}';
    }
}
