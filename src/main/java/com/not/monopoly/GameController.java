package com.not.monopoly;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import com.not.monopoly.Objects.*;
import com.not.monopoly.Main.*;

import java.util.Random;

import static com.not.monopoly.Main.*;

public class GameController {

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

	public GameController (){

	}

	public void	handleRollButton(){
		Random random = new Random();
		if (!players.get(activePlayer).isInJail()){
			die1 = random.nextInt(1,6);
			die2 = random.nextInt(1,6);

			// Update player's position
			playerPositions[activePlayer] += (die1 + die2);
			if (playerPositions[activePlayer] >= 40) {
				playerPositions[activePlayer] -= 40;
				players.get(activePlayer).setBalance(players.get(activePlayer).getBalance() + 200);
			}
		} else {

		}
	}

	public void handleBuyButton() {

	}

	public void handleAuctionButton() {

	}

	public void handleTradeButton() {

	}

	public void handleEndTurnButton() {

	}

	public void handlePropertyButton() {

	}
}
