package com.travelnet.model.vechicles;

import com.travelnet.model.cities.City;
import com.travelnet.model.strategy.TravelStrategy;
import com.travelnet.model.users.Pilot;
import com.travelnet.model.users.User;
import com.travelnet.model.utillity.Travel;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;

import java.util.concurrent.TimeUnit;

public class Plane implements Vehicle{
    protected int speedFactor = 5;

    protected int condition = 30;
    protected int failFactor = 10;


    /**
     * @return
     */
    @Override
    public int getSpeed() {
        return speedFactor;
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
