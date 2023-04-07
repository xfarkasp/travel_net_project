package com.travelnet.model.utillity;

import com.travelnet.model.cities.City;
import com.travelnet.model.users.User;
import com.travelnet.model.vechicles.Vehicle;

import java.util.ArrayList;

public class Travel {
    private User owner;
    private ArrayList<User>companions;
    private ArrayList<City>cityList;
    private City currentCity;

    public Travel(User owner, ArrayList<User> companions, ArrayList<City> cityList, City currentCity) {
        this.owner = owner;
        this.companions = companions;
        this.cityList = cityList;
        this.currentCity = currentCity;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public ArrayList<User> getCompanions() {
        return companions;
    }

    public void setCompanions(ArrayList<User> companions) {
        this.companions = companions;
    }

    public ArrayList<City> getCityList() {
        return cityList;
    }

    public void setCityList(ArrayList<City> cityList) {
        this.cityList = cityList;
    }

    public City getCurrentCity() {
        return currentCity;
    }

    public void setCurrentCity(City currentCity) {
        this.currentCity = currentCity;
    }

    public void travelTo(City city, Vehicle vehicle){

    }

    public User getOwner(){return owner;}
    public void setCity(City city){currentCity = city;}

}
