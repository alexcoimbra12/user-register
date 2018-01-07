package br.com.alexcoimbra12.userregister.model;

public class AddressModel {

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

	@Override
	public String toString() {
		return "AddressModel [street=" + street + ", number=" + number + ", state=" + state + ", zipCode=" + zipCode
				+ ", shortState=" + shortState + "]";
	}

}
