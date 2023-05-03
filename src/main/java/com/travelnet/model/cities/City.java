package com.travelnet.model.cities;

import com.travelnet.model.users.User;

public interface City {
    String getImagePath();
    boolean fetchFood(User user, int choice);
    boolean entertainment(User user);
    boolean sleep(User user);
    boolean shopping(User user);

    String getName();
    int getDistance();

}
