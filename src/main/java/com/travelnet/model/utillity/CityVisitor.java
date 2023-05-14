package com.travelnet.model.utillity;

import com.travelnet.controller.BratislavaController;
import com.travelnet.controller.CityWindowController;
import com.travelnet.controller.ParisController;
import com.travelnet.controller.UserStatusController;
import com.travelnet.model.cities.*;
import com.travelnet.view.Gui;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.ArrayList;

public class CityVisitor implements Visitor{
    private CityWindowController cwc;
    public CityVisitor(CityWindowController controller){
        cwc = controller;
    }
    @Override
    public Pane visit(Bratislava ba) {
        System.out.println("Bratislava coe");
        FXMLLoader fxmlLoader = new FXMLLoader(Gui.class.getResource("../cityPanes/bratislava.fxml"));
        Pane pane = null;
        try {
            pane = fxmlLoader.load();
            BratislavaController city = fxmlLoader.getController();
            cwc.setMap(city);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return pane;
    }

    @Override
    public Pane visit(Vienna ve) {
        System.out.println("Cecky");
        return null;
    }

    /**
     * @param pa
     * @return
     */
    @Override
    public Pane visit(Paris pa) {
        FXMLLoader fxmlLoader = new FXMLLoader(Gui.class.getResource("../cityPanes/paris.fxml"));
        Pane pane = null;
        try {
            pane = fxmlLoader.load();
            ParisController city = fxmlLoader.getController();
            cwc.setMap(city);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return pane;
    }

    /**
     * @param bp
     * @return
     */
    @Override
    public Pane visit(BudaPest bp) {
        return null;
    }

    @Override
    public Pane visit(City currentCity) {

        return null;
    }
}
