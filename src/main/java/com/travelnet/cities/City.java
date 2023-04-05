package com.travelnet.cities;

import com.travelnet.users.User;

public interface City {
    boolean fetchFood(User user, int choice);
    boolean entertainment(User user);
    boolean sleep(User user);
    boolean shopping(User user);

    String getName();
    int getDistance(String city);

}
