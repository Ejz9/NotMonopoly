package com.not.monopoly;

import com.not.monopoly.Objects.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

import static com.not.monopoly.PlayerCreationController.playerCount;

public class Main extends Application {

	protected static ArrayList<Integer> playerPositions;
	protected static int activePlayer = 0;
	protected static int die1;
	protected static int die2;
	protected static int doubleRolls;
	protected static ArrayList<Player> players = new ArrayList<>();
	protected static Property[] spaces;
	protected static int doubleRoll = 0;
	private static final String PROPERTY_VALUES = "src/main/resources/data/PropertyValues";
	private static final String COORDINATES = "src/main/resources/data/coordinates_xy";

	@Override
	public void start(Stage primaryStage) throws IOException {
		Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("menu-screen.fxml")));
		primaryStage.setTitle("Monopoly Game");
		primaryStage.setScene(new Scene(root, 1280, 720));
		primaryStage.show();

		// Creates space data from file
		try {
			spaces = HandleSpaces.createSpaces();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		/*do {
			if (players.get(activePlayer).isInJail()) {
				GameController.rollButton.setOpacity(1);
				GameController.rollButton.setDisable(false);
				GameController.bailButton.setVisible(true);
				GameController.bailButton.setDisable(false);
				GameController.getOutOfJailFree.setVisible(true);
				GameController.getOutOfJailFree.setDisable(false);
				players.get(activePlayer).setPosition(players.get(activePlayer).getPosition() + die1 + die2);
				GameController.updatePiece();
			} else {

			}
		} while (isAllOwned() == -1);*/

	}

	protected int isAllOwned(){
		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).getProperties().size() == 28){
				return i;
			}
		}
		return -1;
	}

	// TODO - make player property squares empty with black outline

	//OLD (maybe useful) Code
    /*public static void onClickPlay(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main-board.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setScene(scene);
        stage.show();
    }*/
	protected static void goToJail() {
		playerPositions.set(activePlayer, 10);
		players.get(activePlayer).setInJail(true);
	}

	protected static boolean isOnProperty(Player player) {
		return spaces[playerPositions.get(activePlayer)].getClass().getSimpleName().equals("Property") ||
				spaces[playerPositions.get(activePlayer)].getClass().getSimpleName().equals("Railroad") ||
				spaces[playerPositions.get(activePlayer)].getClass().getSimpleName().equals("Utilities");
	}

	public static void main(String[] args) {
		launch();
	}
}