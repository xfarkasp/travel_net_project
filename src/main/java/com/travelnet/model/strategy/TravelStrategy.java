package com.travelnet.model.strategy;

import com.travelnet.model.utillity.Travel;

public interface TravelStrategy {
    boolean travelTo();
    int getTimeLeft();
    String getTravelAnimation();
}
