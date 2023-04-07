package com.travelnet.model.cities;

import java.util.HashMap;
import java.util.Map;

abstract class CityTemplate {
    public static enum Food{};
    public static enum Vehicle{};
    private static enum Entertainmetn{}
    private static enum Hotel{};
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

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    protected String imagePath;
    private static Map<String, Integer> distances = new HashMap<String, Integer>();
}
