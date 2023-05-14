package com.travelnet.model.users;

import com.travelnet.model.vechicles.Vehicle;

import java.util.ArrayList;

/**
 * The type Mechanix.
 */
public class Mechanix extends DefaultUser{
    /**
     * Instantiates a new Mechanix.
     *
     * @param name     the name
     * @param password the password
     */
    public Mechanix(String name, String password) {
        super(name, password);
        hunger = 50;
        stamina = 50;
    }
    /**
     * Mechanix skill, increases vehicle condition
     * decreases Mechanix stats
     *
     * @param vehicle   vehicle object
     */
    @Override
    public boolean skill(Vehicle vehicle) {
        if(vehicle.getCondition() != vehicle.getMaxCondition()){
            vehicle.setCondition(vehicle.getCondition() + 5);
            hunger -= 5;
            stamina -= 5;
            return true;
        }
        return false;
    }
    @Override
    public String getName() {
        return name;
    }

    public String getPassword(){return password;}

}
