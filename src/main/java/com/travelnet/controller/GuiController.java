package com.travelnet.controller;

import com.travelnet.model.utillity.TravelCreator;
import com.travelnet.view.MainWindow;
import com.travelnet.model.users.UserHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class GuiController {
    private UserHandler userHandler = new UserHandler();
    @FXML
    private Label welcomeText;
    @FXML
    private Button register;
    @FXML
    private Button demoButton;

    @FXML
    protected void onAdiosButtonClick() {
        welcomeText.setText("Adios!");
    }

    @FXML
    void onDemoButton(ActionEvent event) {
        try {
            //Stage stage = (Stage) register.getScene().getWindow();
            Stage stage = new Stage();
            MainWindow mainWindow = new MainWindow();
            mainWindow.start(stage);
            TravelCreator tc = TravelCreator.getInstance();
            System.out.println(tc.test());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void onRegister(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) register.getScene().getWindow();
            MainWindow mainWindow = new MainWindow();
            mainWindow.start(stage);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}