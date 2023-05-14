package com.travelnet.model.utillity;

import com.travelnet.controller.CityWindowController;
import com.travelnet.model.cities.*;
import javafx.scene.layout.Pane;

/**
 * The interface Visitor.
 */
public interface Visitor {
    /**
     * Visit Bratislava object.
     *
     * @param ba the ba
     * @return the pane
     */
    public Pane visit(Bratislava ba);

    /**
     * Visit Vienna object.
     *
     * @param ve the ve
     * @return the pane
     */
    public Pane visit(Vienna ve);

    /**
     * Visit Paris object.
     *
     * @param pa the pa
     * @return the pane
     */
    public Pane visit(Paris pa);
}
