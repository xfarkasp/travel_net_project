package com.travelnet.controller;

import com.sun.tools.javac.Main;
import com.travelnet.model.cities.Bratislava;
import com.travelnet.model.cities.City;
import com.travelnet.model.cities.Vienna;
import com.travelnet.model.users.Adult;
import com.travelnet.model.users.User;
import com.travelnet.model.utillity.CityVisitor;
import com.travelnet.model.utillity.PostObserver;
import com.travelnet.model.utillity.Travel;
import com.travelnet.view.CityWindow;
import com.travelnet.view.Gui;
import com.travelnet.view.MainWindow;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;

import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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

    @FXML
    private VBox postVbox;

    Travel postTravel;

    MainWindowController mwc;

    /**
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Travel newTravel = new Travel(new Adult("demo", "demo"), new ArrayList<User>(), new ArrayList<City>(), new Bratislava());
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

    public void addNew(Travel travel, MainWindowController mainWindow) {
        mwc = mainWindow;
        userName.setText(travel.getOwner().getName());
        try {
            travelImage.setImage(new Image(new FileInputStream(travel.getCurrentCity().getImagePath())));
        }catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String strDate = dateFormat.format(date);
        timeCreated.setText(strDate);
        captionText.setText(travel.getAbout());
        originCountry.setText("Nove Zamky");
        companionsText.setText("Empty");
        countryList.setText("NOT IMPLEMENTED YET");
        postTravel = travel;
    }
    @FXML
    public void onJoinButton(javafx.scene.input.MouseEvent mouseEvent) {
        postTravel.getCompanions().add(mwc.getLogedIn());
        String companions = "";
        for(User userToPost:postTravel.getCompanions()){
            companions += userToPost.getName() + " ";
        }
        companionsText.setText(companions);
        //PostObserver.getInstance().notifySubjects();
    }

    public void onTravel(javafx.scene.input.MouseEvent mouseEvent) {
        CityVisitor visitor = new CityVisitor();
        System.out.println(postTravel.getCurrentCity().getClass());
        if(postTravel.getVehicle().travelTo(postTravel)){
            CityWindow cw = new CityWindow();
            Stage stage = (Stage) startTravel.getScene().getWindow();
            cw.start(stage);

            CityWindowController cwc = new CityWindowController();
            cwc.setUpUsers(this.postTravel);
        }

        //visitor.visit(postTravel.getCurrentCity());
        if(postTravel.getCurrentCity() instanceof Bratislava)
            visitor.visit((Bratislava) postTravel.getCurrentCity());
        else if(postTravel.getCurrentCity() instanceof Vienna)
            visitor.visit((Vienna) postTravel.getCurrentCity());
    }
}
