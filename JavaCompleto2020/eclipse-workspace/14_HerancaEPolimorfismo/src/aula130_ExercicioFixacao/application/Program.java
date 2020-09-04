package aula130_ExercicioFixacao.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import aula130_ExercicioFixacao.entities.ImportedProduct;
import aula130_ExercicioFixacao.entities.Product;
import aula130_ExercicioFixacao.entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		List<Product> products = new ArrayList<>();

		System.out.print("Enter the number of products: ");
		int numberProducts = sc.nextInt();

		for (int i = 1; i <= numberProducts; i++) {
			System.out.print("Common, used or imported (c/u/i): ");
			char letra = sc.next().charAt(0);

			if (letra == 'c') {
				System.out.print("Name: "); sc.nextLine(); String name = sc.nextLine();
				System.out.print("Price: "); double price = sc.nextDouble();
				Product p = new Product(name, price);
				products.add(p);
			} else if (letra == 'i') {
				System.out.print("Name: "); sc.nextLine(); String name = sc.nextLine();
				System.out.print("Price: "); double price = sc.nextDouble();
				System.out.print("Customs fee: "); double customsFee = sc.nextDouble();
				Product p = new ImportedProduct(name, price, customsFee);
				products.add(p);
			} else if (letra == 'u') {
				System.out.print("Name: "); sc.nextLine(); String name = sc.nextLine();
				System.out.print("Price: "); double price = sc.nextDouble();
				System.out.print("Manufacture date (DD/MM/YYYY): "); Date date = sdf.parse(sc.next());
				Product p = new UsedProduct(name, price, date);
				products.add(p);
			}
		}
		
		System.out.println("PRICE TAGS");
		for (Product p : products) {
			System.out.println(p.priceTag());
		}

		sc.close();
	}

}
