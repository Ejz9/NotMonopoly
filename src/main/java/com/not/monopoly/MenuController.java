package com.not.monopoly;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MenuController {
    @FXML
    ImageView playButton;

    public void handlePlayButton() throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main-board.fxml")));
        Stage window = (Stage) playButton.getScene().getWindow();
        window.setScene(new Scene(root, 800, 800));

    }

    @FXML
    ImageView menuButton;
    public void handleMenuButton() {
    // TODO -
    }

    @FXML
    ImageView exitButton;
    public void handleExitButton() {
        System.exit(1);
    }
}