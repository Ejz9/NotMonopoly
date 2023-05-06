package com.not.monopoly;

import com.not.monopoly.Objects.Property;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.not.monopoly.Main.players;
import static com.not.monopoly.PlayerCreationController.playerCount;

public class TradeScreen {
    @FXML
    GridPane propertiesGridPane;
    @FXML
    Button playerOneTradeButton;
    @FXML
    Button playerTwoTradeButton;
    @FXML
    Button playerThreeTradeButton;
    @FXML
    Button playerFourTradeButton;

    @FXML
    Button cashButton;
    @FXML
    Button mediterraneanAvenueButton;
    @FXML
    Button balticAvenueButton;

    @FXML
    Button orientalAvenueButton;
    @FXML
    Button vermontAvenueButton;
    @FXML
    Button connecticutAvenueButton;

    @FXML
    Button stCharlesPlaceButton;
    @FXML
    Button statesAvenueButton;
    @FXML
    Button virginiaAvenueButton;

    @FXML
    Button stJamesPlaceButton;
    @FXML
    Button tennesseeAvenueButton;
    @FXML
    Button newYorkAvenueButton;

    @FXML
    Button kentuckyAvenueButton;
    @FXML
    Button indianaAvenueButton;
    @FXML
    Button illinoisAvenueButton;

    @FXML
    Button atlanticAvenueButton;
    @FXML
    Button ventnorAvenueButton;
    @FXML
    Button marvinGardensButton;

    @FXML
    Button pacificAvenueButton;
    @FXML
    Button northCarolinaAvenueButton;
    @FXML
    Button pennsylvaniaAvenueButton;

    @FXML
    Button parkPlaceButton;
    @FXML
    Button boardwalkButton;

    @FXML
    Button readingRailroadButton;
    @FXML
    Button pennsylvaniaRailroadButton;
    @FXML
    Button bandORailroadButton;
    @FXML
    Button shortLineButton;

    @FXML
    Button waterWorksButton;
    @FXML
    Button electricCompanyButton;
    Button tradeButton;
    @FXML
    TextArea tradeCartTextArea;
    List<Property> propertyList;

    List<String> spaces = PropertyCreation.createPropertyNamesList();
    List<Button> buttonList = new ArrayList<>();


    public TradeScreen() throws IOException {
    }

    public void runTrade() throws IOException {
        playerOneTradeButton.setText(players.get(0).getName());
        playerTwoTradeButton.setText(players.get(1).getName());
        if (playerCount == 3) {
            playerThreeTradeButton.setVisible(true);
            playerThreeTradeButton.setText(players.get(2).getName());
        }
        if (playerCount == 4) {
            playerFourTradeButton.setVisible(true);
            playerFourTradeButton.setText(players.get(3).getName());
        }
        addButtons(mediterraneanAvenueButton, balticAvenueButton, orientalAvenueButton, vermontAvenueButton, connecticutAvenueButton, stCharlesPlaceButton, statesAvenueButton, virginiaAvenueButton, stJamesPlaceButton, tennesseeAvenueButton, newYorkAvenueButton, kentuckyAvenueButton, indianaAvenueButton, illinoisAvenueButton);
        addButtons(atlanticAvenueButton, ventnorAvenueButton, marvinGardensButton, pacificAvenueButton, northCarolinaAvenueButton, pennsylvaniaAvenueButton, parkPlaceButton, boardwalkButton, readingRailroadButton, pennsylvaniaAvenueButton, bandORailroadButton, shortLineButton, electricCompanyButton, waterWorksButton);
    }

    private void addButtons(Button mediterraneanAvenueButton, Button balticAvenueButton, Button orientalAvenueButton, Button vermontAvenueButton, Button connecticutAvenueButton, Button stCharlesPlaceButton, Button statesAvenueButton, Button virginiaAvenueButton, Button stJamesPlaceButton, Button tennesseeAvenueButton, Button newYorkAvenueButton, Button kentuckyAvenueButton, Button indianaAvenueButton, Button illinoisAvenueButton) {
        buttonList.add(mediterraneanAvenueButton);
        buttonList.add(balticAvenueButton);
        buttonList.add(orientalAvenueButton);
        buttonList.add(vermontAvenueButton);
        buttonList.add(connecticutAvenueButton);
        buttonList.add(stCharlesPlaceButton);
        buttonList.add(statesAvenueButton);
        buttonList.add(virginiaAvenueButton);
        buttonList.add(stJamesPlaceButton);
        buttonList.add(tennesseeAvenueButton);
        buttonList.add(newYorkAvenueButton);
        buttonList.add(kentuckyAvenueButton);
        buttonList.add(indianaAvenueButton);
        buttonList.add(illinoisAvenueButton);
    }

