package com.travelnet.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class TravelCreatorController implements Initializable {

    @FXML
    private ChoiceBox<?> cityDropdown;

    @FXML
    private ImageView subbmitButton;

    @FXML
    private ImageView userProfile;

    @FXML
    private Label username;

    /**
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}