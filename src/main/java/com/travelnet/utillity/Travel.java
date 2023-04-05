package com.travelnet.utillity;

import com.travelnet.cities.City;
import com.travelnet.users.User;
import com.travelnet.vechicles.Vehicle;

import java.util.ArrayList;

public class Travel {
    private User owner;
    private ArrayList<User>companions;
    private ArrayList<City>cityList;
    private City currentCity;

    public void travelTo(City city, Vehicle vehicle){

    }

    public User getOwner(){return owner;}
    public void setCity(City city){currentCity = city;}

}
