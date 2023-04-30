package com.travelnet.model.users;

import com.travelnet.model.vechicles.Vehicle;

import java.util.ArrayList;

public class Mechanix extends DefaultUser{
    public Mechanix(String name,  String password) {
        super(name, password);
        this.userType = "Mechanix";
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
     * @param vehicle
     * @return
     */
    @Override
    public boolean skill(Vehicle vehicle) {
        if(vehicle.getCondition() <= 0){
            vehicle.setCondition(vehicle.getCondition() + 5);
            hunger -= 5;
            stamina -= 5;
            return true;
        }

        return false;
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

    /**
     * @return
     */
    @Override
    public String getUserType() {
        return this.userType;
    }
}
