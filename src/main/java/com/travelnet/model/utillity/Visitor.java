package com.travelnet.model.utillity;

import com.travelnet.model.cities.Bratislava;
import com.travelnet.model.cities.City;
import com.travelnet.model.cities.Vienna;

public interface Visitor {
    public void visit(Bratislava ba);
    public void visit(Vienna ve);
    public void visit(City currentCity);
}
