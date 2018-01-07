package br.com.alexcoimbra12.userregister.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.alexcoimbra12.userregister.converter.Converter;
import br.com.alexcoimbra12.userregister.converter.UserConverter;
import br.com.alexcoimbra12.userregister.populator.UserDataPopulator;
import br.com.alexcoimbra12.userregister.populator.UserModelPopulator;

@Configuration
public class AppConfig {

	@SuppressWarnings("rawtypes")
	@Bean
	public Converter converterDataToModelBean() {
		UserConverter<Object> userConverter = new UserConverter<>();
		UserModelPopulator userModelPopulator = new UserModelPopulator();
		userConverter.setPopulator(userModelPopulator);
		return userConverter;
	}
	
	@SuppressWarnings("rawtypes")
	@Bean
	public Converter converterModelToDataBean() {
		UserConverter<Object> userConverter = new UserConverter<>();
		UserDataPopulator userDataPopulator = new UserDataPopulator();
		userConverter.setPopulator(userDataPopulator);
		return userConverter;
	}
	
}
