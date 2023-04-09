package com.travelnet.model.vechicles;

import com.travelnet.model.cities.City;
import com.travelnet.model.users.User;
import com.travelnet.model.utillity.Travel;

public interface Vehicle {
    default void defatult(){};
    void travelTo(City cityCurrent, City cityNext, Travel travel);
    void maintenance(User user);
    boolean payments(User user, int distance);

    int getCondition();
    void setCondition(int condition);
}
