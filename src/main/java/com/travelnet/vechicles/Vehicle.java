package com.travelnet.vechicles;

import com.travelnet.cities.City;
import com.travelnet.users.User;
import com.travelnet.utillity.Travel;

public interface Vehicle {
    default void defatult(){};
    void travelTo(City cityCurrent, City cityNext, Travel travel);
    void maintenance(User user);
    boolean payments(User user, int distance);
}
