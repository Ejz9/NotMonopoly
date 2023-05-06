package com.not.monopoly;

import com.not.monopoly.DONOTSUBMIT.Debug;
import com.not.monopoly.Objects.Player;
import com.not.monopoly.Objects.Property;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;
import java.util.Random;

import static com.not.monopoly.Main.*;
import static com.not.monopoly.PlayerCreationController.playerCount;
import static com.not.monopoly.PropertyCreation.createSpaces;

@SuppressWarnings("unused")
public class GameController {

	int die1;
	int die2;

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
	@FXML ImageView diceOne1;
	@FXML ImageView diceTwo1;
	@FXML ImageView diceOne2;
	@FXML ImageView diceTwo2;
	@FXML ImageView diceOne3;
	@FXML ImageView diceTwo3;
	@FXML ImageView diceOne4;
	@FXML ImageView diceTwo4;
	@FXML ImageView diceOne5;
	@FXML ImageView diceTwo5;
	@FXML ImageView diceOne6;
	@FXML ImageView diceTwo6;
	Property[] spaces = createSpaces();
	Random random = new Random();
	int doubleRoll;
	public GameController() throws IOException {
	}

	public void initPropertyLabels() {
		updatePassthrough(Label1, 1);
		updatePassthrough(Label3, 3);
		updatePassthrough(Label4, 4);
		updatePassthrough(Label5, 5);
		updatePassthrough(Label6, 6);
		updatePassthrough(Label8, 8);
		updatePassthrough(Label9, 9);
		updatePassthrough(Label11, 11);
		updatePassthrough(Label12, 12);
		updatePassthrough(Label13, 13);
		updatePassthrough(Label14, 14);
		updatePassthrough(Label15, 15);
		updatePassthrough(Label16, 16);
		updatePassthrough(Label18, 18);
		updatePassthrough(Label19, 19);
		updatePassthrough(Label21, 21);
		updatePassthrough(Label23, 23);
		updatePassthrough(Label24, 24);
		updatePassthrough(Label25, 25);
		updatePassthrough(Label26, 26);
		updatePassthrough(Label27, 27);
		updatePassthrough(Label28, 28);
		updatePassthrough(Label29, 29);
		updatePassthrough(Label31, 31);
		updatePassthrough(Label32, 32);
		updatePassthrough(Label34, 34);
		updatePassthrough(Label35, 35);
		updatePassthrough(Label37, 37);
		updatePassthrough(Label38, 38);
		updatePassthrough(Label39, 39);
	}

	public void updatePassthrough(Label label, int index){
		if ((spaces[index].getOwnedBy() == null && !spaces[index].getName().equalsIgnoreCase("luxury tax"))) {
			label.setText(String.format("$ %d", spaces[index].getPrice()));
		} else if ((spaces[index].getOwnedBy() == null && !spaces[index].getName().equalsIgnoreCase("income tax"))){
			if (players.get(activePlayer).getTaxCards() == 2) {
				spaces[index].setActiveRent((die1 + die2) * 10);
			} else {
				spaces[index].setActiveRent((die1 + die2) * 2);
			}
			label.setText(String.format("$ %d", spaces[index].getActiveRent()));
		} else {
			label.setText(String.format("$ %d", spaces[index].getActiveRent()));
		}
	}

	public void initGameBoard() {
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
		players.get(activePlayer).setPosition(players.get(activePlayer).getPosition() + (die1 + die2));
		System.out.println(spaces[players.get(activePlayer).getPosition()].getName() + " " + die1 + " " + die2);
		GridPane.setColumnIndex(pieces.get(activePlayer), xCoords.get(players.get(activePlayer).getPosition()));
		GridPane.setRowIndex(pieces.get(activePlayer), yCoords.get(players.get(activePlayer).getPosition()));
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
		tradeButton.setOpacity(1);
		tradeButton.setDisable(false);
		updateDice();
		handleRoll();
	}

	private void updateDice() {
		resetDice();
		diceVisible(die1, diceOne1, diceOne2, diceOne3, diceOne4, diceOne5, diceOne6);
		diceVisible(die2, diceTwo1, diceTwo2, diceTwo3, diceTwo4, diceTwo5, diceTwo6);
	}

	private void diceVisible(int die2, ImageView diceTwo1, ImageView diceTwo2, ImageView diceTwo3, ImageView diceTwo4, ImageView diceTwo5, ImageView diceTwo6) {
		switch (die2) {
			case 1 -> diceTwo1.setVisible(true);
			case 2 -> diceTwo2.setVisible(true);
			case 3 -> diceTwo3.setVisible(true);
			case 4 -> diceTwo4.setVisible(true);
			case 5 -> diceTwo5.setVisible(true);
			case 6 -> diceTwo6.setVisible(true);
		}
	}

	private void resetDice() {
		diceOne1.setVisible(false);
		diceTwo1.setVisible(false);
		diceOne2.setVisible(false);
		diceTwo2.setVisible(false);
		diceOne3.setVisible(false);
		diceTwo3.setVisible(false);
		diceOne4.setVisible(false);
		diceTwo4.setVisible(false);
		diceOne5.setVisible(false);
		diceTwo5.setVisible(false);
		diceOne6.setVisible(false);
		diceTwo6.setVisible(false);
	}

	public void handleRoll() {
		// TODO - Finish fleshing out all use cases
		initPropertyLabels();
		if (doubleRoll != 3){
			updatePlayerPosition();
			if (die1 != die2 && isOnProperty(players.get(activePlayer))) {
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
			} else if (die1 == die2 && !isOnProperty(players.get(activePlayer))) {
				updatePlayerPosition();
				rollButton.setOpacity(1);
				rollButton.setDisable(false);
			} else if (players.get(activePlayer).isInJail() && die1 == die2) {
				updatePlayerPosition();
				players.get(activePlayer).setInJail(false);
				doubleRoll = 0;
			}
		} else {
			goToJail();
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

	public void handleTradeButton() throws IOException {
		Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("trade-screen.fxml")));
		Stage window = (Stage) tradeButton.getScene().getWindow();
		window.setScene(new Scene(root, 1280, 720));
	}

	public void handleEndTurnButton() {
		endTurnButton.setDisable(true);
		endTurnButton.setOpacity(.3);
		rollButton.setDisable(false);
		rollButton.setOpacity(1);
		tradeButton.setDisable(false);
		tradeButton.setOpacity(1);
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

	protected boolean isOnProperty(Player player) {
		return player.getPosition() != 0 && player.getPosition() != 2 && player.getPosition() != 4 && player.getPosition() != 7 && player.getPosition() != 10 &&
				player.getPosition() != 17 && player.getPosition() != 20 && player.getPosition() != 22 && player.getPosition() != 28 && player.getPosition() != 30 &&
				player.getPosition() != 33 && player.getPosition() != 36 && player.getPosition() != 38;
	}
	protected void goToJail() {
		players.get(activePlayer).setPosition(10);
		players.get(activePlayer).setInJail(true);
		doubleRoll = 0;
	}
}