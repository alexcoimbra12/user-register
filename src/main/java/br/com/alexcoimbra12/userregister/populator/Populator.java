package br.com.alexcoimbra12.userregister.populator;

public interface Populator<SOURCE, TARGET> {

	TARGET populate(SOURCE source, TARGET target);
	
}
