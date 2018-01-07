package br.com.alexcoimbra12.userregister.strategy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component
public class UserNameValidateStrategy {

	private static final String NAME_PATTERN = "^[\\p{L}\\s'.-]+$";
	
	private Pattern pattern;
	private Matcher matcher;
	
	public UserNameValidateStrategy() {
		pattern = Pattern.compile(NAME_PATTERN);
	}
	
	public void validateName(String firstName, String lastName) {
		
		matcher = pattern.matcher(firstName);
		
		if(!matcher.matches()) {
			throw new IllegalArgumentException("FirstName is invalid: " + firstName);
		}
		
		matcher = pattern.matcher(lastName);
		
		if(!matcher.matches()) {
			throw new IllegalArgumentException("LastName is invalid: " + lastName);
		}
		
	}
	
}
