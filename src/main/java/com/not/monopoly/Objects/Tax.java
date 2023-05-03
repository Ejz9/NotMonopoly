package com.not.monopoly.Objects;

import javafx.scene.paint.Color;

public class Tax extends Property{
	private final int tax;

	public Tax(String name, int tax) {
		super(name, 0, 0, 0, Color.WHITE, 0, 0 , 0, 0, 0, 0, -1, -1);
		this.tax = tax;
	}

	public int getTax() {
		return tax;
	}
}
