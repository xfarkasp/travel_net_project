package com.travelnet.model.vechicles;

import com.travelnet.model.cities.City;
import com.travelnet.model.users.User;
import com.travelnet.model.utillity.Travel;

public class Plane implements Vehicle{
    protected int speedFactor = 1;

    protected int condition = 30;
    protected int failFactor = 10;
    protected int cost = 10;
    protected int kmCounter;
    /**
     * @param cityCurrent
     * @param cityNext
     * @param travel
     */
    @Override
    public void travelTo(City cityCurrent, City cityNext, Travel travel) {
        for(int i = 0; i < travel.getCompanions().size(); i++){
            if(travel.getCompanions().get(i).getUserType().equals("Pilot")){
                int distance = cityCurrent.getDistance(cityNext.getName());
                if (!payments(travel.getOwner(), distance)) {
                    System.out.println("You don't have enough money to travel;");
                    return;
                }
                if(travel.getCompanions().get(i).skill(this)) {

                    kmCounter += distance;
                    //here a thread will begin to count the cooldown
                    int timeOut = speedFactor * distance;

                    travel.setCity(cityNext);
                }
            }
        }
    }

    /**
     * @param user
     */
    @Override
    public void maintenance(User user) {
        if(user.skill(this)){
            System.out.println("Plane repaired");
            return;
        }
        System.out.println("this user can not repair a car");

    }

    /**
     * @param user
     * @param distance
     * @return
     */
    @Override
    public boolean payments(User user, int distance) {
        return false;
    }

    /**
     * @return
     */
    @Override
    public int getCondition() {
        return 0;
    }

    /**
     * @param condition
     */
    @Override
    public void setCondition(int condition) {

    }
}
