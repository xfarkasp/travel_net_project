package com.travelnet.model.utillity;

import com.travelnet.controller.*;
import com.travelnet.model.cities.*;
import com.travelnet.view.Gui;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.ArrayList;

/**
 * The type City visitor.
 * Visitor patern
 */
public class CityVisitor implements Visitor{
    private CityWindowController cwc;

    /**
     * Instantiates a new City visitor.
     *
     * @param controller the controller
     */
    public CityVisitor(CityWindowController controller){
        cwc = controller;
    }

    /**
     * When parameter is type of Bratislava
     * set up gui for Bratislava map
     *
     * @param ba
     * @return
     */
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
    /**
     * When parameter is type of Vienna
     * set up gui for Vienna map
     *
     * @param ve
     * @return
     */
    @Override
    public Pane visit(Vienna ve) {
        System.out.println("Vieden coe");
        FXMLLoader fxmlLoader = new FXMLLoader(Gui.class.getResource("../cityPanes/vienna.fxml"));
        Pane pane = null;
        try {
            pane = fxmlLoader.load();
            ViennaController city = fxmlLoader.getController();
            cwc.setMap(city);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return pane;
    }

    /**
     * When parameter is type of Paris
     * set up gui for Paris map
     *
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
}
