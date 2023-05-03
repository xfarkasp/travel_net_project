package com.travelnet.model.vechicles;

import com.travelnet.model.cities.City;
import com.travelnet.model.users.Pilot;
import com.travelnet.model.users.User;
import com.travelnet.model.utillity.Travel;

import java.util.concurrent.TimeUnit;

public class Plane implements Vehicle{
    protected int speedFactor = 15;

    protected int condition = 30;
    protected int failFactor = 10;
    protected int cost = 10;
    protected int kmCounter;
    private int timeLeft;

    @Override
    public boolean travelTo(Travel travel) {
        City cityCurrent = travel.getCurrentCity();
        if(travel.getCompanions().size() == 0){
            System.out.println("no companions");
            return false;
        }
        for(int i = 0; i < travel.getCompanions().size(); i++){
            if(travel.getCompanions().get(i) instanceof Pilot){
                //int distance = cityCurrent.getDistance(cityCurrent.getName());

                if(travel.getCompanions().get(i).skill(this)) {
                    kmCounter += cityCurrent.getDistance();
                    while (speedFactor != 0){
                        timeLeft = speedFactor;
                        speedFactor--;
                        /*try {
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }*/
                    }
                    return true;
                }
            }
        }
        return false;
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
        return condition;
    }

    /**
     * @param condition
     */
    @Override
    public void setCondition(int condition) {

    }
}
