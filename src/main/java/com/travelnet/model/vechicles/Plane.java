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

/**
 * The type Plane.
 */
public class Plane implements Vehicle{

    private final int maxCondition = 30;
    /**
     * The Speed factor.
     */
    protected int speedFactor = 5;

    /**
     * The Condition.
     */
    protected int condition = 30;
    /**
     * The Fail factor.
     */
    protected int failFactor = 10;

    private final String  icon = "images/icons/maverick.jpg";


    /**
     * @return speedFactor of Plane object
     */
    @Override
    public int getSpeed() {
        return speedFactor;
    }

    /**
     * Returns the condition of the vehicle
     * @return condition
     */
    @Override
    public int getCondition() {
        return condition;
    }

    /**
     * Sets the condition of the vehicle object
     * @param condition
     */
    @Override
    public void setCondition(int condition) {
        this.condition = condition;
    }

    /**
     * Returns the path to the icon img
     * @return
     */
    @Override
    public String getIcon() {
        return icon;
    }

    /**
     * @return fail factor of plane object
     */
    @Override
    public int getFail() {
        return failFactor;
    }

    /**
     * @return fmax condition of plane object
     */
    @Override
    public int getMaxCondition() {
        return maxCondition;
    }

}
