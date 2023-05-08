package com.travelnet.controller;

import com.travelnet.model.users.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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

    private User userStatus;

    @FXML
    void useAbility(MouseEvent event) {

    }

    public void setUsers(User user){
        this.userStatus = user;
        username.setText(user.getName());
        typeValue.setText(user.getClass().getSimpleName().toString());
        hungerValue.setText(String.valueOf(user.getHunger()));
        staminaValue.setText(String.valueOf(user.getStamina()));
    }


    /**
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
