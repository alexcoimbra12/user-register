package br.com.alexcoimbra12.userregister.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.alexcoimbra12.userregister.data.UserData;
import br.com.alexcoimbra12.userregister.facade.UserFacade;

@RestController
@RequestMapping(value = "/user-register")
public class UserController {

	@Autowired
	private UserFacade userFacade;
	
	@RequestMapping(method = RequestMethod.POST)
	public String saveUser(@RequestBody UserData userData) {
		return userFacade.saveUser(userData);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void updateUser(@RequestBody UserData userData) {
		userFacade.updateUser(userData);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public UserData getUserById(@PathVariable(name = "id") String id) {
		return userFacade.getUserById(id);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public Collection<UserData> getAllUsers() {
		return userFacade.getAllUser();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteUserById(@PathVariable(name = "id") String id) {
		userFacade.deleteUserById(id);
	}
	
	@ExceptionHandler
	public ResponseEntity<String> genericError(Exception e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
