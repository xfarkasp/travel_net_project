package com.travelnet.controller;

import com.travelnet.model.users.UserHandler;
import com.travelnet.view.Gui;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class RegisterWindowController implements Initializable {

    @FXML
    private Button registerButton;

    @FXML
    private PasswordField registerPasswd;

    @FXML
    private TextField registerUsername;

    @FXML
    private ChoiceBox<String> userTypeDropdown;

    private UserHandler uh;

    @FXML
    void registerButtonClick(javafx.scene.input.MouseEvent mouseEvent) {
        uh.registerUser(registerUsername.getText(), registerPasswd.getText(), userTypeDropdown.getValue());
        exitSequence();
        Stage stage = (Stage) registerButton.getScene().getWindow();
        Gui login = new Gui();
        login.start(stage);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.uh = UserHandler.getInstance();
        userTypeDropdown.getItems().add("Adult");
        userTypeDropdown.getItems().add("Pilot");
        userTypeDropdown.getItems().add("Mechanic");
    }

    public void exitSequence(){
        System.out.println("exiting");

        try {
            FileOutputStream saveUDB =  new FileOutputStream("src/main/resources/serialization/UserDB.ser");
            ObjectOutputStream save = new ObjectOutputStream(saveUDB);
            save.writeObject(uh.getUserList());
            save.close();
            saveUDB.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
