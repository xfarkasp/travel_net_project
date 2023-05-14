package com.travelnet.model.users;

import com.travelnet.model.vechicles.Vehicle;

import java.util.ArrayList;

public class Mechanix extends DefaultUser{
    public Mechanix(String name, String password) {
        super(name, password);
        hunger = 50;
        stamina = 50;
    }

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

    /**
     * @return
     */
    @Override
    public String getName() {
        return name;
    }

    public String getPassword(){return password;}

}
