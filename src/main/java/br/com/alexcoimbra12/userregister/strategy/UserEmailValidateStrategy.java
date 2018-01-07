package br.com.alexcoimbra12.userregister.strategy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component
public class UserEmailValidateStrategy {

	private Pattern pattern;
	private Matcher matcher;
	
	public UserEmailValidateStrategy() {
		pattern = Pattern.compile(EMAIL_PATTERN);
	}
	
	private static final String EMAIL_PATTERN =
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	public void validateEmail(String email) {
		matcher = pattern.matcher(email);
		
		if(!matcher.matches()) {
			throw new IllegalArgumentException("Email is invalid: " + email);
		}
		
	}

}
