package com.travelnet.model.utillity;

import com.travelnet.model.cities.Bratislava;
import com.travelnet.model.cities.City;
import com.travelnet.model.cities.Vienna;
import com.travelnet.model.users.Adult;
import com.travelnet.model.users.User;

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
    public void createTravel(String city, String about, User creator){
        Travel newTravel = null;
        if(city == "Bratislava")
            newTravel = new Travel(creator, new ArrayList<User>(), new ArrayList<City>(), new Bratislava(), about);
        else if(city == "Vienna")
            newTravel = new Travel(creator, new ArrayList<User>(), new ArrayList<City>(), new Vienna(), about);

        travelDataBase.add(newTravel);
    }

    public ArrayList<Travel> travelList(){
        return travelDataBase;
    }

    public String test(){
        return test;
    }
}
