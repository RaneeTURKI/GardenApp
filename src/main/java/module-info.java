module com.mycompany.gardenapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.gardenapp to javafx.fxml;
    exports com.mycompany.gardenapp;
}
