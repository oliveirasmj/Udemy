package aula120_exercicioFixacao.entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import aula120_exercicioFixacao.enums.OrderStatus;

public class Order {
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Date moment;
	private OrderStatus status;
	private Client client; //uma encomenda pode ter um cliente (tem referência para o Cliente)
	private List<OrderItem> orders = new ArrayList<OrderItem>(); //uma encomenda pode ter vários OrderItem
	
	public Order() {
	}

	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getOrders() {
		return orders;
	}

//	public void setOrders(List<OrderItem> orders) { //Nao se usa porque não queremos criar uma lista nova, apenas adicionar e remover
//		this.orders = orders;
//	}
	
	public void addItem(OrderItem item) {
		orders.add(item);
	}
	
	public void removeItem(OrderItem item) {
		orders.remove(item);
	}
	
	public Double total() {
		double soma = 0.0;
		for(OrderItem item : orders) {
			soma += item.subTotal(); //somar os subtotais de todas os OrderItems
		}
		return soma;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: " + sdf.format(moment) + "\n");
		sb.append("Order status" + status + "\n");
		sb.append("Client: " + client + "\n");
		sb.append("Order items: " + orders + "\n");
		for(OrderItem item : orders) {
			sb.append(item + "\n");
		}
		sb.append("Total price: $");
		sb.append(String.format("%.2f", total()));
		return sb.toString();
	}
	
	
}
