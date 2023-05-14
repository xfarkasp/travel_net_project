package com.travelnet.model.cities;

import com.travelnet.model.users.User;

/**
 * The interface City.
 */
public interface City {
    /**
     * Gets image path.
     *
     * @return the image path
     */
    String getImagePath();

    /**
     * Gets name.
     *
     * @return the name
     */
    String getName();

    /**
     * Gets distance.
     *
     * @return the distance
     */
    int getDistance();

}
