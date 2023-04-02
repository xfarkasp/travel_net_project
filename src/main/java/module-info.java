module com.travelnet {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.travelnet to javafx.fxml;
    exports com.travelnet;

}