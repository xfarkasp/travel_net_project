package com.travelnet.model.users;

import com.travelnet.model.vechicles.Vehicle;

import java.util.ArrayList;

/**
 * The type Pilot.
 */
public class Pilot extends DefaultUser{
    /**
     * Instantiates a new Pilot.
     *
     * @param name     the name
     * @param password the password
     */
    public Pilot(String name, String password) {
        super(name, password);
        hunger = 50;
        stamina = 50;
    }

    @Override
    public boolean skill(Vehicle vehicle) {
        if(vehicle.getCondition() > 0){
            if(this.hunger >= 10 && this.stamina >= 10){
                this.hunger -= 10;
                this.stamina -= 10;
                return true;
            }
        }
        System.out.println("This pilot can not fly now");
        return false;
    }

    @Override
    public void setStamina(int stamina) {
        this.stamina = stamina;
    }


    @Override
    public String getName() {
        return this.name;
    }

}
