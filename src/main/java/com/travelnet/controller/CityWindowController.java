package com.travelnet.controller;

import com.travelnet.model.Exceptions.EmptyInputException;
import com.travelnet.model.cities.Bratislava;
import com.travelnet.model.cities.City;
import com.travelnet.model.cities.Paris;
import com.travelnet.model.cities.Vienna;
import com.travelnet.model.strategy.TravelCarStrategy;
import com.travelnet.model.strategy.TravelPlaneStrategy;
import com.travelnet.model.strategy.TravelStrategy;
import com.travelnet.model.users.User;
import com.travelnet.model.users.UserHandler;
import com.travelnet.model.utillity.CityVisitor;
import com.travelnet.model.utillity.PostObserver;
import com.travelnet.model.utillity.Travel;
import com.travelnet.model.utillity.TravelCreator;
import com.travelnet.model.vechicles.Car;
import com.travelnet.model.vechicles.Plane;
import com.travelnet.model.vechicles.Vehicle;
import com.travelnet.view.CityWindow;
import com.travelnet.view.Gui;
import com.travelnet.view.RegisterWindow;
import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static com.sun.javafx.scene.control.skin.Utils.getResource;

/**
 * City window controller for the CityWindow window of the gui.
 */
public class CityWindowController implements Initializable {

    public VBox leftVbox;

    @FXML
    public VBox userContainer;

    @FXML
    private ImageView leaveButton;
    @FXML
    private Pane leftPane;
    @FXML
    private VBox usersBox;
    @FXML
    private ImageView nextTravelButton;

    @FXML
    private Button showHotels;
    @FXML
    private Button showInterests;
    @FXML
    private Button showRestaurants;

    @FXML
    private ImageView vehicleIMG;
    @FXML
    private Label condition;

    @FXML
    private Label arivalText;
    @FXML
    private Label timeLeft;

    @FXML
    private Pane mapPane;
    @FXML
    private ChoiceBox<String> cityDropdown;
    @FXML
    private ChoiceBox<String> vehicleDropDown;

    private MapController map;
    private boolean zazitokFlag = false;
    private boolean restauraciaFlag = false;
    private boolean hotelFlag = false;
    private Travel currentTravel;

   private Vehicle car;
   private Vehicle plane;


    /**
     * Sets up map pane controller.
     *
     * @param map the map
     */
    public void setMap(MapController map){
        this.map = map;
    }

    /**
     * The Actual strategy.
     */
    TravelStrategy actualStrategy;

    /**
     * Show hotels clicked.
     *
     * @param event the event
     */
    @FXML
    void showHotelsClicked(MouseEvent event) {
        map.showHotelsClicked();
    }

    /**
     * Show interests clicked.
     *
     * @param event the event
     */
    @FXML
    void showInterestsClicked(MouseEvent event) {
       map.showInterestsClicked();
    }

    /**
     * Show restaurants clicked.
     *
     * @param event the event
     */
    @FXML
    void showRestaurantsClicked(MouseEvent event) {
       map.showRestaurantsClicked();
    }

