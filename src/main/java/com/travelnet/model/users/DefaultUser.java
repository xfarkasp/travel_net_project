package com.travelnet.model.users;

import com.travelnet.model.utillity.Travel;

import java.io.Serializable;
import java.util.ArrayList;

abstract class DefaultUser implements User, Serializable {
    protected String name;
    protected String password;
    protected int stamina;
    protected int money;
    protected int hunger;
    protected ArrayList<Travel>ownedTravels;
    public ArrayList<Travel> getOwnedTravels() {
        return ownedTravels;
    }
    public void setOwnedTravels(ArrayList<Travel> ownedTravels) {
        this.ownedTravels = ownedTravels;
    }
    public String getPassword() {
        return password;
    }
    public String getName() {
        return name;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getStamina() {
        return stamina;
    }
    public void setStamina(int stamina) {
        this.stamina = stamina;
    }
    public int getHunger() {
        return hunger;
    }
    public void setHunger(int hunger) {
        this.hunger = hunger;
    }



    public DefaultUser(String name, String password) {
        this.name = name;
        this.password = password;
    }

}
