package com.travelnet.model.utillity;

import com.travelnet.model.cities.City;
import com.travelnet.model.users.User;
import com.travelnet.model.vechicles.Plane;
import com.travelnet.model.vechicles.Vehicle;

import java.util.ArrayList;

/**
 * The type Travel.
 * This object is responsable for handling travels
 */
public class Travel {
    private User owner;
    private ArrayList<User>companions;
    private ArrayList<City>cityList;
    private City currentCity;

    private String about;

    private Vehicle vehicle;

    /**
     * Gets about.
     *
     * @return the about
     */
    public String getAbout() {
        return about;
    }

    /**
     * Sets about.
     *
     * @param about the about
     */
    public void setAbout(String about) {
        this.about = about;
    }

    /**
     * Instantiates a new Travel.
     *
     * @param owner       the owner
     * @param companions  the companions
     * @param currentCity the current city
     * @param vehicle     the vehicle
     * @param about       the about
     */
    public Travel(User owner, ArrayList<User> companions,  City currentCity, Vehicle vehicle, String about) {
        this.owner = owner;
        this.companions = companions;
        this.currentCity = currentCity;
        this.vehicle = vehicle;
        this.about = about;
    }

    /**
     * Instantiates a new Travel.
     *
     * @param owner       the owner
     * @param companions  the companions
     * @param cityList    the city list
     * @param currentCity the current city
     */
    public Travel(User owner, ArrayList<User> companions, ArrayList<City> cityList, City currentCity) {
        this.owner = owner;
        this.companions = companions;
        this.cityList = cityList;
        this.currentCity = currentCity;
    }

    /**
     * Sets owner.
     *
     * @param owner the owner
     */
    public void setOwner(User owner) {
        this.owner = owner;
    }

    /**
     * Gets companions.
     *
     * @return the companions
     */
    public ArrayList<User> getCompanions() {
        return companions;
    }


    /**
     * Gets city list.
     *
     * @return the city list
     */
    public ArrayList<City> getCityList() {
        return cityList;
    }


    /**
     * Gets current city.
     *
     * @return the current city
     */
    public City getCurrentCity() {
        return currentCity;
    }

    /**
     * Sets current city.
     *
     * @param currentCity the current city
     */
    public void setCurrentCity(City currentCity) {
        this.currentCity = currentCity;
    }

    /**
     * Travel to.
     *
     * @param city    the city
     * @param vehicle the vehicle
     */
    public void travelTo(City city, Vehicle vehicle){

    }

    /**
     * Get owner user.
     *
     * @return the user
     */
    public User getOwner(){return owner;}

    /**
     * Set city.
     *
     * @param city the city
     */
    public void setCity(City city){currentCity = city;}

    /**
     * Gets vehicle.
     *
     * @return the vehicle
     */
    public Vehicle getVehicle() {
        return vehicle;
    }

    /**
     * Set vehicle.
     *
     * @param vehicle the vehicle
     */
    public void setVehicle(Vehicle vehicle){
        this.vehicle = vehicle;
    }
}
