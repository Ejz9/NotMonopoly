package com.not.monopoly;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import com.not.monopoly.Objects.*;
import com.not.monopoly.Main.*;

import static com.not.monopoly.Main.activePlayer;

public class GameController {

	private Player[] players;

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
		if (!players[activePlayer].isInJail()){

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
