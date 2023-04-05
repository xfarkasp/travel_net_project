package com.travelnet.controller;

import com.travelnet.model.Exceptions.EmptyInputException;
import com.travelnet.model.users.User;
import com.travelnet.view.MainWindow;
import com.travelnet.model.users.UserHandler;
import com.travelnet.view.RegisterWindow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * The type Gui controller.
 * Controls the login window
 */
public class GuiController implements Initializable {

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

    @FXML
    private Label exceptionMessage;
    /**
     * Reference to UserHandler user database
     */
    private UserHandler uh;

    /**
     * On register.
     * Sets the scene to the register window
     * @param actionEvent the action event
     */
    @FXML
    public void onRegister(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) register.getScene().getWindow();
            RegisterWindow register = new RegisterWindow();
            register.start(stage);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * On login.
     * Checks if input values
     * After checks if user with inputted username and password does exist in the database
     * If user was successfully loged-in a new instance of MainWindow is created
     * @param actionEvent the action event
     */
    @FXML
    public void onLogin(ActionEvent actionEvent) {
        try {
            if(username.getText().equals("")){
                //if the username input is empty, EmptyInputException is thrown
                throw new EmptyInputException("Username field is empty!", new RuntimeException());
            }
            else if(password.getText().equals("")){
                //if the password input is empty, EmptyInputException is thrown
                throw new EmptyInputException("Password field is empty!", new RuntimeException());
            }
            exceptionMessage.setVisible(false);
            User user = uh.loginUser(username.getText(), password.getText());
            if (user != null)
            {
                uh.getLogedInUsers().add(user);
                Stage stage = new Stage();
                MainWindow mainWindow = new MainWindow();
                mainWindow.start(stage);
            }
        }
        //EmptyInputException handling
        catch (EmptyInputException e){
            System.out.println(e.getMessage());
            exceptionMessage.setVisible(true);
            exceptionMessage.setText(e.getMessage());
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Initializes controller
     * Deserilizes the user databased, if deserialization fails, creates new user database(Singleton)
     * Initializes window
     *
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.uh = UserHandler.getInstance();
        try {
            //deserialize user database
            FileInputStream loadUDB =  new FileInputStream("src/main/resources/serialization/UserDB.ser");
            ObjectInputStream load = new ObjectInputStream(loadUDB);
            uh.setUserList((ArrayList<User>) load.readObject());
            load.close();
            loadUDB.close();

        } catch (Exception e) {
            //if serialization fails singleton user database will have 0 users
            this.uh = UserHandler.getInstance();
        }
    }

}