package com.not.monopoly.Objects;

import javafx.scene.paint.Color;

public class Utilities extends Property{
	private final Utility utility;
	private final int houses;
	public Utilities(String name, int price, int rent, Utility utility) {
		super(name, price, 0, rent, Color.WHITE, 0, 0 , 0, 0, 0, 0, -1 , -1);
		this.utility = utility;
		houses = 0;
	}

	public Utility getUtility() {
		return utility;
	}

}
