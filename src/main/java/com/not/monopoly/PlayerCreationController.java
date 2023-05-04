package com.not.monopoly;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class PlayerCreationController {
    int playerCount;
    @FXML
    ImageView backButton;

    public void handleBackButton() throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("menu-screen.fxml")));
        Stage window = (Stage) backButton.getScene().getWindow();
        window.setScene(new Scene(root, 1280, 720));

    }

    @FXML
    Button twoPlayerButton;
    public void handleTwoPlayerButton() {
        twoPlayerButton.setDisable(true);
        int playerCount = 2;
        threePlayerButton.setDisable(false);
        handleFourPlayerButton.setDisable(false);

    }

    @FXML
    Button threePlayerButton;
    public void handleThreePlayerButton() {

    }

    @FXML
    Button handleFourPlayerButton;
    public void handleFourPlayerButton() {

    }

    @FXML
    Button handleConfirmButton;
    public void handleConfirmButton() {

    }

    @FXML
    Button handleCancelButton;
    public void handleCancelButton() {

    }
}
