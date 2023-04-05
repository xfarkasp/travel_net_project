package com.travelnet.model.utillity;

import com.travelnet.model.cities.Bratislava;
import com.travelnet.model.cities.City;
import com.travelnet.model.cities.Paris;
import com.travelnet.model.cities.Vienna;
import com.travelnet.model.users.Adult;
import com.travelnet.model.users.User;
import com.travelnet.model.vechicles.Car;
import com.travelnet.model.vechicles.Plane;
import com.travelnet.model.vechicles.Vehicle;

import java.util.ArrayList;

/**
 * The type Travel creator.
 * Singleton based database for travels
 */
public class TravelCreator {
    /**
     *Singleton instance
     */
    private static final TravelCreator instance = new TravelCreator();
    /**
     *Travel database
     */
    private ArrayList<Travel>travelDataBase;
    private String test = "funguje";

    private TravelCreator(){
        travelDataBase = new ArrayList<>();
    }

    /**
     * Get instance travel creator.
     *
     * @return the travel creator
     */
    public static TravelCreator getInstance(){
        return instance;
    }

    /**
     * Create travel.
     *
     * @param city    the city
     * @param vehicle the vehicle
     * @param about   the about
     * @param creator the creator
     */
    public void createTravel(String city, String vehicle, String about, User creator){
        City newCity = null;
        Vehicle newVehcile = null;
        if(city == "Bratislava")
            newCity = new Bratislava();
        else if(city == "Vienna")
            newCity = new Vienna();
        else if(city == "Paris")
            newCity = new Paris();

        if(vehicle == "Car")
            newVehcile = new Car();

        else if(vehicle == "Plane")
            newVehcile = new Plane();

        Travel newTravel = new Travel(creator, new ArrayList<User>(), newCity, newVehcile, about);
        travelDataBase.add(newTravel);
    }

    /**
     * Travel list array list.
     *
     * @return the array list
     */
    public ArrayList<Travel> travelList(){
        return travelDataBase;
    }

    /**
     * Test string.
     *
     * @return the string
     */
    public String test(){
        return test;
    }
}
