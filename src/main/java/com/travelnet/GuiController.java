package com.travelnet;

import com.travelnet.gui.MainWindow;
import com.travelnet.gui.TravelWindow;
import com.travelnet.logic.UserHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

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
            Stage stage = (Stage) register.getScene().getWindow();
            MainWindow mainWindow = new MainWindow();
            mainWindow.start(stage);
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