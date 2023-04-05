package com.travelnet.cities;

import com.travelnet.users.User;

import java.util.HashMap;
import java.util.Map;

public class Bratislava extends CityTemplate implements City{
    private final String name = "Bratislava";
    public static enum Food{UFO, AUPARK, NIVY, BAMBOO};
    public static enum Vehicle{CAR, BUS, TRAM};
    public static enum Entertainmetn{BCASTLE, DCASTLE, UFO, ZLATEPIESKY}
    public static enum Hotel{MLADOST, GRAND, RIVER};

    private  Map<String, Integer> distances = new HashMap<String, Integer>();
    {
        distances.put("Vienna", 55);
        distances.put("Prague", 291);
        distances.put("Paris", 1088);
        distances.put("Berling", 553 );
    }

    @Override
    public String getName() {
        return name;
    }

    public int getDistance(String city) {
        return distances.get(city);
    }


    @Override
    public boolean fetchFood(User user, int choice) {
        System.out.println("Pick restaurant: 1.UFO = $$$$$, 2.Aupark $$, 3.Nivy $$$, 4.Bamboo $$$$");
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
