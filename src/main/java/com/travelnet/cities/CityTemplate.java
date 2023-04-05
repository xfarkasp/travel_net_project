package com.travelnet.cities;

import java.util.HashMap;
import java.util.Map;

abstract class CityTemplate {
    public static enum Food{};
    public static enum Vehicle{};
    private static enum Entertainmetn{}
    private static enum Hotel{};
    private String name;
    private static Map<String, Integer> distances = new HashMap<String, Integer>();
}
