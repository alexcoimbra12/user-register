package br.com.alexcoimbra12.userregister.populator;

import br.com.alexcoimbra12.userregister.data.UserData;
import br.com.alexcoimbra12.userregister.model.AddressModel;
import br.com.alexcoimbra12.userregister.model.UserModel;
import br.com.alexcoimbra12.userregister.util.Validator;

public class UserDataPopulator implements Populator<UserModel, UserData> {

	private static final String SPACE_SEPARATOR = " ";
	
	@Override
	public UserData populate(UserModel source, UserData target) {
		target.setEmail(source.getEmail());
		setFullName(source, target);
		setFullAddress(source, target);
		return target;
	}

	private void setFullName(UserModel source, UserData target) {

		StringBuilder fullName = new StringBuilder()
				.append(source.getFirstName())
				.append(SPACE_SEPARATOR)
				.append(source.getLastName());

		target.setFullName(fullName.toString());
	}
	
	private void setFullAddress(UserModel source, UserData target) {
		
		AddressModel address = source.getAddress();
		
		Validator.checkObjIsNullOrEmpty("Address cannot be null", address);
		
		StringBuilder fullAddress = new StringBuilder()
				.append(address.getStreet())
				.append(SPACE_SEPARATOR)
				.append("-")
				.append(SPACE_SEPARATOR)
				.append(address.getNumber())
				.append(SPACE_SEPARATOR)
				.append("-")
				.append(SPACE_SEPARATOR)
				.append(address.getZipCode())
				.append(SPACE_SEPARATOR)
				.append("-")
				.append(SPACE_SEPARATOR)
				.append(address.getState())
				.append(SPACE_SEPARATOR)
				.append("-")
				.append(SPACE_SEPARATOR)
				.append(address.getShortState());
		
		target.setFullAddress(fullAddress.toString());
	}
}
