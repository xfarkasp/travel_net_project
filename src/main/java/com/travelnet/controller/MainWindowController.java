package com.travelnet.controller;

import com.travelnet.model.cities.Vienna;
import com.travelnet.model.users.UserHandler;
import com.travelnet.model.utillity.PostObserver;
import com.travelnet.model.utillity.TravelCreator;
import com.travelnet.view.Gui;
import com.travelnet.model.cities.Bratislava;
import com.travelnet.model.cities.City;
import com.travelnet.model.users.Adult;
import com.travelnet.model.users.User;
import com.travelnet.model.utillity.Travel;
import javafx.fxml.FXML;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 * The type Main window controller.
 * Controls the MainWindow
 *
 */
public class MainWindowController implements Initializable {
    @FXML
    private ImageView addButton;

    @FXML
    private ImageView chatButton;

    @FXML
    private ImageView optionsButton;

    @FXML
    private ImageView travelButton;

    @FXML
    private ImageView userPic;

    @FXML
    private VBox travelContainer;

    @FXML
    private VBox leftVbox;

    private User logedIn;

    private TravelCreator tc;

    private UserHandler uh;

    /**
     * Gets travel container.
     *
     * @return the travel container
     */
    public VBox getTravelContainer() {
        return travelContainer;
    }

    /**
     * Update.
     * This method is called by the PostObserver class to add new post to all main window instances
     * when new post is added.
     */
    public void update(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Gui.class.getResource("../travel-post.fxml"));
            Parent root = (Parent) fxmlLoader.load();

            TravelPostController travelPostController = fxmlLoader.getController();
            travelPostController.addNew(tc.travelList().get(tc.travelList().size() - 1), this);
            //adds a new TravelPost VBox widget to travel container
            travelContainer.getChildren().add(0, root);
            if(leftVbox.getChildren().size() > 0)
                leftVbox.getChildren().remove(0);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Delete.
     *This method is called by the PostObserver class to remove post from all main window instances
     * when post has been deleted.
     *
     * @param index the index
     */
    public void delete(int index){
        getTravelContainer().getChildren().remove(index);
    }

    /**
     * On add button pressed.
     * Creates a TravelCreator widget in the lefPane on the MainWinow instance
     * to create a new travel.
     *
     * @param mouseEvent the mouse event
     */
    public void onAddButtonPressed(javafx.scene.input.MouseEvent mouseEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Gui.class.getResource("../travel-creator.fxml"));
            VBox vBox = fxmlLoader.load();
            TravelCreatorController travelCreatorController = fxmlLoader.getController();
            travelCreatorController.setUserData(logedIn);
            travelCreatorController.setParentMainWindow(this);
            leftVbox.getChildren().add(0, vBox);
            TravelCreator tc = TravelCreator.getInstance();
            System.out.println(tc.test());

        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Get loged in user.
     *
     * @return the user
     */
    public User getLogedIn(){
        return logedIn;
    }

    /**
     * Initialize window
     * Add instance of this controller to observer subs
     *
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            tc = TravelCreator.getInstance();
            uh = UserHandler.getInstance();
            logedIn = uh.getLogedInUsers().get(uh.getLogedInUsers().size() - 1);
            //add this object to observer subjects
            PostObserver.getInstance().subscribe(this);
            for(Travel travel: tc.travelList()){
                FXMLLoader fxmlLoader = new FXMLLoader(Gui.class.getResource("../travel-post.fxml"));
                VBox vBox = fxmlLoader.load();
                TravelPostController travelPostController = fxmlLoader.getController();
                travelPostController.addNew(travel, this);
                travelContainer.getChildren().add(vBox);
            }
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
