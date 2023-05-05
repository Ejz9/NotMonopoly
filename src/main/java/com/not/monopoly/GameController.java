package com.not.monopoly;

import com.not.monopoly.Objects.Player;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Random;

import static com.not.monopoly.Main.*;

@SuppressWarnings("unused")
public class GameController {

	@FXML
	public static GridPane gridPane;

	@FXML
	static ImageView rollButton;

	@FXML
	static ImageView buyButton;

	@FXML
	static ImageView auctionButton;

	@FXML
	static ImageView tradeButton;

	@FXML
	static ImageView endTurnButton;

	@FXML
	static ImageView managePropertyButton;

	@FXML
	static ImageView bailButton;

	@FXML
	static ImageView getOutOfJailFree;

	@FXML
	static ImageView player1Piece;

	@FXML
	static ImageView player2Piece;

	@FXML
	static ImageView player3Piece;

	@FXML
	static ImageView player4Piece;

	static HashMap<Integer, ImageView> pieces = new HashMap<>();
	static HashMap<Integer, Integer> xCoords = new HashMap<>(40);
	static HashMap<Integer, Integer> yCoords = new HashMap<>(40);

	// Changes the die values to random between 1 and 6
	public void handleRollButton() {
		Random random = new Random();
		die1 = random.nextInt(1, 6);
		die2 = random.nextInt(1, 6);
		rollButton.setDisable(true);
		rollButton.setOpacity(.3);
		bailButton.setVisible(false);
		bailButton.setDisable(true);
		getOutOfJailFree.setVisible(false);
		getOutOfJailFree.setDisable(true);
	}

	public void handleBuyButton() {
		players.get(activePlayer).addProperty(spaces[playerPositions.get(activePlayer)]);
		players.get(activePlayer).setBalance(players.get(activePlayer).getBalance() - spaces[playerPositions.get(activePlayer)].getPrice());
		buyButton.setDisable(true);
		auctionButton.setDisable(true);
		buyButton.setOpacity(.3);
		auctionButton.setOpacity(.3);
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
		if (isOnProperty(players.get(activePlayer)) && spaces[playerPositions.get(activePlayer)].getOwnedBy() != null) {
			buyButton.setDisable(false);
			auctionButton.setDisable(false);
			buyButton.setOpacity(1);
			auctionButton.setOpacity(1);
		}
	}

	public void handlePropertyButton() {

	}

	protected static void updatePiece() {
		initPieceCoords();
		pieces.put(0, player1Piece);
		pieces.put(1, player2Piece);
		pieces.put(2, player3Piece);
		pieces.put(3, player4Piece);
		GridPane.setColumnIndex(pieces.get(activePlayer), xCoords.get(playerPositions.get(activePlayer)));
		GridPane.setRowIndex(pieces.get(activePlayer), yCoords.get(playerPositions.get(activePlayer)));
	}

	private static void initPieceCoords() {
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

}
