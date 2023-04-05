package com.travelnet.model.cities;

import com.travelnet.model.users.User;

/**
 * The type Vienna.
 */
public class Vienna extends CityTemplate implements City {
    private int distance = 60;

    /**
     * Instantiates a new Vienna.
     */
    public Vienna(){
        this.name = "Vienna";
        //image: https://plus7dni.pluska.sk/gal/relax/mesto-kde-zije-najlepsie-svete-je-slovenska-kusok/1?itm_brand=plus7&itm_template=article&itm_modul=hero
        this.imagePath = "src/main/resources/images/city_imgs/hofburg-palace-on-st-michael-square-vienna-austria-shutterstock_1613510086.jpg_d10bbfcf6b.jpg";
    }
    /**
     * Gets image path.
     *
     * @return imagePath
     */
    @Override
    public String getImagePath() {
        return this.imagePath;
    }
    /**
     * Gets name.
     *
     * @return name
     */
    @Override
    public String getName() {
        return null;
    }
    /**
     * Gets distance.
     *
     * @return the distance
     */
    @Override
    public int getDistance() {
        return distance;
    }
}
