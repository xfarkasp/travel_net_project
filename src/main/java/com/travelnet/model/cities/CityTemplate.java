package com.travelnet.model.cities;

import java.util.HashMap;
import java.util.Map;

/**
 * The type City template.
 * Abstract class to inherit from for all the city classes
 */
abstract class CityTemplate {

    /**
     * The Name.
     */
    protected String name;

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets image path.
     *
     * @return the image path
     */
    public String getImagePath() {
        return imagePath;
    }

    /**
     * The Image path.
     */
    protected String imagePath;

}
