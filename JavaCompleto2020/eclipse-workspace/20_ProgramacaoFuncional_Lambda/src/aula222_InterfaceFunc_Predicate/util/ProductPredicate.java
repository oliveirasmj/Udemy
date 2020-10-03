package aula222_InterfaceFunc_Predicate.util;

import java.util.function.Predicate;

import aula222_InterfaceFunc_Predicate.entities.Product;

public class ProductPredicate implements Predicate<Product>{ //FORMA 3

	@Override
	public boolean test(Product p) {
		return p.getPrice() >= 100.0; //retorna os produtos a remover como true
	}

}
