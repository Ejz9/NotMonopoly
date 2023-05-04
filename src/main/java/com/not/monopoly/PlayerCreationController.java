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
    public static int playerCount;
    @FXML
    Button backButton;

    public void handleBackButton() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("menu-screen.fxml")));
        Stage window = (Stage) backButton.getScene().getWindow();
        window.setScene(new Scene(root, 1280, 720));
    }

    @FXML
    Button twoPlayerButton;
    public void handleTwoPlayerButton() {
        twoPlayerButton.setDisable(true);
        threePlayerButton.setDisable(false);
        fourPlayerButton.setDisable(false);
        cancelButton.setVisible(true);
        confirmButton.setVisible(true);
    }

    @FXML
    Button threePlayerButton;
    public void handleThreePlayerButton() {
        threePlayerButton.setDisable(true);
        twoPlayerButton.setDisable(false);
        fourPlayerButton.setDisable(false);
        cancelButton.setVisible(true);
        confirmButton.setVisible(true);
    }

    @FXML
    Button fourPlayerButton;
    public void handleFourPlayerButton() {
        fourPlayerButton.setDisable(true);
        twoPlayerButton.setDisable(false);
        threePlayerButton.setDisable(false);
        cancelButton.setVisible(true);
        confirmButton.setVisible(true);
    }

    @FXML
    Button confirmButton;
    public void handleConfirmButton() throws IOException {
        if (twoPlayerButton.isDisabled()){
            playerCount = 2;
        } else if (threePlayerButton.isDisabled()) {
            playerCount = 3;
        } else if (fourPlayerButton.isDisabled()) {
            playerCount = 4;
        }
        resetScene();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main-board.fxml")));
        Stage window = (Stage) backButton.getScene().getWindow();
        window.setScene(new Scene(root, 1280, 720));
    }

    @FXML
    Button cancelButton;
    public void handleCancelButton() {
        playerCount = 0;
        resetScene();
    }

    public void resetScene() {
        twoPlayerButton.setDisable(false);
        threePlayerButton.setDisable(false);
        fourPlayerButton.setDisable(false);
        cancelButton.setVisible(false);
        confirmButton.setVisible(false);
    }
}
