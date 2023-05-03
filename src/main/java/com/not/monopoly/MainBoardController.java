package com.not.monopoly;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainBoardController {
    @FXML
    private Label welcomeText = new Label();

    @FXML
    protected void onRoll() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}