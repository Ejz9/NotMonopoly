package com.not.monopoly;

import com.not.monopoly.Objects.Player;
import com.not.monopoly.Objects.Property;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

import static com.not.monopoly.Main.*;
import static com.not.monopoly.PlayerCreationController.playerCount;
import static com.not.monopoly.SetupGameBoard.createSpaces;

@SuppressWarnings("unused")
public class GameController {

	@FXML
	public Label Label1;
	@FXML
	public Label Label3;
	@FXML
	public Label Label4;
	@FXML
	public Label Label5;
	@FXML
	public Label Label6;
	@FXML
	public Label Label8;
	@FXML
	public Label Label9;
	@FXML
	public Label Label11;
	@FXML
	public Label Label12;
	@FXML
	public Label Label13;
	@FXML
	public Label Label14;
	@FXML
	public Label Label15;
	@FXML
	public Label Label16;
	@FXML
	public Label Label18;
	@FXML
	public Label Label19;
	@FXML
	public Label Label21;
	@FXML
	public Label Label23;
	@FXML
	public Label Label24;
	@FXML
	public Label Label25;
	@FXML
	public Label Label26;
	@FXML
	public Label Label27;
	@FXML
	public Label Label28;
	@FXML
	public Label Label29;
	@FXML
	public Label Label31;
	@FXML
	public Label Label32;
	@FXML
	public Label Label34;
	@FXML
	public Label Label35;
	@FXML
	public Label Label37;
	@FXML
	public Label Label38;
	@FXML
	public Label Label39;
	@FXML
	GridPane gridPane;
	@FXML
	ImageView rollButton;
	@FXML
	ImageView buyButton;
	@FXML
	ImageView auctionButton;
	@FXML
	ImageView tradeButton;
	@FXML
	ImageView endTurnButton;
	@FXML
	ImageView managePropertyButton;
	@FXML
	ImageView bailButton;
	@FXML
	ImageView getOutOfJailFree;
	@FXML
	ImageView player1Piece;
	@FXML
	ImageView player2Piece;
	@FXML
	ImageView player3Piece;
	@FXML
	ImageView player4Piece;
	@FXML
	Pane startPane;
	@FXML
	Button start;
	@FXML
	Label playerOneLabel;
	@FXML
	Label playerOneBalanceLabel;
	@FXML
	ImageView playerOneCard;
	@FXML
	Label playerTwoLabel;
	@FXML
	Label playerTwoBalanceLabel;
	@FXML
	ImageView playerTwoCard;
	@FXML
	Label playerThreeLabel;
	@FXML
	Label playerThreeBalanceLabel;
	@FXML
	ImageView playerThreeCard;
	@FXML
	Label playerFourLabel;
	@FXML
	Label playerFourBalanceLabel;
	@FXML
	ImageView playerFourCard;
	@FXML
	Group playerDataOneGroup;
	@FXML
	Group playerDataTwoGroup;
	@FXML
	Group playerDataThreeGroup;
	@FXML
	Group playerDataFourGroup;
	@FXML
	TextArea actionFeed;
	@FXML
	TextArea actionLog;
	Property[] spaces = createSpaces();
	Random random = new Random();
	int doubleRoll;
	public GameController() throws IOException {
	}

