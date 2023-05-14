package com.travelnet.model.strategy;

import com.travelnet.model.utillity.Travel;

/**
 * The interface Travel strategy.
 */
public interface TravelStrategy {
    /**
     * Travel to boolean.
     * Travels to a new city object
     *
     * @return the boolean
     */
    boolean travelTo();

    /**
     * Gets time left.
     *
     * @return the time left
     */
    int getTimeLeft();

    /**
     * Gets travel animation.
     *
     * @return the travel animation
     */
    String getTravelAnimation();
}
