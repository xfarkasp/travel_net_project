package com.travelnet.controller;

import com.travelnet.model.users.Mechanix;
import com.travelnet.model.users.User;
import com.travelnet.model.vechicles.Vehicle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class UserStatusController implements Initializable {

    @FXML
    private Label hungerValue;

    @FXML
    private Label staminaValue;

    @FXML
    private Label typeValue;

    @FXML
    private ImageView userProfile;

    @FXML
    private Label username;

    @FXML
    private Button abilityButton;

    @FXML
    private Button eat;
    @FXML
    private Button rest;

    private User userStatus;

    private Vehicle vehicle;

    private Label condition;

    @FXML
    void useAbility(MouseEvent event) {
        if(userStatus.skill(vehicle)){
            condition.setText(String.valueOf(vehicle.getCondition()));
            staminaValue.setText(String.valueOf(userStatus.getStamina()));
            hungerValue.setText(String.valueOf(userStatus.getHunger()));
        }
    }

    public void setUp(User user, Vehicle vehicle, Label condition){
        this.condition = condition;
        this.vehicle = vehicle;
        this.userStatus = user;
        username.setText(user.getName());
        typeValue.setText(user.getClass().getSimpleName().toString());
        hungerValue.setText(String.valueOf(user.getHunger()));
        staminaValue.setText(String.valueOf(user.getStamina()));
        if(!(user instanceof Mechanix))
            abilityButton.setVisible(false);

    }

    @FXML
    void eatButton(MouseEvent event) {
        userStatus.setHunger(userStatus.getHunger() + 5);
        hungerValue.setText(String.valueOf(userStatus.getHunger()));
    }

    @FXML
    void restButton(MouseEvent event) {
        userStatus.setStamina(userStatus.getStamina() + 5);
        staminaValue.setText(String.valueOf(userStatus.getStamina()));
    }


    /**
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
