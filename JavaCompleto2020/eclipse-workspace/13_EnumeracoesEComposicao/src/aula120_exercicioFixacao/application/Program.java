package aula120_exercicioFixacao.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import aula120_exercicioFixacao.entities.Client;
import aula120_exercicioFixacao.entities.Order;
import aula120_exercicioFixacao.entities.OrderItem;
import aula120_exercicioFixacao.entities.Product;
import aula120_exercicioFixacao.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter client data:");
		System.out.print("Name: "); String nome =sc.nextLine();
		System.out.print("Email: "); String email =sc.nextLine();
		System.out.print("Bith date (DD/MM/YYY): "); Date data = sdf.parse(sc.next());
		Client client = new Client(nome, email, data);
		
		System.out.println("Enter order data:");
		System.out.print("Status: "); OrderStatus status = OrderStatus.valueOf(sc.next());
		Order order = new Order(new Date(), status, client);
		
		System.out.print("How many items to this order? ");
		int numItems = sc.nextInt(); //Vai ficar pendente na linha-------------------------------------------------------------------------------------------
		for(int i=1; i<=numItems; i++) {
			System.out.println("Enter #" + i + " item data: ");
			System.out.print("Product name: "); sc.nextLine(); String nomeProduto = sc.nextLine(); //Quebra de linha pendente--------------------------------
			System.out.print("Price: "); double precoProduto = sc.nextDouble();
			Product product = new Product(nomeProduto, precoProduto);
			
			System.out.print("Quantity: "); int quantidadeProduto = sc.nextInt();
			OrderItem orderItem = new OrderItem(quantidadeProduto, product.getPrice(), product);
			
			order.addItem(orderItem);
		}
		
		System.out.println("ORDER SUMMARY:");
		System.out.println(order);
		
		//System.out.println(order.getClient().getName()); //aceder ao nome do cliente atraves do objeto order
	
		sc.close();
	}

}
