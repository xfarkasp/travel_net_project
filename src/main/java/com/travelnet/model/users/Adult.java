package com.travelnet.model.users;

import com.travelnet.model.vechicles.Vehicle;

import java.util.ArrayList;

public class Adult extends DefaultUser{
    public Adult(String name, String password) {
        super(name, password);
    }

    @Override
    public void staminaUsage(User user) {
        this.stamina -= 10;
    }

    @Override
    public void hunger(User user) {
        this.hunger -= 15;

    }

    @Override
    public boolean skill(Vehicle vehicle) {

        return false;
    }

    /**
     * @param waitTime
     */
    @Override
    public void waitTime(int waitTime) {

    }

    @Override
    public String getUserType() {
        return userType;
    }
}
