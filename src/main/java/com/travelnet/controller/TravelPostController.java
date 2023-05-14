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
import com.travelnet.model.utillity.TravelCreator;
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

/**
 * The type Travel post controller.
 * Controls the TravelPost
 */
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

    /**
     * The Post travel.
     */
    Travel postTravel;

    /**
     * The Mwc of the parent.
     */
    MainWindowController mwc;

    /**
     * The Actual strategy.
     */
    TravelStrategy actualStrategy;

    /**
     * Initializes TravelPost
     *
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

    /**
     * Add new.
     * This method sets the data of the TravelPost after it's creation
     *
     * @param travel     the travel
     * @param mainWindow the main window
     */
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
        postTravel = travel;
    }

    /**
     * On join button.
     * Adds a User object to the travelCompanion list of the travel
     * @param mouseEvent the mouse event
     */
    @FXML
    public void onJoinButton(javafx.scene.input.MouseEvent mouseEvent) {
        postTravel.getCompanions().add(mwc.getLogedIn());
        String companions = "";
        for(User userToPost:postTravel.getCompanions()){
            companions += userToPost.getName() + " ";
        }
    }

    /**
     * On travel.
     * If travel companion list is not empty then selects the travel strategy
     * based on the instance of the selected Vehicle object
     * @param mouseEvent the mouse event
     */
    public void onTravel(javafx.scene.input.MouseEvent mouseEvent) {

        if(postTravel.getCompanions().size() > 0) {
            if (postTravel.getVehicle() instanceof Plane)
                travel(new TravelPlaneStrategy(postTravel));
            else if (postTravel.getVehicle() instanceof Car) {
                travel(new TravelCarStrategy(postTravel));
            }
        }
    }

    /**
     * Travel to a new city using a strategy
     * if the strategy returns true a delay service is started ona new thread
     * of the subclass which is of a task api
     *
     * @param travelMethod the travel method
     */
    public void travel(TravelStrategy travelMethod){
        if(travelMethod.travelTo()){
            this.actualStrategy = travelMethod;
            travelImage.setImage(new Image(travelMethod.getTravelAnimation()));
            arivalText.setVisible(true);
            new delayService("pain").start();

        }
    }

    /**
     * On remove.
     * When remove button selected PostObserver notifys subs
     * to remove post based on its index
     * @param mouseEvent the mouse event
     */
    public void onRemove(javafx.scene.input.MouseEvent mouseEvent) {
        //TravelCreator.getInstance().travelList().remove(TravelCreator.getInstance().travelList().indexOf(postTravel));
        int indexRemove = -1;
        for(Travel travel: TravelCreator.getInstance().travelList()){
            if(travel.equals(postTravel)){
                indexRemove = TravelCreator.getInstance().travelList().indexOf(travel);
                TravelCreator.getInstance().travelList().remove(travel);
                //index is from newest to oldest in the MainWindowController container
                indexRemove =TravelCreator.getInstance().travelList().size() - indexRemove;
                break;
            }
        }
        if(indexRemove > -1)
            PostObserver.getInstance().notifyDeleter(indexRemove);
    }


    /**
     * Subclass of task api to create a new thread for traveling delay.
     */
    public class delayService extends Service<String> {
        private delayService(String timeLeft){
            setOnSucceeded(new EventHandler<WorkerStateEvent>() {
                @Override
                public void handle(WorkerStateEvent workerStateEvent) {
                    CityWindow cw = new CityWindow();
                    Stage stage = new Stage();
                    cw.start(stage);
                    cw.getControllerInstance().setTravel(TravelPostController.this.postTravel);
                }
            });
        }

        /**
         * Task count time remaining and updates Gui from another thread
         *
         * @return "ok"
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


