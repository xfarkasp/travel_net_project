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

/**
 * The type Register window controller.
 * Controlls the RegisterWindow
 */
public class RegisterWindowController implements Initializable {

    @FXML
    private Button registerButton;

    @FXML
    private PasswordField registerPasswd;

    @FXML
    private TextField registerUsername;

    @FXML
    private ChoiceBox<String> userTypeDropdown;
    /**
     * UserHandler database reference
     */
    private UserHandler uh;

    /**
     * Register button click.
     * Creates a new user with inputed parameters
     * and adds it to the user singleton database UserHandler
     *
     * @param mouseEvent the mouse event
     */
    @FXML
    void registerButtonClick(javafx.scene.input.MouseEvent mouseEvent) {
        uh.registerUser(registerUsername.getText(), registerPasswd.getText(), userTypeDropdown.getValue());
        exitSequence();
        Stage stage = (Stage) registerButton.getScene().getWindow();
        Gui login = new Gui();
        login.start(stage);
    }
    /**
     * Initialize window
     *
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.uh = UserHandler.getInstance();
        userTypeDropdown.getItems().add("Adult");
        userTypeDropdown.getItems().add("Pilot");
        userTypeDropdown.getItems().add("Mechanic");
    }

    /**
     * Exit sequence.
     * Serializes the all the users after a new user was added to the UserHandler database
     * and register window is being destructed.
     *
     */
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
