package br.com.alexcoimbra12.userregister.util;

import java.util.Arrays;

import org.springframework.util.StringUtils;

public class Validator {

	public static void checkObjIsNullOrEmpty(String errorMessage, Object... objects) {
		Arrays
			.stream(objects)
			.forEach(obj -> {
				if (null == obj) throw new IllegalArgumentException(errorMessage);
				if( obj instanceof String && StringUtils.isEmpty(obj)) throw new IllegalArgumentException(errorMessage);  
			});
	}
}
