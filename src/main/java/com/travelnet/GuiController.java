package com.travelnet;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class GuiController {
    @FXML
    private Label welcomeText;
    @FXML
    private Button register;

    @FXML
    protected void onAdiosButtonClick() {
        welcomeText.setText("Adios!");
    }

    public void onRegister(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(Gui.class.getResource("register-menu.fxml"));
        Scene scene = null;
        try {
            Stage stage = (Stage) register.getScene().getWindow();
            scene = new Scene(fxmlLoader.load(), 600, 400);
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}