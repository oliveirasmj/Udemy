package aula223_FuncoesLambdaComoParametro.util;

import java.util.List;

import aula223_FuncoesLambdaComoParametro.entities.Product;

public class ProductService {
	
	//metodo para saber a soma dos preços dos produtos que começam por T
	public double filteredSumm(List<Product> list) { //recebe uma lista de produtos
		double sum = 0.0;
		for(Product p : list) {
			if(p.getName().charAt(0) == 'T') {
				sum += p.getPrice();
			}
		}
		return sum;
	}
}
