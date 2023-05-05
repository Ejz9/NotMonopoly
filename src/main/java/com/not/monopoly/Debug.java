package com.not.monopoly;

import com.not.monopoly.Objects.Player;

import java.util.List;

import static com.not.monopoly.GameController.*;

public class Debug {
    public static void printPlayersDebug(List<Player> players) {
        for (Player player : players) {
            System.out.println(player.getName());
        }
    }
}
