package com.travelnet.model.vechicles;

import com.travelnet.model.users.User;
import com.travelnet.model.utillity.Travel;
import javafx.concurrent.Service;

import java.util.concurrent.TimeUnit;

public interface Vehicle {
    default void defatult(){
        return;
    };

    int getSpeed();

    void maintenance(User user);

    int getCondition();
    void setCondition(int condition);



}
