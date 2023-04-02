package com.travelnet.users;

import java.util.ArrayList;

public class AdminUser extends DefaultUser{
    public AdminUser(String firstName, String lastName, String email, String password, int age, ArrayList<String> hobbies, ArrayList<String> foods, ArrayList<String> languages, String originCountry) {
        super(firstName, lastName, email, password, age, hobbies, foods, languages, originCountry);
    }
}
