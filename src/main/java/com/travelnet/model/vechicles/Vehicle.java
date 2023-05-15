package com.travelnet.model.vechicles;

import com.travelnet.model.users.User;
import com.travelnet.model.utillity.Travel;
import javafx.concurrent.Service;

import java.util.concurrent.TimeUnit;

/**
 * The interface Vehicle.
 */
public interface Vehicle {
    /**
     * Gets speed.
     *
     * @return the speed
     */
    int getSpeed();

    /**
     * Gets condition.
     *
     * @return the condition
     */
    int getCondition();

    /**
     * Sets condition.
     *
     * @param condition the condition
     */
    void setCondition(int condition);

    /**
     * Gets icon.
     *
     * @return the icon
     */
    String getIcon();

    /**
     * Gets fail.
     *
     * @return the fail
     */
    int getFail();

    /**
     * Gets max condition.
     *
     * @return the max condition
     */
    int getMaxCondition();
}
