package com.not.monopoly.Objects;

import java.util.ArrayList;


public class Player {
	private String name;
	private int balance;
	private int position;
	private ArrayList<Property> properties = new ArrayList<>();
	private int jailCards;

	private int taxCards;
	private boolean inJail = false;
	public Player(String name){
		this.name = name;
		balance = 1500;
		position = 0;
		jailCards = 0;
		taxCards = 0;
	}

	public String getName() {
		return name;
	}

	public int getBalance() {
		return balance;
	}

	public String getBalanceAsString() {
		return String.valueOf(balance);
	}

	public ArrayList<Property> getProperties() {
		return properties;
	}

	public boolean isInJail() {
		return inJail;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public void setInJail(boolean inJail) {
		this.inJail = inJail;
	}

	public void addProperty(Property property){
		properties.add(property);
	}

	public void removeProperty(Property property) {
		properties.remove(property);
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getJailCards() {
		return jailCards;
	}

	public void setJailCards(int jailCards) {
		this.jailCards = jailCards;
	}

	public boolean hasGetOutOfJailCard() {
		return jailCards > 0;
	}

	public int getTaxCards() {
		return taxCards;
	}

	public void setTaxCards(int taxCards) {
		this.taxCards = taxCards;
	}
}
