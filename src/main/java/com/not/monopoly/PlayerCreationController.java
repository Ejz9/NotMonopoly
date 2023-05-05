package com.not.monopoly;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class PlayerCreationController {
    protected static int playerCount;
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
    @FXML
    TextField playerOneName;
    @FXML
    CheckBox playerOneCheck;
    @FXML
    String playerOne;
    @FXML
    TextField playerTwoName;
    @FXML
    CheckBox playerTwoCheck;
    @FXML
    String playerTwo;
    @FXML
    TextField playerThreeName;
    @FXML
    CheckBox playerThreeCheck;
    @FXML
    String playerThree;
    @FXML
    TextField playerFourName;
    @FXML
    CheckBox playerFourCheck;
    @FXML
    String playerFour;
    @FXML
    Label countQuestion;
    @FXML
    Label nameQuestion;
    public void handleConfirmButton() {
        if (twoPlayerButton.isDisabled()){
            playerCount = 2;
        } else if (threePlayerButton.isDisabled()) {
            playerCount = 3;
        } else if (fourPlayerButton.isDisabled()) {
            playerCount = 4;
        }
        setPLayerNameScene();
    }

    @FXML
    Button cancelButton;
    public void handleCancelButton() {
        playerCount = 0;
        resetScene();
    }

    @FXML
    Button proceedToGameButton;
    public void handlePlayerCreation() {
        if (proceedToGameButton.isVisible()) {
            proceedToGameButton.setVisible(false);
        }
        playerOneName.setEditable(!playerOneCheck.isSelected());
        playerTwoName.setEditable(!playerTwoCheck.isSelected());
        playerThreeName.setEditable(!playerThreeCheck.isSelected());
        playerFourName.setEditable(!playerFourCheck.isSelected());

        switch (playerCount) {
            case 2 -> {
                if (playerOneCheck.isSelected() && playerTwoCheck.isSelected()) {
                    proceedToGameButton.setVisible(true);
                    playerOne = playerOneName.getText();
                    playerTwo = playerTwoName.getText();
                }
            }
            case 3 -> {
                if (playerOneCheck.isSelected() && playerTwoCheck.isSelected() && playerThreeCheck.isSelected()) {
                    proceedToGameButton.setVisible(true);
                    playerOne = playerOneName.getText();
                    playerTwo = playerTwoName.getText();
                    playerThree = playerThreeName.getText();
                }
            }
            case 4 -> {
                if (playerOneCheck.isSelected() && playerTwoCheck.isSelected() && playerThreeCheck.isSelected() && playerFourCheck.isSelected()) {
                    proceedToGameButton.setVisible(true);
                    playerOne = playerOneName.getText();
                    playerTwo = playerTwoName.getText();
                    playerThree = playerThreeName.getText();
                    playerFour = playerFourName.getText();
                }
            }
        }
    }

    public void handlePlayMonopoly() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main-board.fxml")));
        Stage window = (Stage) backButton.getScene().getWindow();
        window.setScene(new Scene(root, 1280, 720));
    }

    @FXML
    Button backNameButton;
    public void handleBackNameButton() {

    }

    public void resetScene() {
        twoPlayerButton.setDisable(false);
        twoPlayerButton.setVisible(true);
        threePlayerButton.setDisable(false);
        threePlayerButton.setVisible(true);
        fourPlayerButton.setDisable(false);
        fourPlayerButton.setVisible(true);
        cancelButton.setVisible(false);
        confirmButton.setVisible(false);
        playerNamePane.setDisable(false);
        playerNamePane.setVisible(false);
        playerThreeName.setVisible(false);
        playerThreeCheck.setVisible(false);
        playerFourName.setVisible(false);
        playerFourCheck.setVisible(false);
    }

    @FXML
    Pane playerCountPane;
    @FXML
    Pane playerNamePane;
    public void setPLayerNameScene() {
        playerCountPane.setVisible(false);

        if (playerCount == 2) {
            playerOneName.setVisible(true);
            playerOneCheck.setVisible(true);
            playerTwoName.setVisible(true);
            playerTwoCheck.setVisible(true);
        } else if (playerCount == 3) {
            playerOneName.setVisible(true);
            playerOneCheck.setVisible(true);
            playerTwoName.setVisible(true);
            playerTwoCheck.setVisible(true);
            playerThreeName.setVisible(true);
            playerThreeCheck.setVisible(true);
        } else if (playerCount == 4) {
            playerOneName.setVisible(true);
            playerOneCheck.setVisible(true);
            playerTwoName.setVisible(true);
            playerTwoCheck.setVisible(true);
            playerThreeName.setVisible(true);
            playerThreeCheck.setVisible(true);
            playerFourName.setVisible(true);
            playerFourCheck.setVisible(true);
        }
        playerNamePane.setVisible(true);
        playerNamePane.setDisable(false);
        nameQuestion.setVisible(true);
        confirmButton.setTooltip(new Tooltip("Proceed to the the world of Monopoly!"));
    }
}