	public void initPropertyLabels() {
		Label1.setText(String.format("$ %d", spaces[1].getPrice()));
		Label3.setText(String.format("$ %d", spaces[3].getPrice()));
		Label4.setText(String.format("$ %d", spaces[4].getActiveRent()));
		Label5.setText(String.format("$ %d", spaces[5].getPrice()));
		Label6.setText(String.format("$ %d", spaces[6].getPrice()));
		Label8.setText(String.format("$ %d", spaces[8].getPrice()));
		Label9.setText(String.format("$ %d", spaces[9].getPrice()));
		Label11.setText(String.format("$ %d", spaces[11].getPrice()));
		Label12.setText(String.format("$ %d", spaces[12].getPrice()));
		Label13.setText(String.format("$ %d", spaces[13].getPrice()));
		Label14.setText(String.format("$ %d", spaces[14].getPrice()));
		Label15.setText(String.format("$ %d", spaces[15].getPrice()));
		Label16.setText(String.format("$ %d", spaces[16].getPrice()));
		Label18.setText(String.format("$ %d", spaces[18].getPrice()));
		Label19.setText(String.format("$ %d", spaces[19].getPrice()));
		Label21.setText(String.format("$ %d", spaces[21].getPrice()));
		Label23.setText(String.format("$ %d", spaces[23].getPrice()));
		Label24.setText(String.format("$ %d", spaces[24].getPrice()));
		Label25.setText(String.format("$ %d", spaces[25].getPrice()));
		Label26.setText(String.format("$ %d", spaces[26].getPrice()));
		Label27.setText(String.format("$ %d", spaces[27].getPrice()));
		Label28.setText(String.format("$ %d", spaces[28].getPrice()));
		Label29.setText(String.format("$ %d", spaces[29].getPrice()));
		Label31.setText(String.format("$ %d", spaces[31].getPrice()));
		Label32.setText(String.format("$ %d", spaces[32].getPrice()));
		Label34.setText(String.format("$ %d", spaces[34].getPrice()));
		Label35.setText(String.format("$ %d", spaces[35].getPrice()));
		Label37.setText(String.format("$ %d", spaces[37].getPrice()));
		Label38.setText(String.format("$ %d", spaces[38].getActiveRent()));
		Label39.setText(String.format("$ %d", spaces[39].getPrice()));
	}

	public void initGameboard() {
		runSetup();
		initPropertyLabels();
		initPieceCoords();
		pieces.put(0, player1Piece);
		pieces.put(1, player2Piece);
		pieces.put(2, player3Piece);
		pieces.put(3, player4Piece);
		buyButton.setOpacity(.3);
		buyButton.setDisable(true);
		auctionButton.setOpacity(.3);
		auctionButton.setDisable(true);
		tradeButton.setOpacity(.3);
		tradeButton.setDisable(true);
		endTurnButton.setOpacity(.3);
		endTurnButton.setDisable(true);
		managePropertyButton.setOpacity(.3);
		managePropertyButton.setDisable(true);
		bailButton.setVisible(false);
		bailButton.setDisable(true);
		getOutOfJailFree.setVisible(false);
		getOutOfJailFree.setDisable(true);

	}


	protected void handleLandingOnProperty(){

	}

	protected void payRent(){
		players.get(activePlayer).setBalance(players.get(activePlayer).getBalance() - spaces[players.get(activePlayer).getPosition()].getActiveRent());
	}

	protected void updatePlayerPosition() {
		players.get(activePlayer).setPosition(players.get(activePlayer).getPosition() + die1 + die2);
		System.out.println(spaces[players.get(activePlayer).getPosition()].getName());
		GridPane.setColumnIndex(pieces.get(activePlayer), xCoords.get(players.get(activePlayer).getPosition()));
		GridPane.setRowIndex(pieces.get(activePlayer), yCoords.get(players.get(activePlayer).getPosition()));
	}

	public void updateActionFeed() {
		actionFeed.setText(players.get(activePlayer).getName() + " Roll The Dice!");
	}

	public void updateActionLog(String action) {
		switch (action) {
			case "roll" -> {

			}
			case "auction" -> {

			}
			//Append more | Change to If if does not parse string compare.
			case "endTurn" -> {

			}
		}
		actionLog.setText(players.get(activePlayer).getName() + "Rolled");
	}



	public void setBuyPhase() {

	}

	public void setJailPhase() {

	}

	public void setPostRollAction() {

	}

	public void handleEndTurn() {

	}

	public void runSetup() {
		startPane.setVisible(false);
		startPane.setDisable(true);
		System.out.println(playerCount);
		System.out.println(players.size());
		Debug.printPlayersDebug(players);
		//Prepares and Establishes the Player Cards
		setupPlayerCards(playerOneLabel, playerOneBalanceLabel, playerOneCard, 0);
		setupPlayerCards(playerTwoLabel, playerTwoBalanceLabel, playerTwoCard, 1);
		if (players.size() == 3) {
			setupPlayerCards(playerThreeLabel, playerThreeBalanceLabel, playerThreeCard, 2);
			playerDataThreeGroup.setVisible(true);
		}
		if (players.size() == 4) {
			setupPlayerCards(playerFourLabel, playerFourBalanceLabel, playerFourCard, 3);
			playerDataFourGroup.setVisible(true);        }
	}

