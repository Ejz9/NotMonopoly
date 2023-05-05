package com.not.monopoly;

import com.not.monopoly.Objects.Player;

import static com.not.monopoly.Main.*;

public class Checks {
    protected int isAllOwned(){
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getProperties().size() == 28){
                return i;
            }
        }
        return -1;
    }
}
