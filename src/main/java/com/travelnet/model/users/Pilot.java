package com.travelnet.model.users;

import com.travelnet.model.vechicles.Vehicle;

import java.util.ArrayList;

public class Pilot extends DefaultUser{
    public Pilot(String name,  String password) {
        super(name, password);
        this.userType = "Captain";
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
        if(vehicle.getCondition() > 0){
            if(this.hunger > 0 && this.stamina > 0){
                this.hunger -= 10;
                this.stamina -= 10;
                return true;
            }
        }
        System.out.println("This pilot can not fly now");
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
