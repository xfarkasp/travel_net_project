package com.travelnet.model.users;

import com.travelnet.model.utillity.PostObserver;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * The type User handler.
 * Singleton based user database
 *
 */
public class UserHandler implements Serializable {
    private ArrayList<User> userList;
    private ArrayList<User> logedInUsers;

    private static final UserHandler instance = new UserHandler();

    /**
     * Instantiates a new User handler.
     */
    public UserHandler() {

        this.userList = new ArrayList<>();
        this.logedInUsers = new ArrayList<>();
    }

    /**
     * Get instance user handler.
     *
     * @return the user handler
     */
    public static UserHandler getInstance(){
        return instance;
    }

    /**
     * Register user.
     *
     * @param name the name
     * @param pswd the pswd
     * @param type the type
     */
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

    /**
     * Login user user.
     *
     * @param name the name
     * @param pswd the pswd
     * @return the user
     */
    public User loginUser(String name, String pswd){
        for(User user : userList){
            if(user.getName().equals(name) && user.getPassword().equals(pswd)){
                return user;
            }
        }
        return null;
    }

    /**
     * Gets user list.
     *
     * @return the user list
     */
    public ArrayList<User> getUserList() {
        return userList;
    }

    /**
     * Sets user list.
     *
     * @param userList the user list
     */
    public void setUserList(ArrayList<User> userList) {
        this.userList = userList;
    }

    /**
     * Get loged in users array list.
     *
     * @return the array list
     */
    public ArrayList<User> getLogedInUsers(){
        return logedInUsers;
    }
}
