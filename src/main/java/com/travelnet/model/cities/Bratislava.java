package com.travelnet.model.cities;

import com.travelnet.model.users.User;

import java.util.HashMap;
import java.util.Map;

/**
 * The type Bratislava.
 */
public class Bratislava extends CityTemplate implements City{
    /**
     * Distance calculated with in delayCounter.
     */
    private int distance = 40;

    public int getDistance() {
        return distance;
    }


    /**
     * Instantiates a new Bratislava.
     */
    public Bratislava(){
        this.name = "Bratislava";
        //image: SHUTTERSTOCK
        this.imagePath = "src/main/resources/images/city_imgs/Bratislava-870x400.jpg";
    }
    /**
     * Return the city name
     * @return name
     */
    @Override
    public String getName() {
        return name;
    }


    /**
     * Gets distance.
     *
     * @param city the city
     * @return the distance
     */
    public int getDistance(String city) {
        return distance;
    }


}
