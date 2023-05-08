package com.travelnet.model.users;

import com.travelnet.model.vechicles.Vehicle;

public interface User {
    void staminaUsage(User user);
    void hunger(User user);
    boolean skill(Vehicle vehicle);

    void waitTime(int waitTime);

    void setMoney(int money);
    int getHunger();

    int getStamina();
    void setHunger(int hunger);

    int getMoney();

    String getName();

    String getPassword();

    String getUserType();


}
