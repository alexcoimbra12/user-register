package br.com.alexcoimbra12.userregister.facade;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.com.alexcoimbra12.userregister.converter.Converter;
import br.com.alexcoimbra12.userregister.data.UserData;
import br.com.alexcoimbra12.userregister.model.UserModel;
import br.com.alexcoimbra12.userregister.service.UserService;
import br.com.alexcoimbra12.userregister.service.UserValidateService;

@Service
public class UserFacade {

	@Autowired
	private UserService userService;

	@Autowired
	private UserValidateService userValidateService;

	@Autowired
	@Qualifier("converterDataToModelBean")
	private Converter<UserData, UserModel> converterDataToModel;

	@Autowired
	@Qualifier("converterModelToDataBean")
	private Converter<UserModel, UserData> converterModelToData;

	public String saveUser(UserData userData) {
		UserModel user = converterDataToModel.converter(userData, new UserModel());
		userValidateService.validateUserToSave(user);
		return userService.saveUser(user);
	}

	public UserData getUserById(String id) {
		UserModel userModel = userService.getUserById(id);
		return converterModelToData.converter(userModel, new UserData());
	}

	public void updateUser(UserData userData) {
		UserModel user = converterDataToModel.converter(userData, new UserModel());
		userService.updateUser(user);
	}

	public void deleteUserById(String id) {
		userService.deleteUserById(id);
	}

	public Collection<UserData> getAllUser() {
		return userService.getAllUsers().stream()
				.map(user -> converterModelToData.converter(user, new UserData()))
				.collect(Collectors.toList());

	}
}
