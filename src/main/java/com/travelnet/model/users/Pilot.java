package com.travelnet.model.users;

import com.travelnet.model.vechicles.Vehicle;

import java.util.ArrayList;

public class Pilot extends DefaultUser{
    public Pilot(String name, String password) {
        super(name, password);
        hunger = 50;
        stamina = 50;
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
     * @param stamina
     */
    @Override
    public void setStamina(int stamina) {
        this.stamina = stamina;
    }


    @Override
    public String getName() {
        return this.name;
    }

}
