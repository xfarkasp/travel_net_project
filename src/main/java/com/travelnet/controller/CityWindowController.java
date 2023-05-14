package com.travelnet.controller;

import com.travelnet.model.cities.Bratislava;
import com.travelnet.model.cities.Paris;
import com.travelnet.model.cities.Vienna;
import com.travelnet.model.users.User;
import com.travelnet.model.users.UserHandler;
import com.travelnet.model.utillity.CityVisitor;
import com.travelnet.model.utillity.PostObserver;
import com.travelnet.model.utillity.Travel;
import com.travelnet.model.utillity.TravelCreator;
import com.travelnet.model.vechicles.Plane;
import com.travelnet.view.Gui;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static com.sun.javafx.scene.control.skin.Utils.getResource;

public class CityWindowController implements Initializable {

    public VBox leftVbox;
    @FXML
    public VBox userContainer;

    @FXML
    private ImageView leaveButton;
    @FXML
    private Pane leftPane;
    @FXML
    private VBox usersBox;
    @FXML
    private ImageView nextTravelButton;

    @FXML
    private Button showHotels;
    @FXML
    private Button showInterests;
    @FXML
    private Button showRestaurants;

    @FXML
    private ImageView vehicleIMG;
    @FXML
    private Label condition;

    @FXML
    private Pane mapPane;
    @FXML
    private ChoiceBox<String> cityDropdown;

    private MapController map;
    private boolean zazitokFlag = false;
    private boolean restauraciaFlag = false;
    private boolean hotelFlag = false;
    private Travel currentTravel;

    private ArrayList<Label> restaurants;
    private ArrayList<Label> hotels;
    private ArrayList<Label> interests;

    public void setMap(MapController map){
        this.map = map;
    }

    @FXML
    void showHotelsClicked(MouseEvent event) {
        map.showHotelsClicked();

    }

    @FXML
    void showInterestsClicked(MouseEvent event) {
       map.showInterestsClicked();
    }

    @FXML
    void showRestaurantsClicked(MouseEvent event) {
       map.showRestaurantsClicked();

    }

    @FXML
    public void setUp(){
        for(User user: currentTravel.getCompanions()){
            FXMLLoader fxmlLoader = new FXMLLoader(Gui.class.getResource("../user-status.fxml"));
            VBox vBox = null;
            try {
                vBox = fxmlLoader.load();
                UserStatusController usc = fxmlLoader.getController();
                usc.setUp(user, currentTravel.getVehicle(), condition);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            userContainer.getChildren().add(vBox);
        }
        condition.setText(String.valueOf(currentTravel.getVehicle().getCondition()));
        vehicleIMG.setImage(new Image(currentTravel.getVehicle().getIcon()));


        CityVisitor visitor = new CityVisitor(this);
        visitor.visit(currentTravel.getCurrentCity());
        if(currentTravel.getCurrentCity() instanceof Bratislava){
            this.mapPane.getChildren().add(visitor.visit((Bratislava) currentTravel.getCurrentCity()));
        }
        else if(currentTravel.getCurrentCity() instanceof Vienna)
            visitor.visit((Vienna) currentTravel.getCurrentCity());
        else if(currentTravel.getCurrentCity() instanceof Paris)
            this.mapPane.getChildren().add(visitor.visit((Paris) currentTravel.getCurrentCity()));


    }

    public void setTravel(Travel travel){
        this.currentTravel = travel;
        setUp();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        userContainer.getChildren();
        cityDropdown.getItems().add("Bratislava");
        cityDropdown.getItems().add("Vienna");
        cityDropdown.getItems().add("BudaPest");
        cityDropdown.getItems().add("Paris");

    }
}
