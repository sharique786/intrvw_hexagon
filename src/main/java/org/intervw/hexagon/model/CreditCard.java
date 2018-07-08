package org.intervw.hexagon.model;

public class CreditCard {

	private long id;
	private String ccNumber;
	private String ccType;
	private int noOfCards;
	private String expiryDate;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getCcNumber() {
		return ccNumber;
	}
	
	public void setCcNumber(String string) {
		this.ccNumber = string;
	}
	
	public String getCcType() {
		return ccType;
	}
	
	public void setCcType(String ccType) {
		this.ccType = ccType;
	}
	
	public int getNoOfCards() {
		return noOfCards;
	}

	public void setNoOfCards(int noOfCards) {
		this.noOfCards = noOfCards;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	
}
