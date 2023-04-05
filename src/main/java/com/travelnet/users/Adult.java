package com.travelnet.users;

import java.util.ArrayList;

public class Adult extends DefaultUser implements User{
    public Adult(String firstName, String lastName, String email, String password, int age, ArrayList<String> hobbies, ArrayList<String> foods, ArrayList<String> languages, String originCountry) {
        super(firstName, lastName, email, password, age, hobbies, foods, languages, originCountry);
    }

    @Override
    public void staminaUsage(User user) {

    }

    @Override
    public void hunger(User user) {

    }

    @Override
    public void skill(User user) {

    }
}
