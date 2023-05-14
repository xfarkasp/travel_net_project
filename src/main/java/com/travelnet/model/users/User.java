package com.travelnet.model.users;

import com.travelnet.model.vechicles.Vehicle;

public interface User {
    boolean skill(Vehicle vehicle);

    int getHunger();

    int getStamina();
    void setStamina(int stamina);
    void setHunger(int hunger);

    String getName();

    String getPassword();
}
