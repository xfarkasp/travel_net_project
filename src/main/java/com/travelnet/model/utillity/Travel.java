package com.travelnet.model.utillity;

import com.travelnet.model.cities.City;
import com.travelnet.model.users.User;
import com.travelnet.model.vechicles.Plane;
import com.travelnet.model.vechicles.Vehicle;

import java.util.ArrayList;

public class Travel {
    private User owner;
    private ArrayList<User>companions;
    private ArrayList<City>cityList;
    private City currentCity;

    private String about;

    private Vehicle vehicle = new Plane();

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Travel(User owner, ArrayList<User> companions, ArrayList<City> cityList, City currentCity, String about) {
        this.owner = owner;
        this.companions = companions;
        this.cityList = cityList;
        this.currentCity = currentCity;
        this.about = about;
    }

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


    public ArrayList<City> getCityList() {
        return cityList;
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

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(){

    }
}
