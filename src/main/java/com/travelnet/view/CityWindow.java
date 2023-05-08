package com.travelnet.view;

import com.travelnet.controller.CityWindowController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.application.Application.launch;

public class CityWindow extends Application {
    private CityWindowController controllerInstance;
    @Override
    public void start(Stage stage)  {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../city-window.fxml"));

        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 1000, 720);
            controllerInstance = fxmlLoader.getController();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.setTitle("cityWindow");
        stage.setScene(scene);
        stage.show();
    }

    public CityWindowController getControllerInstance(){
        return controllerInstance;
    }

    public static void main(String[] args) {
        launch();
    }
}
