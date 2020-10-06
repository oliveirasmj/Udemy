package aula223_FuncoesLambdaComoParametroV2.util;

import java.util.List;
import java.util.function.Predicate;

import aula223_FuncoesLambdaComoParametroV2.entities.Product;

public class ProductService {
	
	//metodo para saber a soma dos preços dos produtos que começam por T
	public double filteredSumm(List<Product> list, Predicate<Product> criterio) { //recebe uma lista de produtos e um Predicate do tipo Product
		double sum = 0.0;
		for(Product p : list) {
			if(criterio.test(p)) { //teste generico de qualquer predicado que for recebido como parametro - retorna boolean - ser for true faz a soma
				sum += p.getPrice();
			}
		}
		return sum;
	}
}
