package com.not.monopoly;

import com.not.monopoly.Objects.*;
import javafx.scene.paint.Color;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class PropertyCreation {
    private static final String PROPERTY_VALUES = "src/main/resources/data/PropertyValues";
    private static final String COORDINATES = "src/main/resources/data/coordinates_xy";
    private static final String PROPERTY_NAMES = "src/main/resources/data/PropertyNames";

    protected static Property[] createSpaces() throws IOException {
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
        }
        return spaces;
    }

    protected static List<String> createPropertyNamesList() throws IOException {
        FileManager propertyNames = new FileManager(new File(PROPERTY_NAMES));
        return propertyNames.readData();
    }


}
