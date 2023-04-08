package com.travelnet.model.users;

import java.util.ArrayList;

public class AdminUser extends DefaultUser{
    public AdminUser(String firstName, String lastName, String email, String password, int age, ArrayList<String> hobbies, ArrayList<String> foods, ArrayList<String> languages, String originCountry) {
        super(firstName, lastName, email, password, age, hobbies, foods, languages, originCountry);
    }

    /**
     * @param user
     */
    @Override
    public void staminaUsage(User user) {

    }

    /**
     * @param user
     */
    @Override
    public void hunger(User user) {

    }

    /**
     * @param user
     */
    @Override
    public void skill(User user) {

    }

    /**
     * @param waitTime
     */
    @Override
    public void waitTime(int waitTime) {

    }

    /**
     * @return
     */
    @Override
    public String getName() {
        return null;
    }
}
