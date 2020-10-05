package aula222_InterfaceFunc_Function.util;

import java.util.function.Function;

import aula222_InterfaceFunc_Function.entities.Product;

public class UpperCaseName implements Function<Product, String>{ //método que recebe um Product e retorna uma String

	@Override
	public String apply(Product p) {
		return p.getName().toUpperCase();
	}

}
