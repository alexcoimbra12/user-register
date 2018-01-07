package br.com.alexcoimbra12.userregister.converter;

import br.com.alexcoimbra12.userregister.populator.Populator;
import br.com.alexcoimbra12.userregister.util.Validator;

public class UserConverter<T> implements Converter<T, T> {

	private Populator<T, T> populator;
	
	@Override
	public T converter(T source, T target) {
		Validator.checkObjIsNullOrEmpty("Object cannot be null", source, target);
		return populator.populate(source, target);
	}

	public Populator<T, T> getPopulator() {
		return populator;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void setPopulator(Populator populator) {
		this.populator = populator;
	}

}
