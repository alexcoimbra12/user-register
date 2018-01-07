package br.com.alexcoimbra12.userregister.populator;

import br.com.alexcoimbra12.userregister.data.UserData;
import br.com.alexcoimbra12.userregister.model.AddressModel;
import br.com.alexcoimbra12.userregister.model.UserModel;

public class UserModelPopulator implements Populator<UserData, UserModel> {

	private static final String SPACE_SEPARATOR = " ";
	
	@Override
	public UserModel populate(UserData source, UserModel target) {
		target.setEmail(source.getEmail());
		setFirstAndLastName(source, target);
		setAddress(source, target);
		return target;
	}

	private void setFirstAndLastName(UserData source, UserModel target) {
		
		String[] fullName = source.getFullName().split(SPACE_SEPARATOR);
		
		if(fullName.length != 2) {
			throw new IllegalArgumentException("Name Invalid: " + source.getFullName());
		}
		
		target.setFirstName(fullName[0]);
		target.setLastName(fullName[1]);
	}
	
	private void setAddress(UserData source, UserModel target) {
		
		String[] fullAddress = source.getFullAddress().split("-");
		
		if(fullAddress.length != 5) {
			throw new IllegalArgumentException("Address Invalid: " + source.getFullAddress());
		}
		
		AddressModel address = new AddressModel();
		address.setStreet(getStringWithoutSpaces(fullAddress[0]));
		address.setNumber(getStringWithoutSpaces(fullAddress[1]));
		address.setZipCode(getStringWithoutSpaces(fullAddress[2]));
		address.setState(getStringWithoutSpaces(fullAddress[3]));
		address.setShortState(getStringWithoutSpaces(fullAddress[4]));
		target.setAddress(address);
		
	}
	
	private String getStringWithoutSpaces(String s) {
		return null == s ? "" : s.trim();
	}
}
