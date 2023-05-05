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

import static com.not.monopoly.PlayerCreationController.playerCount;

public class Main extends Application {

	protected static ArrayList<Integer> playerPositions;
	protected static int activePlayer = 0;
	protected static int die1;
	protected static int die2;
	protected static int doubleRolls;
	protected static ArrayList<Player> players;
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
		GameController gameController = new GameController();

		// Creates space data from file
		try {
			spaces = createSpaces();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		// Set up player count and data
		players = new ArrayList<>(playerCount);
		getPlayerNames(playerCount, players);


		do {
			if (players.get(activePlayer).isInJail()) {
				roll
			} else {

			}

		} while (isAllOwned() == -1);


	}

	protected int isAllOwned(){
		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).getProperties().size() == 28){
				return i;
			}
		}
		return -1;
	}

	private void getPlayerNames(int playerCount, ArrayList<Player> players) {
	}

	// TODO - make player property squares empty with black outline

	//OLD (maybe useful) Code
    /*public static void onClickPlay(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main-board.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setScene(scene);
        stage.show();
    }*/

	private Property[] createSpaces() throws IOException {
		Property[] spaces = new Property[40];
		FileManager propertyValues = new FileManager(new File(PROPERTY_VALUES));
		List<String> propertyData = propertyValues.readData();
		FileManager coordinates = new FileManager(new File(COORDINATES));
		List<Integer> coordinatesData = coordinates.readNumData();
		Color color;
		int index = 0;
		int coordinateIndex = 0;
		for (int i = 0; i < spaces.length; i++) {
			switch (i) {
				default -> {
					if (i < 4) {
						color = Color.MAROON;
					} else if (i < 10) {
						color = Color.LIGHTBLUE;
					} else if (i < 15) {
						color = Color.DEEPPINK;
					} else if (i < 20) {
						color = Color.ORANGE;
					} else if (i < 25) {
						color = Color.RED;
					} else if (i < 30) {
						color = Color.YELLOW;
					} else if (i < 35) {
						color = Color.GREEN;
					} else {
						color = Color.BLUE;
					}
					spaces[i] = new Property(propertyData.get(index), Integer.parseInt(propertyData.get(index + 1)), Integer.parseInt(propertyData.get(index + 2)),
							Integer.parseInt(propertyData.get(index + 3)), color, Integer.parseInt(propertyData.get(index + 4)), Integer.parseInt(propertyData.get(index + 5)),
							Integer.parseInt(propertyData.get(index + 6)), Integer.parseInt(propertyData.get(index + 7)), Integer.parseInt(propertyData.get(index + 8)),
							Integer.parseInt(propertyData.get(index + 9)), coordinatesData.get(coordinateIndex), coordinatesData.get(coordinateIndex + 1));
					index += 10;
					coordinateIndex += 2;
				}
				case 0 -> {
					spaces[i] = new Corner("Go");
					spaces[i].setCoordinates(coordinatesData.get(coordinateIndex), coordinatesData.get(coordinateIndex + 1));
					coordinateIndex += 2;
				}
				case 2, 17, 33 -> {
					spaces[i] = new CardSpace("Community Chest", CardType.CHEST);
					spaces[i].setCoordinates(coordinatesData.get(coordinateIndex), coordinatesData.get(coordinateIndex + 1));
					coordinateIndex += 2;
				}
				case 4 -> {
					spaces[i] = new Tax("Income Tax", 200);
					spaces[i].setCoordinates(coordinatesData.get(coordinateIndex), coordinatesData.get(coordinateIndex + 1));
					coordinateIndex += 2;
				}
				case 5 -> {
					spaces[i] = new Railroad("Reading Railroad", 200, 25, Direction.SOUTH);
					spaces[i].setCoordinates(coordinatesData.get(coordinateIndex), coordinatesData.get(coordinateIndex + 1));
					coordinateIndex += 2;
				}
				case 7, 36, 22 -> {
					spaces[i] = new CardSpace("Chance", CardType.CHANCE);
					spaces[i].setCoordinates(coordinatesData.get(coordinateIndex), coordinatesData.get(coordinateIndex + 1));
					coordinateIndex += 2;
				}
				case 10 -> {
					spaces[i] = new Corner("Jail");
					spaces[i].setCoordinates(coordinatesData.get(coordinateIndex), coordinatesData.get(coordinateIndex + 1));
					coordinateIndex += 2;
				}
				case 12 -> {
					spaces[i] = new Utilities("Electric Company", 150, 0, Utility.ELECTRIC);
					spaces[i].setCoordinates(coordinatesData.get(coordinateIndex), coordinatesData.get(coordinateIndex + 1));
					coordinateIndex += 2;
				}
				case 15 -> {
					spaces[i] = new Railroad("Pennsylvania Railroad", 200, 25, Direction.WEST);
					spaces[i].setCoordinates(coordinatesData.get(coordinateIndex), coordinatesData.get(coordinateIndex + 1));
					coordinateIndex += 2;
				}
				case 20 -> {
					spaces[i] = new Corner("Free Parking");
					spaces[i].setCoordinates(coordinatesData.get(coordinateIndex), coordinatesData.get(coordinateIndex + 1));
					coordinateIndex += 2;
				}
				case 25 -> {
					spaces[i] = new Railroad("B & O Railroad", 200, 25, Direction.NORTH);
					spaces[i].setCoordinates(coordinatesData.get(coordinateIndex), coordinatesData.get(coordinateIndex + 1));
					coordinateIndex += 2;
				}
				case 28 -> {
					spaces[i] = new Utilities("Water Works", 28, 150, Utility.WATER);
					spaces[i].setCoordinates(coordinatesData.get(coordinateIndex), coordinatesData.get(coordinateIndex + 1));
					coordinateIndex += 2;
				}
				case 30 -> {
					spaces[i] = new Corner("Go to Jail");
					spaces[i].setCoordinates(coordinatesData.get(coordinateIndex), coordinatesData.get(coordinateIndex + 1));
					coordinateIndex += 2;
				}
				case 35 -> {
					spaces[i] = new Railroad("Short Line", 200, 25, Direction.EAST);
					spaces[i].setCoordinates(coordinatesData.get(coordinateIndex), coordinatesData.get(coordinateIndex + 1));
					coordinateIndex += 2;
				}
				case 38 -> {
					spaces[i] = new Tax("Luxury Tax", 75);
					spaces[i].setCoordinates(coordinatesData.get(coordinateIndex), coordinatesData.get(coordinateIndex + 1));
					coordinateIndex += 2;
				}
			}
			/*int i = 0;
			for (int x = BOARD_SIZE - 1; x > 0; x--) {
				spaces[i].setCoordinates(x, BOARD_SIZE - 1);
				i++;
			}
			for (int y = BOARD_SIZE - 1; y > 0; y--) {
				spaces[i].setCoordinates(0, y);
				i++;
			}
			for (int x = 0; x < BOARD_SIZE; x++) {
				spaces[i].setCoordinates(x, 0);
				i++;
			}
			for (int y = 0; y < BOARD_SIZE; y++) {
				spaces[i].setCoordinates(BOARD_SIZE - 1, y);
				i++;
			}*/
		}
		return spaces;
	}

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