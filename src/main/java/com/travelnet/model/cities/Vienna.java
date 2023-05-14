package com.travelnet.model.cities;

import com.travelnet.model.users.User;

public class Vienna extends CityTemplate implements City {
    private int distance = 60;
    /**
     * @return
     */
    public Vienna(){
        this.name = "Vienna";
        this.imagePath = "src/main/resources/images/city_imgs/hofburg-palace-on-st-michael-square-vienna-austria-shutterstock_1613510086.jpg_d10bbfcf6b.jpg";
    }
    @Override
    public String getImagePath() {
        return this.imagePath;
    }



    @Override
    public String getName() {
        return null;
    }


    @Override
    public int getDistance() {
        return distance;
    }
}
