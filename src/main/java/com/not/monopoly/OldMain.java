package com.not.monopoly;

import com.not.monopoly.Objects.*;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class OldMain extends Application {

    // Number of rows and columns on the board
    private static final int BOARD_SIZE = 11;
    // Size of each cell on the board
    private static final int CELL_SIZE = 80;
    // Player's current position on the board
    private int[] playerPositions;
    private static int activePlayer = 0;
    private int die1;
    private int die2;
    private int doubleRolls;
    private Property[] spaces;
    private Stage primaryStage = new Stage();

    // Image paths
    private static final String GO_IMAGE_PATH = "file:src/main/resources/images/go.png";
    private static final String JAIL_IMAGE_PATH = "file:src/main/resources/images/jail.png";
    private static final String FREE_PARKING_IMAGE_PATH = "file:src/main/resources/images/free_parking.png";
    private static final String GO_TO_JAIL_IMAGE_PATH = "file:src/main/resources/images/go_to_jail.png";
    private static final String COMMUNITY_CHEST_IMAGE_PATH = "file:src/main/resources/images/community_chest.png";
    private static final String CHANCE_IMAGE_PATH = "file:src/main/resources/images/chance.png";
    private static final String RAILROAD_IMAGE_PATH = "file:src/main/resources/images/railroad.png";
    private static final String WATER_IMAGE_PATH = "file:src/main/resources/images/water_works.png";
    private static final String ELECTRIC_IMAGE_PATH = "file:src/main/resources/images/electric_company.png";
    private static final String INCOME_TAX = "file:src/main/resources/images/luxury_tax.png";
    private static final String LUXURY_TAX = "file:src/main/resources/images/luxury_tax.png";
    private static final String CHANCE_CARDS = "src/main/resources/data/Chance";
    private static final String COMMUNITY_CHEST_CARDS = "src/main/resources/data/CommunityChest";
    private static final String PROPERTY_VALUES = "src/main/resources/data/PropertyValues";
    private static final String COORDINATES = "src/main/resources/data/coordinates_xy";

    @Override
    public void start(Stage primaryStage) {
        // TODO - Add a place where it shows each players' balance and who's turn it is
        // TODO - show dice rolls off to the side
        try {
            spaces = createSpaces();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // Set up player count, positions, and names
        int playerCount = getPlayerCount();
        playerPositions = new int[playerCount];
        for (int i = 0; i < playerCount; i++) {
            playerPositions[i] = 0;
        }
        Player[] players = new Player[playerCount];
        getPlayerNames(playerCount, players);

        // Create the board grid
        GridPane board = createBoard();


        // Create players' position label
        Label[] playerPositions = new Label[playerCount];
        for (int i = 0; i < playerCount; i++) {
            playerPositions[i] = createPositionLabel(players[i]);
        }

        // Set up the layout
        VBox boardLayout = new VBox(10);
        boardLayout.setAlignment(Pos.CENTER);
        boardLayout.getChildren().add(board);
        for (int i = 0; i < playerCount; i++) {
            boardLayout.getChildren().add(playerPositions[i]);
        }

        // Set up the scene
        Scene boardScene = new Scene(boardLayout, BOARD_SIZE * CELL_SIZE + 20, BOARD_SIZE * CELL_SIZE + 100);
        primaryStage.setTitle("Monopoly Board Game");
        primaryStage.setScene(boardScene);
        primaryStage.show();

        // Main gameplay loop
        boolean isAllOwned = false;
        do {
            if (!players[activePlayer].isInJail()) {
                showActionPopup(players, playerPositions);
            } else {
                showJailPopup();
            }

            for (Player player : players) {
                if (player.getProperties().size() == 28) {
                    isAllOwned = true;
                    break;
                }
            }
        } while (!isAllOwned);
        endGame(players);


    }


    private void giveCard(CardType type, List<String> communityChestData, List<String> chanceData) throws IOException {
        // TODO - add to method definition and place method where it needs to be called
		/*
		FileManager communityChestCards = new FileManager(new File(COMMUNITY_CHEST_CARDS));
		List<String> communityChestData = communityChestCards.readData();

		FileManager chanceCards = new FileManager(new File(CHANCE_CARDS));
		List<String> chanceData = chanceCards.readData();
		*/
    }

    public void endGame(Player[] players) {
        // TODO - show popup of who won with how much money

    }

    public void getPlayerNames(int playerCount, Player[] players) {
        for (int i = 1; i <= playerCount; i++) {
            TextInputDialog dialog = new TextInputDialog("Player " + i);
            dialog.setTitle("Player " + i + " Name");
            dialog.setHeaderText("Enter a name for player " + i + ":");
            dialog.setContentText("Name:");

            // Loop until user enters a non-empty name
            while (true) {
                String result = dialog.showAndWait().orElse("Player " + i);
                if (!result.trim().isEmpty()) {
                    // Valid name, add it to list
                    players[i - 1] = new Player(result);
                    break;
                }
            }
        }
    }

    public int getPlayerCount() {
        TextInputDialog dialog = new TextInputDialog("2");
        dialog.setTitle("Player Count");
        dialog.setHeaderText("Enter the number of players (2-4):");
        dialog.setContentText("Number of players:");

        // Loop until user enters a valid number of players
        while (true) {
            String result = dialog.showAndWait().orElse("2");
            try {
                int playerCount = Integer.parseInt(result);
                if (playerCount >= 2 && playerCount <= 4) {
                    // Valid player count, return it
                    return playerCount;
                }
            } catch (NumberFormatException ex) {
                // Invalid input, try again
            }
        }
    }

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

    private boolean isBorder(int x, int y) {
        return x == 0 || x == BOARD_SIZE - 1 || y == 0 || y == BOARD_SIZE - 1;
    }

    private boolean isCorner(int x, int y) {
        return x == 0 && y == 0 || x == 0 && y == BOARD_SIZE - 1 || x == BOARD_SIZE - 1 && y == 0 || x == BOARD_SIZE - 1 && y == BOARD_SIZE - 1;
    }

    private Property getSpaceByCoordinates(int x, int y) {
        for (Property space : spaces) {
            if (space.getX() == x && space.getY() == y) {
                return space;
            }
        }
        return null;
    }

    // Creates the Monopoly board grid
    private GridPane createBoard() {
        GridPane board = new GridPane();
        board.setAlignment(Pos.CENTER);
        board.setGridLinesVisible(false);

        // Create cells for the board
        for (int y = 0; y < BOARD_SIZE; y++) {
            for (int x = 0; x < BOARD_SIZE; x++) {
                // Create cell rectangles
                Rectangle cell;
                TextField value = null;
                VBox cellContents;
                TextArea propertyName;
                if (isBorder(x, y) && !isCorner(x, y)) {
                    cell = new Rectangle(CELL_SIZE, CELL_SIZE);
                    cell.setFill(getSpaceByCoordinates(x, y).getColor());
                    cell.setStroke(Color.BLACK);

                    value = new TextField();
                    value.setText(String.valueOf(getSpaceByCoordinates(x, y).getPrice()));
                    value.setAlignment(Pos.BOTTOM_CENTER);
                    value.setBackground(Background.EMPTY);
                    value.setBorder(Border.EMPTY);
                    if (getSpaceByCoordinates(x, y).getPrice() == 0) {
                        value.setText(" ");
                    }

                    propertyName = new TextArea(getSpaceByCoordinates(x, y).getName());
                    propertyName.setWrapText(true);
                    propertyName.setFont(Font.font("Ariel", 10));
                    propertyName.setBackground(Background.EMPTY);
                    propertyName.setBorder(Border.EMPTY);
                    if (getSpaceByCoordinates(x, y).getPrice() == 0) ;
                    {
                        propertyName.setText(" ");
                    }

                    VBox textVBox = new VBox(value, propertyName);
                    textVBox.setAlignment(Pos.BOTTOM_CENTER);
                    textVBox.setBackground(Background.EMPTY);
                    textVBox.setBorder(Border.EMPTY);

                    StackPane stackPane = new StackPane();
                    stackPane.getChildren().addAll(cell, textVBox);
                    stackPane.setAlignment(Pos.BOTTOM_CENTER);

                    cellContents = new VBox(stackPane);
                } else {
                    cell = new Rectangle(CELL_SIZE, CELL_SIZE);
                    cell.setFill(Color.LIGHTGRAY);
                    cell.setStroke(Color.LIGHTGRAY);
                    cellContents = new VBox(cell);
                }


                cellContents.setAlignment(Pos.CENTER);

                // Add image to specific cells
                ImageView imageView = null;
                if (y == 0 && x == 0) {
                    imageView = createImageView(FREE_PARKING_IMAGE_PATH, true);
                } else if (y == 0 && x == BOARD_SIZE - 1) {
                    imageView = createImageView(GO_TO_JAIL_IMAGE_PATH, true);
                } else if (y == BOARD_SIZE - 1 && x == 0) {
                    imageView = createImageView(JAIL_IMAGE_PATH, true);
                } else if (y == BOARD_SIZE - 1 && x == BOARD_SIZE - 1) {
                    imageView = createImageView(GO_IMAGE_PATH, true);
                } else if (y == 3 && x == 0 || y == BOARD_SIZE - 1 && x == 8 || y == 3 && x == BOARD_SIZE - 1) {
                    imageView = createImageView(COMMUNITY_CHEST_IMAGE_PATH, false);
                } else if (y == 6 && x == BOARD_SIZE - 1 || y == 0 && x == 2 || y == BOARD_SIZE - 1 && x == 3) {
                    imageView = createImageView(CHANCE_IMAGE_PATH, false);
                } else if (y == 5 && (x == 0 || x == BOARD_SIZE - 1)) {
                    imageView = createImageView(RAILROAD_IMAGE_PATH, false);
                } else if ((y == 0 || y == BOARD_SIZE - 1) && x == 5) {
                    imageView = createImageView(RAILROAD_IMAGE_PATH, false);
                } else if (y == 0 && x == 8) {
                    imageView = createImageView(WATER_IMAGE_PATH, false);
                } else if (y == 8 && x == 0) {
                    imageView = createImageView(ELECTRIC_IMAGE_PATH, false);
                } else if (y == BOARD_SIZE - 1 && x == 6) {
                    imageView = createImageView(INCOME_TAX, false);
                } else if (y == 8 && x == BOARD_SIZE - 1) {
                    imageView = createImageView(LUXURY_TAX, false);
                }


                // Add cell contents to the board
                if (imageView != null) {
                    StackPane cellStackPane = new StackPane(cellContents, imageView);
                    board.add(cellStackPane, x, y);
                } else {
                    board.add(cellContents, x, y);
                }
            }
        }

        return board;

    }

    // Creates an ImageView with the specified image path
    public static ImageView createImageView(String imagePath, boolean isCorner) {
        Image image = new Image(imagePath);
        ImageView imageView = new ImageView(image);
        if (isCorner) {
            imageView.setFitWidth(CELL_SIZE);
            imageView.setFitHeight(CELL_SIZE);
            imageView.setPickOnBounds(true);
        } else {
            imageView.setPreserveRatio(true);
            imageView.setFitWidth(CELL_SIZE / 2.0);
            imageView.setFitHeight(CELL_SIZE / 2.0);
            imageView.setLayoutX((CELL_SIZE - imageView.getBoundsInLocal().getWidth()) / 2);
            imageView.setLayoutY(CELL_SIZE - imageView.getBoundsInLocal().getHeight());
            imageView.setPickOnBounds(true);
        }
        return imageView;
    }


    // Creates the player's position label
    private Label createPositionLabel(Player player) {
        Label positionLabel = new Label();
        positionLabel.textProperty().bind(Bindings.format("%s's Position: %s", player.getName(), spaces[playerPositions[activePlayer]].getName()));
        return positionLabel;
    }

    private boolean isProperty() {
        return spaces[playerPositions[activePlayer]].getClass().getSimpleName().equals("Property") || spaces[playerPositions[activePlayer]].getClass().getSimpleName().equals("Utilities") || spaces[playerPositions[activePlayer]].getClass().getSimpleName().equals("Railroad");
    }

    public void showActionPopup(Player[] players, Label[] positionLabels) {
        /*Stage popup = new Stage();
        popup.initModality(Modality.APPLICATION_MODAL);
        popup.setTitle(players[activePlayer].getName() + "'s Turn");
        popup.setMinWidth(250);*/

        Label label = new Label();
        label.setText("Choose an action");

        Button rollButton = new Button("Roll Dice");

        Button buyButton = new Button("Buy Property");
        buyButton.setVisible(false);
        buyButton.setOnAction(e -> {
            players[activePlayer].addProperty(spaces[playerPositions[activePlayer]]);
            players[activePlayer].setBalance(spaces[playerPositions[activePlayer]].getPrice());
            //popup.close();
        });

        Button auctionButton = new Button("Auction Property");
        auctionButton.setVisible(false);
        auctionButton.setOnAction(e -> {
            Auction auction = new Auction(spaces[playerPositions[activePlayer]], (ArrayList<Player>) Arrays.asList(players));
            auction.runAuction();
            //popup.close();
        });

        Button tradeButton = new Button("Trade Property");
        tradeButton.setVisible(false);
        if (!players[activePlayer].getProperties().isEmpty()) {
            tradeButton.setVisible(true);
            tradeButton.setOnAction(e -> {
                // TODO - handle trade property action

                //popup.close();
            });
        }
        // TODO - only show endTurn if when landing on a property, it must be bought or auctioned off
        Button endTurnButton = new Button("End Turn");
        endTurnButton.setDisable(true);
        endTurnButton.setOnAction(e -> {
            activePlayer++;
            if (activePlayer >= players.length) {
                activePlayer = 0;
            }
            //popup.close();
        });
        //TODO - Set End Turn on close out (or implement buttons into main stage)
        rollButton.setOnAction(event -> {
            // Roll two 6 sided dice
            Random random = new Random();
            doubleRolls = 0;
                die1 = random.nextInt(1, 6);
                die2 = random.nextInt(1, 6);
                // Update player's position
                playerPositions[activePlayer] += (die1 + die2);
                if (playerPositions[activePlayer] >= 40) {
                    playerPositions[activePlayer] -= 40;
                    players[activePlayer].setBalance(players[activePlayer].getBalance() + 200);
                }
                updatePositionLabel(players[activePlayer], positionLabels[activePlayer]);
                if (isProperty()) {
                    buyButton.setVisible(true);
                    auctionButton.setVisible(true);
                }
                if (die1 == die2) {
                    doubleRolls++;
                    die1 = random.nextInt(1, 6);
                    die2 = random.nextInt(1, 6);
                } else {
                    doubleRolls = 0;
                    rollButton.setDisable(true);
                    endTurnButton.setDisable(false);
                }
            if (doubleRolls == 3) {
                goToJail(players[activePlayer]);
                updatePositionLabel(players[activePlayer], positionLabels[activePlayer]);
            }
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, rollButton, buyButton, auctionButton, tradeButton, endTurnButton);
        layout.setAlignment(Pos.CENTER);


        Scene scene = new Scene(layout);
        primaryStage.setScene(scene);
        primaryStage.showAndWait();
        // TODO - Fix showPropertiesPopup method, make it off center
        if (players[activePlayer].getProperties().size() != 0) {
            showPropertiesPopup(players[activePlayer]);
        }

    }

    private void goToJail(Player player) {
        playerPositions[activePlayer] = (10);
        player.setInJail(true);
    }

    private void updatePositionLabel(Player player, Label positionLabel) {
        positionLabel.textProperty().bind(Bindings.format("%s's Position: %s (%d) rolled [%d][%d]", player.getName(), spaces[playerPositions[activePlayer]].getName(), playerPositions[activePlayer], die1, die2));
    }

    private void showPropertiesPopup(Player player) {
        // Create a new stage to show the popup
        Stage popupStage = new Stage();

        // Create a VBox to hold the property cards
        VBox propertyBox = new VBox();
        propertyBox.setAlignment(Pos.CENTER);
        propertyBox.setSpacing(20);

        // Get the active player's properties
        List<Property> playerProperties = player.getProperties();

        // Loop through the properties and create a card for each one
        for (Property property : playerProperties) {
            // Create a new VBox to hold the property information
            VBox cardBox = new VBox();
            cardBox.setAlignment(Pos.CENTER);
            cardBox.setSpacing(10);

            // Create a rectangle at the top with the property name
            Rectangle nameRect = new Rectangle(200, 50);
            nameRect.setFill(property.getColor());
            Label nameLabel = new Label(property.getName());
            nameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));
            nameLabel.setTextFill(Color.BLACK);
            nameLabel.setAlignment(Pos.CENTER);
            nameRect.setClip(nameLabel);
            cardBox.getChildren().add(nameRect);

            // Add the rent information
            Label rentLabel = new Label("Rent: $" + property.getActiveRent());
            rentLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
            cardBox.getChildren().add(rentLabel);

            Label rentDetailsLabel = new Label(
                    String.format("Rent with 1 House: $%d\nRent with 2 Houses: $%d\nRent with 3 Houses: $%d\nRent with 4 Houses: $%d\nRent with Hotel: $%d",
                            property.getRent1(), property.getRent2(), property.getRent3(), property.getRent4(), property.getHotelRent()));
            rentDetailsLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 12));
            rentDetailsLabel.setTextAlignment(TextAlignment.CENTER);
            cardBox.getChildren().add(rentDetailsLabel);

            // Add the mortgage and building costs
            Label mortgageLabel = new Label("Mortgage: $" + property.getMortgage());
            mortgageLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
            cardBox.getChildren().add(mortgageLabel);

            Label buildingLabel = new Label(
                    String.format("House Cost: $%d\nHotel Cost: $%d",
                            property.getHousePrice(), property.getHousePrice()));
            buildingLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 12));
            buildingLabel.setTextAlignment(TextAlignment.CENTER);
            cardBox.getChildren().add(buildingLabel);

            // Add the card to the property box
            propertyBox.getChildren().add(cardBox);
        }

        // Create a scene and add the property box to it
        Scene popupScene = new Scene(propertyBox, 600, 600);
        popupStage.setScene(popupScene);
        popupStage.show();
    }

    private void showJailPopup() {
        // TODO - define this method

    }

    public void runTrade(Player[] players, int activePlayer, VBox boardLayout) {
            Button player1 = new Button(players[1].getName());
            Button player2 = new Button(players[2].getName());
            if (players.length == 3) {
                Button player3 = new Button(players[3].getName());
            } else if (players.length == 4) {
                Button player4 = new Button(players[4].getName());
            }
            Scene trade = new Scene(boardLayout);
            primaryStage.setTitle("Trading View");
            primaryStage.setScene(trade);


    }

    public static void main(String[] args) {
        launch(args);
    }
}
