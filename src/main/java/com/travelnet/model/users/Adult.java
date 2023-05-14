package com.travelnet.model.users;

import com.travelnet.model.vechicles.Plane;
import com.travelnet.model.vechicles.Vehicle;

import java.util.ArrayList;

/**
 * The type Adult.
 */
public class Adult extends DefaultUser{
    /**
     * Instantiates a new Adult.
     *
     * @param name     the name
     * @param password the password
     */
    public Adult(String name, String password) {
        super(name, password);
    }

    @Override
    public boolean skill(Vehicle vehicle) {
        if(vehicle instanceof Plane){
            this.stamina += 5;
            this.hunger +=5;
        }

        return false;
    }
}
