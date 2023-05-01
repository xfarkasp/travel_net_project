package com.travelnet.model.users;

import com.travelnet.model.utillity.PostObserver;

import java.io.Serializable;
import java.util.ArrayList;

public class UserHandler implements Serializable {
    private ArrayList<User> userList;
    private ArrayList<User> logedInUsers;

    private static final UserHandler instance = new UserHandler();

    public UserHandler() {

        this.userList = new ArrayList<>();
        this.logedInUsers = new ArrayList<>();
    }

    public static UserHandler getInstance(){
        return instance;
    }

    public void registerUser(String name, String pswd, String type){
        DefaultUser newUser = null;
        if(type.equals("Adult"))
            newUser = new Adult(name, pswd);
        else if (type.equals("Pilot"))
            newUser = new Pilot(name, pswd);
        else if (type.equals("Mechanic"))
            newUser = new Mechanix(name, pswd);
        if(newUser != null)
            userList.add(newUser);
    }

    public User loginUser(String name, String pswd){
        for(User user : userList){
            if(user.getName().equals(name) && user.getPassword().equals(pswd)){
                return user;
            }
        }
        return null;
    }

    public ArrayList<User> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<User> userList) {
        this.userList = userList;
    }

    public ArrayList<User> getLogedInUsers(){
        return logedInUsers;
    }
}
