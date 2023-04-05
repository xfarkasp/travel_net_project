package com.travelnet.users;

import com.travelnet.utillity.Travel;

import java.util.ArrayList;

abstract class DefaultUser {
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String originCountry;

    protected String password;
    protected int age;
    protected ArrayList<String> hobbies;
    protected ArrayList<String> foods;
    protected ArrayList<String> languages;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
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

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public DefaultUser(String firstName, String lastName, String email, String password, int age, ArrayList<String> hobbies, ArrayList<String> foods, ArrayList<String> languages, String originCountry) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.age = age;
        this.hobbies = hobbies;
        this.foods = foods;
        this.languages = languages;
        this.originCountry = originCountry;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ArrayList<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(ArrayList<String> hobbies) {
        this.hobbies = hobbies;
    }

    public ArrayList<String> getFoods() {
        return foods;
    }

    public void setFoods(ArrayList<String> foods) {
        this.foods = foods;
    }

    public ArrayList<String> getLanguages() {
        return languages;
    }

    public void setLanguages(ArrayList<String> languages) {
        this.languages = languages;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }
}
