package com.travelnet.view;

import com.travelnet.controller.CityWindowController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.application.Application.launch;

/**
 * The type City window.
 */
public class CityWindow extends Application {
    private CityWindowController controllerInstance;
    @Override
    public void start(Stage stage)  {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../city-window.fxml"));

        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 1024, 720);
            controllerInstance = fxmlLoader.getController();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.setTitle("cityWindow");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Get controller instance city window controller.
     *
     * @return the city window controller
     */
    public CityWindowController getControllerInstance(){
        return controllerInstance;
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        launch();
    }
}
