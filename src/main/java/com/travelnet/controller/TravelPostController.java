package com.travelnet.controller;

import com.travelnet.model.cities.Bratislava;
import com.travelnet.model.cities.City;
import com.travelnet.model.users.Adult;
import com.travelnet.model.users.User;
import com.travelnet.model.utillity.Travel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.scene.image.Image;

public class TravelPostController implements Initializable {
    @FXML
    private Label captionText;

    @FXML
    private Label companionsText;

    @FXML
    private Label countryList;

    @FXML
    private ImageView joinTravel;

    @FXML
    private ImageView leaveTravel;

    @FXML
    private Label originCountry;

    @FXML
    private ImageView startTravel;

    @FXML
    private Label timeCreated;

    @FXML
    private ImageView travelImage;

    @FXML
    private Label userName;

//    public Travel setTravel(){
//        Travel newTravel = new Travel();
//    }
    /**
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Travel newTravel = new Travel(new Adult(), new ArrayList<User>(), new ArrayList<City>(), new Bratislava());
        captionText.setText("aaaaaaaaaaaaaa");
        //creating the image object
        InputStream stream = null;
        try {
            stream = new FileInputStream(newTravel.getCurrentCity().getImagePath());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Image image = new Image(stream);
        travelImage.setImage(image);

    }
}
