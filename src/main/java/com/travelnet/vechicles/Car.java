package com.travelnet.vechicles;

import com.travelnet.cities.City;
import com.travelnet.users.User;
import com.travelnet.utillity.Travel;

public class Car implements Vehicle {
    protected int speedFactor = 3;
    protected int failFactor = 3;
    protected int cost = 2;
    protected int kmCounter;

    @Override
    public void travelTo(City cityCurrent, City cityNext, Travel travel) {
        int distance = cityCurrent.getDistance(cityNext.getName());
        if(!payments(travel.getOwner(), distance)){
            System.out.println("You don't have enough money to travel;");
            return;
        }
        kmCounter += distance;
        //here a thread will begin to count the cooldown
        int timeOut = speedFactor * distance;

        travel.setCity(cityNext);


    }

    @Override
    public void maintenance(User user) {

    }

    @Override
    public boolean payments(User user, int distance) {
        if(user.getMoney() >= distance){
            user.setMoney(user.getMoney() - (distance * cost));
            System.out.println("Payment was succesful");
            return true;
        }
        System.out.println("You don't have enough money to travel");
        return false;
    }
}
