package com.travelnet.model.users;

import com.travelnet.model.utillity.Travel;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * The type Default user.
 */
abstract class DefaultUser implements User, Serializable {
    /**
     * The Name.
     */
    protected String name;
    /**
     * The Password.
     */
    protected String password;
    /**
     * The Stamina.
     */
    protected int stamina;
    /**
     * The Money.
     */
    protected int money;
    /**
     * The Hunger.
     */
    protected int hunger;
    /**
     * The Owned travels.
     */
    protected ArrayList<Travel>ownedTravels;

    /**
     * Gets owned travels.
     *
     * @return the owned travels
     */
    public ArrayList<Travel> getOwnedTravels() {
        return ownedTravels;
    }

    /**
     * Sets owned travels.
     *
     * @param ownedTravels the owned travels
     */
    public void setOwnedTravels(ArrayList<Travel> ownedTravels) {
        this.ownedTravels = ownedTravels;
    }
    public String getPassword() {
        return password;
    }
    public String getName() {
        return name;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
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


    /**
     * Instantiates a new Default user.
     * Only callable from inherited classes
     *
     * @param name     the name
     * @param password the password
     */
    public DefaultUser(String name, String password) {
        this.name = name;
        this.password = password;
    }

}