    /**
     * Sets up the windows based on the travel object attribute of this object.
     */
    @FXML
    public void setUp(){
        userContainer.getChildren().clear();
        for(User user: currentTravel.getCompanions()){
            FXMLLoader fxmlLoader = new FXMLLoader(Gui.class.getResource("../user-status.fxml"));
            VBox vBox = null;
            try {
                vBox = fxmlLoader.load();
                UserStatusController usc = fxmlLoader.getController();
                usc.setUp(user, currentTravel.getVehicle(), condition);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            userContainer.getChildren().add(vBox);
        }
        condition.setText(String.valueOf(currentTravel.getVehicle().getCondition()));
        vehicleIMG.setImage(new Image(currentTravel.getVehicle().getIcon()));
        visit();
    }

    private void visit(){
        CityVisitor visitor = new CityVisitor(this);
        visitor.visit(currentTravel.getCurrentCity());
        if(currentTravel.getCurrentCity() instanceof Bratislava){
            this.mapPane.getChildren().add(visitor.visit((Bratislava) currentTravel.getCurrentCity()));
        }
        else if(currentTravel.getCurrentCity() instanceof Vienna)
            visitor.visit((Vienna) currentTravel.getCurrentCity());
        else if(currentTravel.getCurrentCity() instanceof Paris)
            this.mapPane.getChildren().add(visitor.visit((Paris) currentTravel.getCurrentCity()));
    }

    /**
     * Set travel.
     *
     * @param travel the travel
     */
    public void setTravel(Travel travel){
        this.currentTravel = travel;
        if(travel.getVehicle() instanceof Plane)
            this.plane = travel.getVehicle();
        if(travel.getVehicle() instanceof Car)
            this.car = travel.getVehicle();
        setUp();
    }

    /**
     * Handler for traveling to a new city.
     * Updates the city and vehicle objects in travel object
     * from dropdown widgets, then calls the appropriat travel strategy
     * @param event the event
     */
    @FXML
    void nextTravelButton(MouseEvent event) {
        try{
            if(cityDropdown.getValue() == null)
                throw new EmptyInputException("City field is empty!", new RuntimeException());
            if(vehicleDropDown.getValue() == null)
                throw new EmptyInputException("Vehicle field is empty!", new RuntimeException());

            //new city setup
            if(cityDropdown.getValue().equals("Paris"))
                currentTravel.setCurrentCity(new Paris());
            else if(cityDropdown.getValue().equals("Bratislava"))
                currentTravel.setCurrentCity(new Bratislava());

            //new vehicle setup
            if(vehicleDropDown.getValue().equals("Car"))
                currentTravel.setVehicle(this.car);
            else if(vehicleDropDown.getValue().equals("Plane"))
                currentTravel.setVehicle(this.plane);

            if (currentTravel.getCompanions().size() > 0) {
                if (currentTravel.getVehicle() instanceof Plane)
                    travel(new TravelPlaneStrategy(currentTravel));
                else if (currentTravel.getVehicle() instanceof Car) {
                    travel(new TravelCarStrategy(currentTravel));
                }
            }
        }catch(EmptyInputException e){
            System.out.println(e.getMessage());
            if(e.getMessage().equals("City field is empty!"))
                cityDropdown.setValue("You must select a city!");
            else if(e.getMessage().equals("Vehicle field is empty!"))
                vehicleDropDown.setValue("You must select a Vehicle!");
        }
    }


    @FXML
    void leaveButton(MouseEvent event) {
        try {
            Stage stage = (Stage) leaveButton.getParent().getScene().getWindow();
            stage.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Travel to a new city using a strategy
     * if the strategy returns true a delay service is started ona new thread
     * of the sub-class which is of a task api
     * @param travelMethod the travel method
     */
    public void travel(TravelStrategy travelMethod){
        if(travelMethod.travelTo()){
            this.map.setImg(travelMethod.getTravelAnimation());
            this.actualStrategy = travelMethod;
            //travelImage.setImage(new Image(travelMethod.getTravelAnimation()));
            arivalText.setVisible(true);
            new delayService("pain").start();
        }
    }


    /**
     * Subclass of task api to create a new thread for traveling delay.
     */
    public class delayService extends Service<String> {
        private delayService(String timeLeft){
            setOnSucceeded(new EventHandler<WorkerStateEvent>() {
                @Override
                public void handle(WorkerStateEvent workerStateEvent) {
                    arivalText.setVisible(false);
                    CityWindowController.this.timeLeft.setVisible(false);
                    mapPane.getChildren().clear();
                    setUp();
                }
            });
        }

        /**
         * Task to update time remaining of travel
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
                            CityWindowController.this.timeLeft.setVisible(true);
                            CityWindowController.this.timeLeft.setText(String.valueOf(actualStrategy.getTimeLeft()));
                        });
                        Thread.sleep(10);
                    }while(timeLeft != 0);

                    return "ok";
                }
            };
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        userContainer.getChildren();
        cityDropdown.getItems().add("Bratislava");
        cityDropdown.getItems().add("Vienna");
        cityDropdown.getItems().add("BudaPest");
        cityDropdown.getItems().add("Paris");
        vehicleDropDown.getItems().add("Car");
        vehicleDropDown.getItems().add("Plane");
        this.car = new Car();
        this.plane = new Plane();
    }
}
