package com.travelnet.controller;

import com.travelnet.model.cities.Bratislava;
import com.travelnet.model.cities.City;
import com.travelnet.model.cities.Vienna;
import com.travelnet.model.users.Adult;
import com.travelnet.model.users.User;
import com.travelnet.model.utillity.Travel;
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
    }

    private Travel travel;

    public void setUserData(User user){
        username.setText(user.getName());
    }

    @FXML
    void onsubbmitButton(MouseEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../travel-post.fxml"));
        try {
            Parent root = (Parent) fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        TravelPostController travelPostController = fxmlLoader.getController();
        //travelPostController.setData(travel);
        //travelContainer.getChildren().add(vBox);
        Travel newTravel = null;
        if(cityDropdown.getValue() == "Bratislava")
            newTravel = new Travel(new Adult(), new ArrayList<User>(), new ArrayList<City>(), new Bratislava(), aboutTravel.getText());
        else if(cityDropdown.getValue() == "Vienna")
            newTravel = new Travel(new Adult(), new ArrayList<User>(), new ArrayList<City>(), new Vienna(), aboutTravel.getText());

        mainWindowController.addTravel(newTravel);

    }

    void setParentMainWindow(MainWindowController mainWindowController){
        this.mainWindowController = mainWindowController;
    }

}