package aula223_FuncoesLambdaComoParametroV2.application;

import java.util.ArrayList;
import java.util.List;

import aula223_FuncoesLambdaComoParametroV2.entities.Product;
import aula223_FuncoesLambdaComoParametroV2.util.ProductService;

public class Program {

	public static void main(String[] args) {
		
		List<Product> list = new ArrayList<>();

		list.add(new Product("Tv", 900.00));
		list.add(new Product("Mouse", 50.00));
		list.add(new Product("Tablet", 350.50));
		list.add(new Product("HD Case", 80.90));
		
		//Calcular soma do preço dos produtos que começa por T:
		
		ProductService ps = new ProductService(); //instanciar a classe ProductService
		double sum = ps.filteredSumm(list, p -> p.getName().charAt(0) == 'T'); //recebe a lista e o predicado como argumento
		//desta forma não é necessário abrir a classe ProductService caso seja necessário alterar o Predicado
		
		System.out.println("Sum: " + String.format("%.2f", sum));
	}

}