    public void handlePlayerOneTradeButton() {
        propertyList = players.get(0).getProperties();
        handleGridFrame(propertyList);
    }
    public void handlePlayerTwoTradeButton() {
        propertyList = players.get(1).getProperties();
        handleGridFrame(propertyList);
    }
    public void handlePlayerThreeTradeButton() {
        propertyList = players.get(2).getProperties();
        handleGridFrame(propertyList);
    }
    public void handlePlayerFourTradeButton() {
        propertyList = players.get(3).getProperties();
        handleGridFrame(propertyList);
    }

    public void handleGridFrame(List<Property> propertyList) {
        for (Property property : propertyList) {
            if (property.equals("Mediterranean Avenue")) {
                buttonList.get(0).setDisable(false);
            } else if (property.getName().equals("Baltic Avenue")) {
                buttonList.get(1).setDisable(false);
            } else if (property.getName().equals("Oriental Avenue")) {
                buttonList.get(2).setDisable(false);
            } else if (property.getName().equals("Vermont Avenue")) {
                buttonList.get(3).setDisable(false);
            } else if (property.getName().equals("Connecticut Avenue")) {
                buttonList.get(4).setDisable(false);
            } else if (property.getName().equals("St. Charles Place")) {
                buttonList.get(5).setDisable(false);
            } else if (property.getName().equals("States Avenue")) {
                buttonList.get(6).setDisable(false);
            } else if (property.getName().equals("Virginia Avenue")) {
                buttonList.get(7).setDisable(false);
            } else if (property.getName().equals("St. James Place")) {
                buttonList.get(8).setDisable(false);
            } else if (property.getName().equals("Tennessee Avenue")) {
                buttonList.get(9).setDisable(false);
            } else if (property.getName().equals("New York Avenue")) {
                buttonList.get(10).setDisable(false);
            } else if (property.getName().equals("Kentucky Avenue")) {
                buttonList.get(11).setDisable(false);
            } else if (property.getName().equals("Indiana Avenue")) {
                buttonList.get(12).setDisable(false);
            } else if (property.getName().equals("Illinois Avenue")) {
                buttonList.get(13).setDisable(false);
            } else if (property.getName().equals("Atlantic Avenue")) {
                buttonList.get(14).setDisable(false);
            } else if (property.getName().equals("Ventnor Avenue")) {
                buttonList.get(15).setDisable(false);
            } else if (property.getName().equals("Marvin Gardens")) {
                buttonList.get(16).setDisable(false);
            } else if (property.getName().equals("Pacific Avenue")) {
                buttonList.get(17).setDisable(false);
            } else if (property.getName().equals("North Carolina Avenue")) {
                buttonList.get(18).setDisable(false);
            } else if (property.getName().equals("Pennsylvania Avenue")) {
                buttonList.get(19).setDisable(false);
            } else if (property.getName().equals("Park Place")) {
                buttonList.get(20).setDisable(false);
            } else if (property.getName().equals("Boardwalk")) {
                buttonList.get(21).setDisable(false);
            } else if (property.getName().equals("Reading Railroad")) {
                buttonList.get(22).setDisable(false);
            } else if (property.getName().equals("Pennsylvania Railroad")) {
                buttonList.get(23).setDisable(false);
            } else if (property.getName().equals("B & O Railroad")) {
                buttonList.get(24).setDisable(false);
            } else if (property.getName().equals("Short Line")) {
                buttonList.get(25).setDisable(false);
            } else if (property.getName().equals("Electric Company")) {
                buttonList.get(26).setDisable(false);
            } else if (property.getName().equals("Water Works")) {
                buttonList.get(27).setDisable(false);
            }
        }
    }


    public void handleButton() {
        for (Button button : buttonList) {
            if (button.isPressed()) {
                button.setDisable(true);
                tradeCartTextArea.appendText(String.format("%n%s", spaces.get(buttonList.indexOf(button))));
            }
        }
    }

    public void handleCancelButton() {
        resetButtons();

    }

    public void handleConfirmButton() {

    }

    public void resetButtons() {
        for (Button button : buttonList) {
            button.setDisable(true);
        }
    }
}