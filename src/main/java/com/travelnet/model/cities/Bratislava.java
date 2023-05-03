package com.travelnet.model.cities;

import com.travelnet.model.users.User;

import java.util.HashMap;
import java.util.Map;

public class Bratislava extends CityTemplate implements City{

    public static enum Food{UFO, AUPARK, NIVY, BAMBOO};
    public static enum Vehicle{CAR, BUS, TRAM};
    public static enum Entertainmetn{BCASTLE, DCASTLE, UFO, ZLATEPIESKY}
    public static enum Hotel{MLADOST, GRAND, RIVER};

    private int distance = 50;


    public int getDistance() {
        return distance;
    }



    public Bratislava(){
        this.name = "Bratislava";
        this.imagePath = "src/main/resources/images/city_imgs/Bratislava-870x400.jpg";
    }

    @Override
    public String getName() {
        return name;
    }



    public int getDistance(String city) {
        return distance;
    }


    @Override
    public boolean fetchFood(User user, int choice) {
        int foodCost = 0;
        int nutrition = 0;
        //time it takes to eat in seconds
        int waitTime = 0;
        
        if(choice == Food.UFO.ordinal()){
            foodCost = 40;
            nutrition = 50;
            waitTime = 120;
            
        } else if(choice == Food.AUPARK.ordinal()) {
            foodCost = 15;
            nutrition = 10;
            waitTime = 20;
        } else if(choice == Food.NIVY.ordinal()) {
            foodCost = 20;
            nutrition = 20;
            waitTime = 30;

        }else if(choice == Food.BAMBOO.ordinal()) {
            foodCost = 30;
            nutrition = 10;
            waitTime = 60;
        }

        if(user.getMoney() >= foodCost){
            user.setMoney(user.getMoney() - foodCost);
            user.waitTime(waitTime);
            user.setHunger(user.getHunger() + nutrition);
            return true;
        }
        
        return false;
    }

    @Override
    public boolean entertainment(User user) {
        return false;
    }

    @Override
    public boolean sleep(User user) {
        return false;
    }

    @Override
    public boolean shopping(User user) {
        return false;
    }
}
