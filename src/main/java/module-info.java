module com.not.monopoly {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.not.monopoly to javafx.fxml;
    exports com.not.monopoly;
    exports com.not.monopoly.DONOTSUBMIT;
    opens com.not.monopoly.DONOTSUBMIT to javafx.fxml;
}