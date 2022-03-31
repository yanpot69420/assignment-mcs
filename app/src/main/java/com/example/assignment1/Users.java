package com.example.assignment1;

public class Users{
    String userID;
    String userEmail;
    String userName;
    String phoneNumber;
    String userPassword;
    Users (String userID, String userEmail, String userName, String phoneNumber, String userPassword){
        this.userID = userID;
        this.userEmail = userEmail;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.userPassword = userPassword;
    }
    Users(){

    }

    public Users(Users users) {
        this.userID = users.userID;
        this.userEmail = users.userEmail;
        this.userName = users.userName;
        this.phoneNumber = users.phoneNumber;
        this.userPassword = users.userPassword;
    }
}
