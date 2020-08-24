package aula113_enumeracoes;

import java.util.Date;

public class Program {

	public static void main(String[] args) {
		Order order = new Order(1080, new Date(), OrderStatus.PENDING_PAYMENT);
		System.out.println(order);
		
		//instanciar um enumerado - objecto to tipo OrderStatus
		OrderStatus os1 = OrderStatus.DELIVERED;
		//instanciar um enumerado - convertendo de string para enum
		OrderStatus os2 = OrderStatus.valueOf("DELIVERED");
	}

}
