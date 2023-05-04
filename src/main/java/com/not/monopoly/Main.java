package com.not.monopoly;

import com.not.monopoly.Objects.Player;
import com.not.monopoly.Objects.Property;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Main extends Application {

	protected static ArrayList<Integer> playerPositions;
	protected static int activePlayer = 0;
	protected static int die1;
	protected static int die2;
	protected static int doubleRolls;
	protected static ArrayList<Player> players;
	protected static Property[] spaces;
	protected static int doubleRoll = 0;

	@Override
	public void start(Stage primaryStage) throws IOException {
		Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("menu-screen.fxml")));
		primaryStage.setTitle("Monopoly Game");
		primaryStage.setScene(new Scene(root, 1280, 720));
		primaryStage.show();


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