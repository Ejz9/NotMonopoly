package com.not.monopoly.Objects;

import javafx.scene.paint.Color;

public class Property extends Space {
	private final int price;
	private final int housePrice;
	private int activeRent;
	private final Color color;
	private int houses;
	private final int rent1;
	private final int rent2;
	private final int rent3;
	private final int rent4;
	private final int hotelRent;
	private final int mortgage;
	private Player ownedBy = null;
	private int x;
	private int y;


	public Property(String name, int price, int housePrice, int activeRent, Color color, int rent1, int rent2, int rent3, int rent4, int hotelRent, int mortgage, int x, int y) {
		super(name);
		this.price = price;
		this.housePrice = housePrice;
		this.activeRent = activeRent;
		this.color = color;
		this.rent1 = rent1;
		this.rent2 = rent2;
		this.rent3 = rent3;
		this.rent4 = rent4;
		this.hotelRent = hotelRent;
		this.mortgage = mortgage;
		ownedBy = null;
		houses = 0;
		this.x = x;
		this.y = y;
	}

	@Override
	public String getName() {
		return super.getName();
	}

	public int getPrice() {
		return price;
	}

	public int getHousePrice() {
		return housePrice;
	}

	public int getActiveRent() {
		return activeRent;
	}

	public Color getColor() {
		return color;
	}

	public int getRent1() {
		return rent1;
	}

	public int getRent2() {
		return rent2;
	}

	public int getRent3() {
		return rent3;
	}

	public int getHouses() {
		return houses;
	}

	public Player getOwnedBy() {
		return ownedBy;
	}

	public void setActiveRent(int activeRent) {
		this.activeRent = activeRent;
	}

	public void setOwnedBy(Player ownedBy) {
		this.ownedBy = ownedBy;
	}

	public void setHouses(int houses) {
		this.houses = houses;
	}

	public int getRent4() {
		return rent4;
	}

	public int getHotelRent() {
		return hotelRent;
	}

	public int getMortgage() {
		return mortgage;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	public void setCoordinates(int x, int y){
		setX(x);
		setY(y);
	}
}
