package com.travelnet.controller;

import com.travelnet.model.users.User;
import com.travelnet.model.utillity.Travel;
import com.travelnet.view.Gui;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.sun.javafx.scene.control.skin.Utils.getResource;

public class CityWindowController {

    @FXML
    private ImageView chatButton;

    @FXML
    private Button eatButton;

    @FXML
    private Label hotel;

    @FXML
    private Label hotel1;

    @FXML
    private Label hotel2;

    @FXML
    private Label hotel21;

    @FXML
    private ImageView leaveButton;

    @FXML
    private Pane leftPane;

    @FXML
    private Pane leftPane1;

    @FXML
    private VBox leftVbox;

    @FXML
    private VBox leftVbox1;

    @FXML
    private ImageView nextTravelButton;

    @FXML
    private Button restButton;

    @FXML
    private Label restauracia;

    @FXML
    private Button showHotels;

    @FXML
    private Button showInterests;

    @FXML
    private Button showRestaurants;

    @FXML
    private Button visitButton;

    @FXML
    private Label zazitok;

    private boolean zazitokFlag = false;
    private boolean restauraciaFlag = false;
    private boolean hotelFlag = false;

    @FXML
    void eatClicked(MouseEvent event) {

    }

    @FXML
    void restClicked(MouseEvent event) {

    }

    @FXML
    void showHotelsClicked(MouseEvent event) {
        if(!hotelFlag){
            this.hotel.setVisible(true);
            hotelFlag = true;
        }else{
            this.hotel.setVisible(false);
            hotelFlag = false;
        }

    }

    @FXML
    void showInterestsClicked(MouseEvent event) {
        if(!zazitokFlag){
            this.zazitok.setVisible(true);
            zazitokFlag = true;
        }else{
            this.zazitok.setVisible(false);
            zazitokFlag = false;
        }
    }

    @FXML
    void showRestaurantsClicked(MouseEvent event) {
        if(!restauraciaFlag){
            this.restauracia.setVisible(true);
            restauraciaFlag = true;
        }else{
            this.restauracia.setVisible(false);
            restauraciaFlag = false;
        }

    }

    @FXML
    void visitClicked(MouseEvent event) {

    }

    public void setUpUsers(Travel travel){
        for(User user: travel.getCompanions()){
            FXMLLoader fxmlLoader = new FXMLLoader(Gui.class.getResource("../user-status.fxml"));
            VBox vBox = null;
            try {
                vBox = fxmlLoader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            UserStatusController travelPostController = fxmlLoader.getController();
            leftVbox.getChildren().add(vBox);
        }
    }
}
