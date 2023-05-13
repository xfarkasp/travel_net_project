package com.travelnet.model.utillity;

import com.travelnet.model.cities.Bratislava;
import com.travelnet.model.cities.City;
import com.travelnet.model.cities.Vienna;
import com.travelnet.model.users.Adult;
import com.travelnet.model.users.User;
import com.travelnet.model.vechicles.Car;
import com.travelnet.model.vechicles.Plane;
import com.travelnet.model.vechicles.Vehicle;

import java.util.ArrayList;

public class TravelCreator {

    private static final TravelCreator instance = new TravelCreator();
    private ArrayList<Travel>travelDataBase;
    private String test = "funguje";

    private TravelCreator(){
        travelDataBase = new ArrayList<>();
    }

    public static TravelCreator getInstance(){
        return instance;
    }
    public void createTravel(String city, String vehicle, String about, User creator){
        City newCity = null;
        Vehicle newVehcile = null;
        if(city == "Bratislava")
            newCity = new Bratislava();
        else if(city == "Vienna")
            newCity = new Vienna();

        if(vehicle == "Car")
            newVehcile = new Car();

        else if(vehicle == "Plane")
            newVehcile = new Plane();

        Travel newTravel = new Travel(creator, new ArrayList<User>(), newCity, newVehcile, about);
        travelDataBase.add(newTravel);
    }

    public ArrayList<Travel> travelList(){
        return travelDataBase;
    }

    public String test(){
        return test;
    }
}
