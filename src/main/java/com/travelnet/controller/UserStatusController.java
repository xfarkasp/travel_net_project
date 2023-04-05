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

/**
 * The type User status controller.
 * Shows and controls the users on the current travel
 */
public class UserStatusController{

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
    /**
     * Current user
     */
    private User userStatus;
    /**
     * Current vehicle
     */
    private Vehicle vehicle;
    @FXML
    private Label condition;

    /**
     * Use ability.
     *Uses the skill method of the user
     *
     * @param event the event
     */
    @FXML
    void useAbility(MouseEvent event) {
        if(userStatus.skill(vehicle)){
            condition.setText(String.valueOf(vehicle.getCondition()));
            staminaValue.setText(String.valueOf(userStatus.getStamina()));
            hungerValue.setText(String.valueOf(userStatus.getHunger()));
        }
    }

    /**
     * Set up.
     *Sets up the UserStatus widget based on the inputs
     * @param user      the user
     * @param vehicle   the vehicle
     * @param condition the condition
     */
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

    /**
     * Eat button.
     * Increases user hunger attribute
     *
     * @param event the event
     */
    @FXML
    void eatButton(MouseEvent event) {
        if(userStatus.getHunger() < 50){
            userStatus.setHunger(userStatus.getHunger() + 5);
            hungerValue.setText(String.valueOf(userStatus.getHunger()));
        }
    }

    /**
     * Rest button.
     * Increases user rest attribute
     *
     * @param event the event
     */
    @FXML
    void restButton(MouseEvent event) {
        if(userStatus.getStamina() < 50){
            userStatus.setStamina(userStatus.getStamina() + 5);
            staminaValue.setText(String.valueOf(userStatus.getStamina()));
        }
    }
}
