package com.travelnet.controller;

import com.travelnet.model.cities.Vienna;
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
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

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

    private ArrayList<Travel> travelList;

    void addTravel(Travel travel){
        try {
        FXMLLoader fxmlLoader = new FXMLLoader(Gui.class.getResource("../travel-post.fxml"));
        Parent root = (Parent) fxmlLoader.load();

        TravelPostController travelPostController = fxmlLoader.getController();
        travelPostController.addNew(travel);


        travelContainer.getChildren().add(0, root);
        leftVbox.getChildren().remove(0);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }

    public void onAddButtonPressed(javafx.scene.input.MouseEvent mouseEvent) {
        System.out.println("input detected");
        travelList.add(new Travel(new Adult(), new ArrayList<User>(), new ArrayList<City>(), new Bratislava()));
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Gui.class.getResource("../travel-creator.fxml"));
            VBox vBox = fxmlLoader.load();
            TravelCreatorController travelCreatorController = fxmlLoader.getController();
            travelCreatorController.setUserData(travelList.get(travelList.size()-1).getOwner());
            travelCreatorController.setParentMainWindow(this);
            leftVbox.getChildren().add(0, vBox);

        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setTravelPost() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Gui.class.getResource("../travel-post.fxml"));
            VBox vBox = null;

            vBox = fxmlLoader.load();
            TravelPostController travelPostController = fxmlLoader.getController();
            leftVbox.getChildren().add(0, vBox);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        travelList = new ArrayList<>();
        try {
            for(Travel travel: travelList){

                FXMLLoader fxmlLoader = new FXMLLoader(Gui.class.getResource("../travel-post.fxml"));
                VBox vBox = fxmlLoader.load();
                TravelPostController travelPostController = fxmlLoader.getController();
                //travelPostController.setData(travel);
                travelContainer.getChildren().add(vBox);
            }
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
