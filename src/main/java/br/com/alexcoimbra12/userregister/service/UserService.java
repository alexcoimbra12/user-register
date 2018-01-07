package br.com.alexcoimbra12.userregister.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alexcoimbra12.userregister.model.UserModel;
import br.com.alexcoimbra12.userregister.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public String saveUser(UserModel user) {
		UserModel userSaved = userRepository.save(user);
		return userSaved.getId();
	}
	
	public Collection<UserModel> getAllUsers() {
		return userRepository.findAll();
	}
	
	public UserModel getUserById(String id) {
		return userRepository.findOne(id);
	}
	
	public void deleteUserById(String id) {
		userRepository.delete(id);
	}
	
	public void updateUser(UserModel user) {
		userRepository.save(user);
	}
}
