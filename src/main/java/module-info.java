module com.not.monopoly {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.not.monopoly to javafx.fxml;
    exports com.not.monopoly;
}