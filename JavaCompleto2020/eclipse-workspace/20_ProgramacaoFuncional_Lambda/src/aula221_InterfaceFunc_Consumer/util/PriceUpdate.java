package aula221_InterfaceFunc_Consumer.util;

import java.util.function.Consumer;

import aula221_InterfaceFunc_Consumer.entities.Product;

public class PriceUpdate implements Consumer<Product> { //FORMA 3 - implementa interface Consumer(interface funcional: tem apenas 1 metodo abstrato)

	@Override
	public void accept(Product p) {
		p.setPrice(p.getPrice() * 1.1); //aumentar o preco em 10%
	}
	
}
