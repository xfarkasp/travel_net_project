package com.travelnet.model.utillity;

import com.travelnet.controller.CityWindowController;
import com.travelnet.model.cities.*;
import javafx.scene.layout.Pane;

public interface Visitor {
    public Pane visit(Bratislava ba);
    public Pane visit(Vienna ve);
    public Pane visit(Paris pa);
    public Pane visit(BudaPest bp);
    public Pane visit(City currentCity);
}
