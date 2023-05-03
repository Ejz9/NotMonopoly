package com.not.monopoly.Objects;

import javafx.scene.control.TextInputDialog;

import java.util.ArrayList;
import java.util.HashMap;

public class Auction {
    private ArrayList<Property> properties;
    private Property property;
    private ArrayList<Player> players;
    private HashMap<Player, Integer> bids;
    private Player bankruptPlayer;
    private Player biddingPlayer;


    public Auction(Property property, ArrayList<Player> players) {
        this.property = property;
        this.players = players;

    }

    public Auction(Player bankruptPlayer,ArrayList<Property> properties, ArrayList<Player> players) {
        this.bankruptPlayer = bankruptPlayer;
        this.properties = properties;
        this.players = players;
    }

    public void runAuction() {
        int currentValue = property.getPrice();
        int newValue;
        String result;
        TextInputDialog auction = new TextInputDialog();
        auction.setTitle(property.getName() + " is being put up for auction");
        auction.setHeaderText(String.format("Current Bid Price: %d", property.getPrice()));
        auction.setContentText("Enter a number for desired auction bid:");

        auction.show();

        for (int i = 0; i < players.size(); i++) {
            if (players.size() == 1) {
                break;
            }
            if (i == players.size()) {
                i = 0;
            }
            biddingPlayer = players.get(i);
            auction.setContentText(biddingPlayer.getName() + "Enter a number for desired auction bid:");
            result = auction.showAndWait().orElse("1");

            //TODO - set it so the player is removed from `players` in the event cancel is ran.

            try {
                newValue = Integer.parseInt(result);
                if (newValue >= 1 && newValue <= biddingPlayer.getBalance()) {
                        currentValue += newValue;
                }
            } catch (NumberFormatException e) {
                //Invalid input, try again
            }
        }
    }

    public void runBankruptAuction () {
        int currentValue;
        int newValue;
        String result;
        ArrayList<Player> tempList;
        TextInputDialog dialog;

        for (Property property : properties) {
            tempList = players;
            currentValue = property.getPrice();
            dialog = new TextInputDialog(String.valueOf(currentValue));
            dialog.setTitle(property.getName() + " is being put up for auction");
            dialog.setHeaderText(String.format("Current Bid Price: %d", property.getPrice()));
            dialog.setContentText("Enter a number for desired auction bid:");

            for (int i = 0; i < tempList.size(); i++) {
                if (players.size() == 1) {
                    break;
                }
                if (i == tempList.size()) {
                    i = 0;
                }
                biddingPlayer = tempList.get(i);
                dialog.setContentText(biddingPlayer.getName() + "Enter a number for desired auction bid:");
                result = dialog.showAndWait().orElse("1");

                //TODO - set it so the player is removed from `players` in the event cancel is ran.

                try {
                    newValue = Integer.parseInt(result);
                    if (newValue >= 1 && newValue <= biddingPlayer.getBalance()) {
                        currentValue += newValue;
                    }
                } catch (NumberFormatException e) {
                    //Invalid input, try again
                }
            }
            biddingPlayer.setBalance(biddingPlayer.getBalance() - currentValue);
            biddingPlayer.addProperty(property);
        }
        bankruptPlayer.removeProperty(property);
    }
}