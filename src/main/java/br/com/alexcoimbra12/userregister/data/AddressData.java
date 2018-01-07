package br.com.alexcoimbra12.userregister.data;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder(value = "address")
public class AddressData {

	private String street;
	private String number;
	private String state;
	private String zipCode;
	private String shortState;

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getShortState() {
		return shortState;
	}

	public void setShortState(String shortState) {
		this.shortState = shortState;
	}

}
