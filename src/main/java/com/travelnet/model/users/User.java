package com.travelnet.model.users;

import com.travelnet.model.vechicles.Vehicle;

/**
 * The interface User.
 */
public interface User {
    /**
     * Skill boolean.
     *
     * @param vehicle the vehicle
     * @return the boolean
     */
    boolean skill(Vehicle vehicle);

    /**
     * Gets hunger.
     *
     * @return the hunger
     */
    int getHunger();

    /**
     * Gets stamina.
     *
     * @return the stamina
     */
    int getStamina();

    /**
     * Sets stamina.
     *
     * @param stamina the stamina
     */
    void setStamina(int stamina);

    /**
     * Sets hunger.
     *
     * @param hunger the hunger
     */
    void setHunger(int hunger);

    /**
     * Gets name.
     *
     * @return the name
     */
    String getName();
    /**
     * Gets password.
     *
     * @return the password
     */
    String getPassword();
}
