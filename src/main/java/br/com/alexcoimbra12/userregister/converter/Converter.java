package br.com.alexcoimbra12.userregister.converter;

public interface Converter<SOURCE, TARGET> {

	TARGET converter(SOURCE source, TARGET target);
}
