package com.travelnet.controller;

import com.sun.tools.javac.Main;
import com.travelnet.model.cities.Bratislava;
import com.travelnet.model.cities.City;
import com.travelnet.model.cities.Vienna;
import com.travelnet.model.strategy.TravelCarStrategy;
import com.travelnet.model.strategy.TravelPlaneStrategy;
import com.travelnet.model.strategy.TravelStrategy;
import com.travelnet.model.users.Adult;
import com.travelnet.model.users.User;
import com.travelnet.model.utillity.CityVisitor;
import com.travelnet.model.utillity.PostObserver;
import com.travelnet.model.utillity.Travel;
import com.travelnet.model.vechicles.Car;
import com.travelnet.model.vechicles.Plane;
import com.travelnet.view.CityWindow;
import com.travelnet.view.Gui;
import com.travelnet.view.MainWindow;
import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
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

    @FXML
    private Label timeLeft;
    @FXML
    private Label arivalText;

    Travel postTravel;

    MainWindowController mwc;

    TravelStrategy actualStrategy;

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
        if(postTravel.getCompanions().size() > 0) {
            if (postTravel.getVehicle() instanceof Plane)
                travel(new TravelPlaneStrategy(postTravel));
            else if (postTravel.getVehicle() instanceof Car) {
                travel(new TravelCarStrategy(postTravel));
            }
        }


        //visitor.visit(postTravel.getCurrentCity());
//        if(postTravel.getCurrentCity() instanceof Bratislava)
//            visitor.visit((Bratislava) postTravel.getCurrentCity());
//        else if(postTravel.getCurrentCity() instanceof Vienna)
//            visitor.visit((Vienna) postTravel.getCurrentCity());
    }

    public void travel(TravelStrategy travelMethod){
        if(travelMethod.travelTo()){
            this.actualStrategy = travelMethod;
            travelImage.setImage(new Image(travelMethod.getTravelAnimation()));
            arivalText.setVisible(true);
            new delayService("pain").start();
        }
    }


    public class delayService extends Service<String> {
        private delayService(String timeLeft){
            setOnSucceeded(new EventHandler<WorkerStateEvent>() {
                @Override
                public void handle(WorkerStateEvent workerStateEvent) {
                    CityWindow cw = new CityWindow();
                    Stage stage = (Stage) startTravel.getScene().getWindow();
                    cw.start(stage);
                    cw.getControllerInstance().setUpUsers(TravelPostController.this.postTravel);
                }
            });
        }

        /**
         * @return
         */
        @Override
        protected Task<String> createTask() {
            return new Task<String>() {
                @Override
                protected String call() throws Exception {
                    int timeLeft =  actualStrategy.getTimeLeft();
                    do{

                        timeLeft =  actualStrategy.getTimeLeft();

                        Platform.runLater(() -> {
                            TravelPostController.this.timeLeft.setVisible(true);
                            TravelPostController.this.timeLeft.setText(String.valueOf(actualStrategy.getTimeLeft()));
                        });
                        Thread.sleep(10);
                    }while(timeLeft != 0);

                    return "ok";
                }
            };
        }
    }
}


