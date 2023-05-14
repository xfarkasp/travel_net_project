package com.travelnet.controller;

import com.travelnet.model.cities.Bratislava;
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
import java.util.ResourceBundle;

import static com.sun.javafx.scene.control.skin.Utils.getResource;

public class CityWindowController implements Initializable {

    public VBox leftVbox;
    @FXML
    public VBox userContainer;
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
    private VBox usersBox;
    @FXML
    private ImageView nextTravelButton;
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
    private Button showHotels;
    @FXML
    private Button showInterests;
    @FXML
    private Button showRestaurants;
    @FXML
    private Label zazitok;
    @FXML
    private Label zazitok1;
    @FXML
    private Label zazitok2;
    @FXML
    private ImageView vehicleIMG;
    @FXML
    private Label condition;
    @FXML
    private ChoiceBox<String> cityDropdown;
    private boolean zazitokFlag = false;
    private boolean restauraciaFlag = false;
    private boolean hotelFlag = false;
    private Travel currentTravel;

    @FXML
    void showHotelsClicked(MouseEvent event) {
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

    @FXML
    void showInterestsClicked(MouseEvent event) {
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

    @FXML
    void showRestaurantsClicked(MouseEvent event) {
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


        CityVisitor visitor = new CityVisitor();
        visitor.visit(currentTravel.getCurrentCity());
        if(currentTravel.getCurrentCity() instanceof Bratislava)
            visitor.visit((Bratislava) currentTravel.getCurrentCity());
        else if(currentTravel.getCurrentCity() instanceof Vienna)
            visitor.visit((Vienna) currentTravel.getCurrentCity());

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
