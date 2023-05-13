package com.travelnet.model.cities;

import com.travelnet.model.users.User;

import java.util.HashMap;
import java.util.Map;

public class Bratislava extends CityTemplate implements City{

    private int distance = 40;



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


}
