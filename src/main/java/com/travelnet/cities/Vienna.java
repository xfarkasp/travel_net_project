package com.travelnet.cities;

import com.travelnet.users.User;

public class Vienna implements City {
    @Override
    public boolean fetchFood(User user, int choice) {
        return false;
    }

    @Override
    public boolean entertainment(User user) {
        return false;
    }

    @Override
    public boolean sleep(User user) {
        return false;
    }

    @Override
    public boolean shopping(User user) {
        return false;
    }

    @Override
    public String getName() {
        return null;
    }

    /**
     * @param city
     * @return
     */
    @Override
    public int getDistance(String city) {
        return 0;
    }
}
