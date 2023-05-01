package com.travelnet.controller;

import com.travelnet.model.users.User;
import com.travelnet.view.Gui;
import com.travelnet.view.MainWindow;
import com.travelnet.model.users.UserHandler;
import com.travelnet.view.RegisterWindow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class GuiController implements Initializable {
    private UserHandler userHandler = new UserHandler();
    @FXML
    private Label welcomeText;
    @FXML
    private Button register;
    @FXML
    private Button login;
    @FXML
    private Button demoButton;

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;

    private UserHandler uh;

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
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void onRegister(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) register.getScene().getWindow();
            RegisterWindow register = new RegisterWindow();
            register.start(stage);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }@FXML
    public void onLogin(ActionEvent actionEvent) {
        try {
            User user = uh.loginUser(username.getText(), password.getText());
            if(user != null);{
                uh.getLogedInUsers().add(user);
                Stage stage = new Stage();
                MainWindow mainWindow = new MainWindow();
                mainWindow.start(stage);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.uh = UserHandler.getInstance();
    }
}