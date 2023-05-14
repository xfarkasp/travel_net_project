package com.travelnet.controller;

import com.travelnet.model.Exceptions.EmptyInputException;
import com.travelnet.model.cities.Bratislava;
import com.travelnet.model.cities.City;
import com.travelnet.model.cities.Vienna;
import com.travelnet.model.users.Adult;
import com.travelnet.model.users.User;
import com.travelnet.model.utillity.PostObserver;
import com.travelnet.model.utillity.Travel;
import com.travelnet.model.utillity.TravelCreator;
import com.travelnet.view.Gui;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TravelCreatorController implements Initializable {

    @FXML
    private ChoiceBox<String> cityDropdown;
    @FXML
    private ChoiceBox<String> vehicleDropdown;

    @FXML
    private ImageView subbmitButton;

    @FXML
    private ImageView userProfile;

    @FXML
    private Label username;

    @FXML
    private TextArea aboutTravel;

    private MainWindowController mainWindowController;


    /**
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cityDropdown.getItems().add("Bratislava");
        cityDropdown.getItems().add("Vienna");
        cityDropdown.getItems().add("Paris");

        vehicleDropdown.getItems().add("Car");
        vehicleDropdown.getItems().add("Plane");
    }

    private Travel travel;

    public void setUserData(User user){
        username.setText(user.getName());
    }

    @FXML
    void onsubbmitButton(MouseEvent event) throws EmptyInputException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../travel-post.fxml"));
        try {
            Parent root = (Parent) fxmlLoader.load();
            if(cityDropdown.getValue() == null)
                throw new EmptyInputException("City field is empty!", new RuntimeException());
            if(vehicleDropdown.getValue() == null)
                throw new EmptyInputException("Vehicle field is empty!", new RuntimeException());

            TravelPostController travelPostController = fxmlLoader.getController();

            TravelCreator tc = TravelCreator.getInstance();
            System.out.println(tc.test());
            tc.createTravel(cityDropdown.getValue(), vehicleDropdown.getValue(),aboutTravel.getText(),mainWindowController.getLogedIn());

            PostObserver.getInstance().notifySubjects();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }catch(EmptyInputException e){
            System.out.println(e.getMessage());
            if(e.getMessage().equals("City field is empty!"))
                cityDropdown.setValue("You must select a city!");
            else if(e.getMessage().equals("Vehicle field is empty!"))
                vehicleDropdown.setValue("You must select a Vehicle!");
        }



    }

    void setParentMainWindow(MainWindowController mainWindowController){
        this.mainWindowController = mainWindowController;
    }

}