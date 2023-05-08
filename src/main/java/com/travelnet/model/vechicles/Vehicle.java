package com.travelnet.model.vechicles;

import com.travelnet.model.users.User;
import com.travelnet.model.utillity.Travel;
import javafx.concurrent.Service;

public interface Vehicle {
    default void defatult(){
        System.out.println("default vehicle method");
    };
    boolean travelTo(Travel travel);
    void maintenance(User user);
    boolean payments(User user, int distance);

    int getCondition();
    void setCondition(int condition);

    int getTimeLeft();







}
