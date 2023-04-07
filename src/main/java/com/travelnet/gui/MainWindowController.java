package com.travelnet.gui;

import com.travelnet.Gui;
import com.travelnet.cities.Bratislava;
import com.travelnet.cities.City;
import com.travelnet.users.Adult;
import com.travelnet.users.User;
import com.travelnet.utillity.Travel;
import javafx.fxml.FXML;


import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
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

    private ArrayList<Travel> travelList;


    public void onAddButtonPressed(javafx.scene.input.MouseEvent mouseEvent) {
        System.out.println("input detected");
        travelList.add(new Travel(new Adult(), new ArrayList<User>(), new ArrayList<City>(), new Bratislava()));
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Gui.class.getResource("travel-post.fxml"));
            VBox vBox = fxmlLoader.load();
            TravelPostController travelPostController = fxmlLoader.getController();
            //travelPostController.setData(travel);
            travelContainer.getChildren().add(vBox);
        }catch (IOException e) {
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
        travelList.add(new Travel(new Adult(), new ArrayList<User>(), new ArrayList<City>(), new Bratislava()));
        try {
            for(Travel travel: travelList){

                FXMLLoader fxmlLoader = new FXMLLoader(Gui.class.getResource("travel-post.fxml"));
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
