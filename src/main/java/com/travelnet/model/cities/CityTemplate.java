package com.travelnet.model.cities;

import java.util.HashMap;
import java.util.Map;

abstract class CityTemplate {

    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImagePath() {
        return imagePath;
    }

    protected String imagePath;

}
