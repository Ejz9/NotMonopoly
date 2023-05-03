package com.not.monopoly.Objects;

import javafx.scene.paint.Color;

public class CardSpace extends Property{
private final CardType type;
	public CardSpace(String name, CardType cardType) {
		super(name, 0, 0, 0, Color.WHITE, 0, 0 , 0, 0, 0, 0, -1, -1);
		this.type = cardType;
	}

	public CardType getType() {
		return type;
	}
}
