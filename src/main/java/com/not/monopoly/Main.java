package com.not.monopoly;

import com.not.monopoly.Objects.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.not.monopoly.Objects.*;

public class Main extends Application {
	protected static int activePlayer = 0;
	protected static int die1;
	protected static int die2;
	protected static List<Player> players = new ArrayList<>();


	@Override
	public void start(Stage primaryStage) throws IOException {
		Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("menu-screen.fxml")));
		primaryStage.setTitle("Monopoly Game");
		primaryStage.setScene(new Scene(root, 1280, 720));
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch();
	}

	// TODO - make player property squares empty with black outline
	//OLD (maybe useful) Code
    /*public static void onClickPlay(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main-board.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setScene(scene);
        stage.show();
    }*/
}