	protected void setupPlayerCards(Label playerNameLabel, Label playerBalanceLabel, ImageView playerCard, int i) {
			playerNameLabel.setText(players.get(i).getName());
			playerBalanceLabel.setText(players.get(i).getBalanceAsString());
			playerCard.setVisible(true);
	}

	HashMap<Integer, ImageView> pieces = new HashMap<>();
	HashMap<Integer, Integer> xCoords = new HashMap<>(40);
	HashMap<Integer, Integer> yCoords = new HashMap<>(40);

	// Changes the die values to random between 1 and 6
	// TODO - Correct behavior of landing on property without purchase or auction being available
	public void handleRollButton() {
		die1 = random.nextInt(1, 6);
		die2 = random.nextInt(1, 6);
		rollButton.setDisable(true);
		rollButton.setOpacity(.3);
		handleRoll();
	}

	public void handleRoll() {
		// TODO - Finish fleshing out all use cases
		if (die1 != die2 && isOnProperty(players.get(activePlayer))) {
			updatePlayerPosition();
			if (spaces[players.get(activePlayer).getPosition()].getOwnedBy() == null) {
				buyButton.setOpacity(1);
				buyButton.setDisable(false);
				auctionButton.setOpacity(1);
				auctionButton.setDisable(false);
			} else {
				payRent();
				endTurnButton.setDisable(false);
				endTurnButton.setOpacity(1);
			}
		} else if (die1 != die2 && !isOnProperty(players.get(activePlayer))){
			updatePlayerPosition();
			endTurnButton.setDisable(false);
			endTurnButton.setOpacity(1);
		} else if (die1 == die2 && isOnProperty(players.get(activePlayer))) {
			updatePlayerPosition();
			rollButton.setOpacity(1);
			rollButton.setDisable(false);
		} else if (die1 == die2 && !isOnProperty(players.get(activePlayer))) {
			updatePlayerPosition();
			rollButton.setOpacity(1);
			rollButton.setDisable(false);
		} else if (players.get(activePlayer).getPosition() == 30) {
			updatePlayerPosition();
			goToJail();
		} else if (players.get(activePlayer).isInJail() && die1 == die2) {
			updatePlayerPosition();
		}


	}

	public void handleBuyButton() {
		players.get(activePlayer).addProperty(spaces[players.get(activePlayer).getPosition()]);
		players.get(activePlayer).setBalance(players.get(activePlayer).getBalance() - spaces[players.get(activePlayer).getPosition()].getPrice());
		buyButton.setDisable(true);
		auctionButton.setDisable(true);
		buyButton.setOpacity(.3);
		auctionButton.setOpacity(.3);
		if (die1 == die2){
			rollButton.setDisable(false);
			rollButton.setOpacity(1);
		} else {
			endTurnButton.setDisable(false);
			endTurnButton.setOpacity(1);
		}
	}

	public void handleBailButton() {
		bailButton.setVisible(false);
		bailButton.setDisable(true);
		getOutOfJailFree.setVisible(false);
		getOutOfJailFree.setDisable(true);
		players.get(activePlayer).setInJail(false);
	}

	public void handleGetOutOfJailButton() {
		bailButton.setVisible(false);
		bailButton.setDisable(true);
		getOutOfJailFree.setVisible(false);
		getOutOfJailFree.setDisable(true);
		players.get(activePlayer).setInJail(false);
		players.get(activePlayer).setJailCards(players.get(activePlayer).getJailCards() - 1);
	}

	public void handleAuctionButton() {
		// TODO - make auction scene to launch auction
		buyButton.setDisable(true);
		auctionButton.setDisable(true);
		buyButton.setOpacity(.3);
		auctionButton.setOpacity(.3);
		if (die1 == die2){
			rollButton.setDisable(false);
			rollButton.setOpacity(1);
		} else {
			endTurnButton.setDisable(false);
			endTurnButton.setOpacity(1);
		}
	}

