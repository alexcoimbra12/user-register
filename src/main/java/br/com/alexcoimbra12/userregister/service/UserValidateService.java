package br.com.alexcoimbra12.userregister.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alexcoimbra12.userregister.model.UserModel;
import br.com.alexcoimbra12.userregister.repository.UserRepository;
import br.com.alexcoimbra12.userregister.strategy.UserEmailValidateStrategy;
import br.com.alexcoimbra12.userregister.strategy.UserNameValidateStrategy;
import br.com.alexcoimbra12.userregister.util.Validator;

@Service
public class UserValidateService {
	
	@Autowired
	private UserNameValidateStrategy userNameValidateStrategy;

	@Autowired
	private UserEmailValidateStrategy userEmailValidateStrategy;
	
	@Autowired
	private UserRepository userRepository;
	
	public void validateUserToSave(UserModel user) {
		
		Validator.checkObjIsNullOrEmpty("User cannot be null", user);
		Validator.checkObjIsNullOrEmpty("Email cannot be null", user.getEmail());
		Validator.checkObjIsNullOrEmpty("First Name cannot be null", user.getFirstName());
		Validator.checkObjIsNullOrEmpty("Last Name cannot be null", user.getLastName());
		
		userEmailValidateStrategy.validateEmail(user.getEmail());
		userNameValidateStrategy.validateName(user.getFirstName(), user.getLastName());
		
		changeEmailToLowerCase(user);
		checkIfUserAlreadyExist(user);
		
	}
	
	private void checkIfUserAlreadyExist(UserModel user) {
		
		UserModel userModelByEmail = userRepository.findByEmail(user.getEmail());
		
		if(null != userModelByEmail) {
			throw new IllegalArgumentException("User already exist");
		}
	}
	
	private void changeEmailToLowerCase(UserModel user) {
		user.setEmail(user.getEmail().toLowerCase());
	}
	
	
	
}
