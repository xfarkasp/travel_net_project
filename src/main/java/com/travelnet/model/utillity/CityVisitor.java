package com.travelnet.model.utillity;

import com.travelnet.model.cities.Bratislava;
import com.travelnet.model.cities.City;
import com.travelnet.model.cities.Vienna;

public class CityVisitor implements Visitor{
    @Override
    public void visit(Bratislava ba) {
        System.out.println("Bratislava coe");
    }

    @Override
    public void visit(Vienna ve) {
        System.out.println("Cecky");
    }

    @Override
    public void visit(City currentCity) {
        System.out.println("neni su cecky");
    }
}
