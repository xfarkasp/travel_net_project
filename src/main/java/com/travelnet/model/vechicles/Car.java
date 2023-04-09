package com.travelnet.model.vechicles;

import com.travelnet.model.cities.City;
import com.travelnet.model.users.User;
import com.travelnet.model.utillity.Travel;

public class Car implements Vehicle {
    protected int speedFactor = 3;

    protected int condition = 15;
    protected int failFactor = 3;
    protected int cost = 2;
    protected int kmCounter;

    @Override
    public void travelTo(City cityCurrent, City cityNext, Travel travel) {
        if(condition > 0){
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
        System.out.println("The car is in bad condition, call a mechanic");
    }

    @Override
    public void maintenance(User user) {
        if(user.skill(this)){
            System.out.println("Car repaired");
            return;
        }
        System.out.println("this user can not repair a car");

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


    @Override
    public int getCondition() {return condition;}


    @Override
    public void setCondition(int condition) {this.condition = condition;}
}
