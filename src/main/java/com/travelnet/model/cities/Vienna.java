package com.travelnet.model.cities;

import com.travelnet.model.users.User;

public class Vienna extends CityTemplate implements City {
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
    public boolean fetchFood(User user, int choice) {
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

    @Override
    public String getName() {
        return null;
    }

    /**
     * @param city
     * @return
     */
    @Override
    public int getDistance(String city) {
        return 0;
    }
}
