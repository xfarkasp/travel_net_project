package com.travelnet.logic;

import com.travelnet.users.User;

import java.util.ArrayList;

public class UserHandler {
    private ArrayList<User> userList;

    public UserHandler() {
        this.userList = new ArrayList<>();
    }

    public void registerUser(){

    }

    public void loginUser(){

    }

    public ArrayList<User> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<User> userList) {
        this.userList = userList;
    }
}
