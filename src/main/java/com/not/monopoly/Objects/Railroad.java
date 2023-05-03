package com.not.monopoly.Objects;

import javafx.scene.paint.Color;

public class Railroad extends Property{
	Direction direction;

	public Railroad(String name, int price, int rent, Direction direction) {
		super(name, price, 0, rent, Color.WHITE, 0, 0, 0, 0, 0, 0, -1, -1);
		this.direction = direction;
	}

	public Direction getDirection() {
		return direction;
	}
}
