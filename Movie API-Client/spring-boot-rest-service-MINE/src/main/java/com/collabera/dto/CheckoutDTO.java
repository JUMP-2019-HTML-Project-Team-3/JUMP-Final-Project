package com.collabera.dto;

public class CheckoutDTO {
	private String name;
	private String address;
	private String cardNumber;
	private String cardExpiry;
	private String cardSecurityCode;
	
	public CheckoutDTO(String name, String address, String cardNumber, String cardExpiry, String cardSecurityCode) {
		super();
		this.name = name;
		this.address = address;
		this.cardNumber = cardNumber;
		this.cardExpiry = cardExpiry;
		this.cardSecurityCode = cardSecurityCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardExpiry() {
		return cardExpiry;
	}
	public void setCardExpiry(String cardExpiry) {
		this.cardExpiry = cardExpiry;
	}
	public String getCardSecurityCode() {
		return cardSecurityCode;
	}
	public void setCardSecurityCode(String cardSecurityCode) {
		this.cardSecurityCode = cardSecurityCode;
	}
}