	public void handleTradeButton() {

	}

	public void handleEndTurnButton() {
		endTurnButton.setDisable(true);
		endTurnButton.setOpacity(.3);
		rollButton.setDisable(false);
		rollButton.setOpacity(1);
		activePlayer++;
		if (activePlayer >= players.size()) {
			activePlayer = 0;
		}
		if (isOnProperty(players.get(activePlayer)) && spaces[players.get(activePlayer).getPosition()].getOwnedBy() != null) {
			buyButton.setDisable(false);
			auctionButton.setDisable(false);
			buyButton.setOpacity(1);
			auctionButton.setOpacity(1);
		}
	}

	public void handlePropertyButton() {

	}



	protected void initPieceCoords() {
		xCoords.put(0, 10);
		xCoords.put(1, 9);
		xCoords.put(2, 8);
		xCoords.put(3, 7);
		xCoords.put(4, 6);
		xCoords.put(5, 5);
		xCoords.put(6, 4);
		xCoords.put(7, 3);
		xCoords.put(8, 2);
		xCoords.put(9, 1);
		xCoords.put(10, 0);
		xCoords.put(11, 0);
		xCoords.put(12, 0);
		xCoords.put(13, 0);
		xCoords.put(14, 0);
		xCoords.put(15, 0);
		xCoords.put(16, 0);
		xCoords.put(17, 0);
		xCoords.put(18, 0);
		xCoords.put(19, 0);
		xCoords.put(20, 0);
		xCoords.put(21, 1);
		xCoords.put(22, 2);
		xCoords.put(23, 3);
		xCoords.put(24, 4);
		xCoords.put(25, 5);
		xCoords.put(26, 6);
		xCoords.put(27, 7);
		xCoords.put(28, 8);
		xCoords.put(29, 9);
		xCoords.put(30, 10);
		xCoords.put(31, 10);
		xCoords.put(32, 10);
		xCoords.put(33, 10);
		xCoords.put(34, 10);
		xCoords.put(35, 10);
		xCoords.put(36, 10);
		xCoords.put(37, 10);
		xCoords.put(38, 10);
		xCoords.put(39, 10);
		yCoords.put(0, 10);
		yCoords.put(1, 10);
		yCoords.put(2, 10);
		yCoords.put(3, 10);
		yCoords.put(4, 10);
		yCoords.put(5, 10);
		yCoords.put(6, 10);
		yCoords.put(7, 10);
		yCoords.put(8, 10);
		yCoords.put(9, 10);
		yCoords.put(10, 10);
		yCoords.put(11, 9);
		yCoords.put(12, 8);
		yCoords.put(13, 7);
		yCoords.put(14, 6);
		yCoords.put(15, 5);
		yCoords.put(16, 4);
		yCoords.put(17, 3);
		yCoords.put(18, 2);
		yCoords.put(19, 1);
		yCoords.put(20, 0);
		yCoords.put(21, 0);
		yCoords.put(22, 0);
		yCoords.put(23, 0);
		yCoords.put(24, 0);
		yCoords.put(25, 0);
		yCoords.put(26, 0);
		yCoords.put(27, 0);
		yCoords.put(28, 0);
		yCoords.put(29, 0);
		yCoords.put(30, 0);
		yCoords.put(31, 1);
		yCoords.put(32, 2);
		yCoords.put(33, 3);
		yCoords.put(34, 4);
		yCoords.put(35, 5);
		yCoords.put(36, 6);
		yCoords.put(37, 7);
		yCoords.put(38, 8);
		yCoords.put(39, 9);
	}

	public void setupRoll() {

	}

	protected boolean isOnProperty(Player player) {
		return spaces[players.get(activePlayer).getPosition()].getClass().getSimpleName().equals("Property") ||
				spaces[players.get(activePlayer).getPosition()].getClass().getSimpleName().equals("Railroad") ||
				spaces[players.get(activePlayer).getPosition()].getClass().getSimpleName().equals("Utilities");
	}
	protected void goToJail() {
		players.get(activePlayer).setPosition(10);
		players.get(activePlayer).setInJail(true);
	}


}
