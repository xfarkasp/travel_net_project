package com.travelnet.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * The type Paris controller.
 */
public class ParisController implements MapController {

    @FXML
    private Label hotel;

    @FXML
    private Label hotel1;

    @FXML
    private Label hotel2;

    @FXML
    private ImageView map;

    @FXML
    private Label hotel21;

    @FXML
    private Pane mapPane;

    @FXML
    private Label restauracia;

    @FXML
    private Label restauracia1;

    @FXML
    private Label restauracia2;

    @FXML
    private Label zazitok2;

    @FXML
    private Label zazitok21;

    @FXML
    private Label zazitok211;

    @FXML
    private Label zazitok2111;

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
            this.zazitok211.setVisible(true);
            this.zazitok21.setVisible(true);
            this.zazitok2.setVisible(true);
            this.zazitok2111.setVisible(true);
            zazitokFlag = true;
        }else{
            this.zazitok211.setVisible(false);
            this.zazitok21.setVisible(false);
            this.zazitok2.setVisible(false);
            this.zazitok2111.setVisible(false);
            zazitokFlag = false;
        }
    }


    public void showRestaurantsClicked(){
        if(!restauraciaFlag){
            this.restauracia.setVisible(true);
            this.restauracia1.setVisible(true);
            this.restauracia2.setVisible(true);

            restauraciaFlag = true;
        }else{
            this.restauracia.setVisible(false);
            this.restauracia1.setVisible(false);
            this.restauracia2.setVisible(false);
            restauraciaFlag = false;
        }

    }


    @Override
    public void setImg(String imgPath) {
        this.map.setImage(new Image(imgPath));
    }

}
