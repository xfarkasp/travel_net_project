package com.travelnet.model.vechicles;

import com.travelnet.model.cities.City;
import com.travelnet.model.users.User;
import com.travelnet.model.utillity.Travel;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;

import java.util.concurrent.TimeUnit;

/**
 * The type Car.
 */
public class Car implements Vehicle {

    private final int maxCondition = 15;
    /**
     * The Speed factor.
     */
    protected int speedFactor = 15;

    /**
     * The Condition.
     */
    protected int condition = 15;
    /**
     * The Fail factor.
     */
    protected int failFactor = 3;

    /**
     * The Km counter.
     */
    protected int kmCounter;

    private int timeLeft;
    /**
     * returns icon path
     */
    private final String icon = "images/icons/icons8-car.gif";

    /**
     * @return
     */
    @Override
    public int getSpeed() {
        return speedFactor;
    }

    /**
     * Gets car condition
     *
     * @return  condition
     */
    @Override
    public int getCondition() {return condition;}

    /**
     * Sets car condition
     *
     * @param  condition
     */
    @Override
    public void setCondition(int condition) {this.condition = condition;}

    /**
     * Return car icon
     * @return icon
     */
    @Override
    public String getIcon() {
        return icon;
    }

    /**
     * @return failfactor of vehicle
     */
    @Override
    public int getFail() {
        return failFactor;
    }

    /**
     * Gets maxCondition of vehicle
     *
     * @return maxCondition of vehicle
     */
    @Override
    public int getMaxCondition() {
        return maxCondition;
    }
}
