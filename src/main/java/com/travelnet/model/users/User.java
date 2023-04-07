package com.travelnet.model.users;

public interface User {
    void staminaUsage(User user);
    void hunger(User user);
    void skill(User user);

    void waitTime(int waitTime);

    void setMoney(int money);
    int getHunger();
    void setHunger(int hunger);

    int getMoney();
}
