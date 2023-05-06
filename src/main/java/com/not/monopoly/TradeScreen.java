package com.not.monopoly;

import com.not.monopoly.Objects.Property;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

import static com.not.monopoly.Main.activePlayer;
import static com.not.monopoly.Main.players;
import static com.not.monopoly.PlayerCreationController.playerCount;
import static com.not.monopoly.PropertyCreation.createSpaces;

public class TradeScreen {
    @FXML
    Pane startPane;
    @FXML
    Button startButton;
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
    List<Property> propertyList;

    Property[] spaces = createSpaces();
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
        startPane.setVisible(false);
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
        resetPlayerButtons();
        playerOneTradeButton.setDisable(true);
        handleGridFrame(propertyList);
    }
    public void handlePlayerTwoTradeButton() {
        propertyList = players.get(1).getProperties();
        resetPlayerButtons();
        playerTwoTradeButton.setDisable(true);
        handleGridFrame(propertyList);
    }
    public void handlePlayerThreeTradeButton() {
        propertyList = players.get(2).getProperties();
        resetPlayerButtons();
        playerThreeTradeButton.setDisable(true);
        handleGridFrame(propertyList);
    }
    public void handlePlayerFourTradeButton() {
        propertyList = players.get(3).getProperties();
        resetPlayerButtons();
        playerFourTradeButton.setDisable(true);
        handleGridFrame(propertyList);
    }

    public void resetPlayerButtons() {
        playerOneTradeButton.setDisable(false);
        playerTwoTradeButton.setDisable(false);
        playerThreeTradeButton.setDisable(false);
        playerFourTradeButton.setDisable(false);
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

    public void handleMediterraneanAvenueButton() {
        Property property = spaces[1];
        editPropertyOwner(property);
        buttonList.get(0).setDisable(true);
    }
    public void handleBalticAvenueButton() {
        Property property = spaces[3];
        editPropertyOwner(property);
        buttonList.get(1).setDisable(true);
    }
    public void handleOrientalAvenueButton() {
        Property property = spaces[6];
        editPropertyOwner(property);
        buttonList.get(2).setDisable(true);
    }
    public void handleVermontAvenueButton() {
        Property property = spaces[8];
        editPropertyOwner(property);
        buttonList.get(3).setDisable(true);
    }
    public void handleConnecticutAvenueButton() {
        Property property = spaces[9];
        editPropertyOwner(property);
        buttonList.get(4).setDisable(true);
    }
    public void handleStCharlesPlaceButton() {
        Property property = spaces[11];
        editPropertyOwner(property);
        buttonList.get(5).setDisable(true);
    }
    public void handleStatesAvenueButton() {
        Property property = spaces[13];
        editPropertyOwner(property);
        buttonList.get(6).setDisable(true);
    }
    public void handleVirginiaAvenueButton() {
        Property property = spaces[14];
        editPropertyOwner(property);
        buttonList.get(7).setDisable(true);
    }
    public void handleStJamesPlaceButton() {
        Property property = spaces[16];
        editPropertyOwner(property);
        buttonList.get(8).setDisable(true);
    }
    public void handleTennesseeAvenueButton() {
        Property property = spaces[18];
        editPropertyOwner(property);
        buttonList.get(9).setDisable(true);
    }
    public void handleNewYorkAvenueButton() {
        Property property = spaces[19];
        editPropertyOwner(property);
        buttonList.get(10).setDisable(true);
    }
    public void handleKentuckyAvenueButton() {
        Property property = spaces[21];
        editPropertyOwner(property);
        buttonList.get(11).setDisable(true);
    }
    public void handleIndianaAvenueButton() {
        Property property = spaces[23];
        editPropertyOwner(property);
        buttonList.get(12).setDisable(true);
    }
    public void handleIllinoisAvenueButton() {
        Property property = spaces[24];
        editPropertyOwner(property);
        buttonList.get(13).setDisable(true);
    }
    public void handleAtlanticAvenueButton() {
        Property property = spaces[26];
        editPropertyOwner(property);
        buttonList.get(14).setDisable(true);
    }
    public void hadleVentnorAvenueButton() {
        Property property = spaces[27];
        editPropertyOwner(property);
        buttonList.get(15).setDisable(true);
    }
    public void handleMarvinGardensButton() {
        Property property = spaces[29];
        editPropertyOwner(property);
        buttonList.get(16).setDisable(true);
    }
    public void handlePacificAvenueButton() {
        Property property = spaces[31];
        editPropertyOwner(property);
        buttonList.get(17).setDisable(true);
    }
    public void handleNorthCarolinaAvenueButton() {
        Property property = spaces[32];
        editPropertyOwner(property);
        buttonList.get(18).setDisable(true);
    }
    public void handlePennsylvaniaAvenueButton() {
        Property property = spaces[34];
        editPropertyOwner(property);
        buttonList.get(19).setDisable(true);
    }
    public void handleParkPlaceButton() {
        Property property = spaces[37];
        editPropertyOwner(property);
        buttonList.get(20).setDisable(true);
    }
    public void handleBoardwalkButton() {
        Property property = spaces[39];
        editPropertyOwner(property);
        buttonList.get(21).setDisable(true);
    }
    public void handleReadingRailroadButton() {
        Property property = spaces[5];
        editPropertyOwner(property);
        buttonList.get(22).setDisable(true);
    }
    public void handlePennsylvaniaRailroadButton() {
        Property property = spaces[15];
        editPropertyOwner(property);
        buttonList.get(23).setDisable(true);
    }
    public void handleBandORailroadButton() {
        Property property = spaces[25];
        editPropertyOwner(property);
        buttonList.get(24).setDisable(true);
    }
    public void handleShortLineButton() {
        Property property = spaces[35];
        editPropertyOwner(property);
        buttonList.get(25).setDisable(true);
    }
    public void handleWaterWorksButton() {
        Property property = spaces[28];
        editPropertyOwner(property);
        buttonList.get(26).setDisable(true);
    }
    public void handleElectricCompanyButton() {
        Property property = spaces[12];
        editPropertyOwner(property);
        buttonList.get(27).setDisable(true);
    }

    public void editPropertyOwner(Property property) {
        if (playerOneTradeButton.isDisabled()) {
            players.get(0).addProperty(property);
        } else if (playerTwoTradeButton.isDisabled()) {
            players.get(1).addProperty(property);
        } else if (playerThreeTradeButton.isDisabled()) {
            players.get(2).addProperty(property);
        } else if (playerFourTradeButton.isDisabled()) {
            players.get(3).addProperty(property);
        }
        players.get(activePlayer).removeProperty(property);
    }

    @FXML
    Button backButton;
    public void handleBackButton() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main-board.fxml")));
        Stage window = (Stage) backButton.getScene().getWindow();
        window.setScene(new Scene(root, 1280, 720));
        resetButtons();
        startPane.setVisible(true);
    }

    public void resetButtons() {
        for (Button button : buttonList) {
            button.setDisable(true);
        }
    }
}