package com.travelnet.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The type Travel window.
 */
public class TravelWindow extends Application {

    /**
     * @param stage
     * @throws Exception
     */
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main-window.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 1000, 900);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
}
