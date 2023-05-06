package com.not.monopoly.DONOTSUBMIT;

import com.not.monopoly.Objects.Player;

import java.util.List;

public class Debug {
    public static void printPlayersDebug(List<Player> players) {
        for (Player player : players) {
            System.out.println(player.getName());
        }
    }
    public static void main(String[] args) {
        for (int i = 0; i < 40; i++){
            System.out.printf("yCoords.put(%d, );%n", i);
        }
    }
}
