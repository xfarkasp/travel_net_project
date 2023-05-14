package com.travelnet.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.ArrayList;

public class BratislavaController implements MapController {
    @FXML
    private Label hotel;
    @FXML
    private Label hotel1;
    @FXML
    private Label hotel2;
    @FXML
    private Label hotel21;
    @FXML
    private Label restauracia;
    @FXML
    private Label restauracia1;
    @FXML
    private Label restauracia2;
    @FXML
    private Label restauracia3;
    @FXML
    private Label restauracia4;
    @FXML
    private Label zazitok;
    @FXML
    private Label zazitok1;
    @FXML
    private Label zazitok2;


    private boolean zazitokFlag = false;
    private boolean restauraciaFlag = false;
    private boolean hotelFlag = false;

    @FXML
    public void showHotelsClicked() {
        if(!hotelFlag){
            this.hotel.setVisible(true);
            this.hotel1.setVisible(true);
            this.hotel21.setVisible(true);
            hotelFlag = true;
        }else{
            this.hotel.setVisible(false);
            this.hotel1.setVisible(false);
            this.hotel21.setVisible(false);
            hotelFlag = false;
        }
    }

    public void showInterestsClicked() {
        if(!zazitokFlag){
            this.zazitok.setVisible(true);
            this.zazitok1.setVisible(true);
            this.zazitok2.setVisible(true);
            zazitokFlag = true;
        }else{
            this.zazitok.setVisible(false);
            this.zazitok1.setVisible(false);
            this.zazitok2.setVisible(false);
            zazitokFlag = false;
        }
    }


    public void showRestaurantsClicked(){
        if(!restauraciaFlag){
            this.restauracia.setVisible(true);
            this.restauracia1.setVisible(true);
            this.restauracia2.setVisible(true);
            this.restauracia3.setVisible(true);
            this.restauracia4.setVisible(true);
            restauraciaFlag = true;
        }else{
            this.restauracia.setVisible(false);
            this.restauracia1.setVisible(false);
            this.restauracia2.setVisible(false);
            this.restauracia3.setVisible(false);
            this.restauracia4.setVisible(false);
            restauraciaFlag = false;
        }

    }
}
