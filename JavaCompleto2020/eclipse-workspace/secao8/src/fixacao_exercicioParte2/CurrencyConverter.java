package fixacao_exercicioParte2;

public class CurrencyConverter {
	
	public static final double IOF = 6; //static - nao é preciso instanciar o objeto
	
	public static double quant(double price, double quant) {
		return price*quant;
	}
	
	public static double totalComIOF(double total) {
		return total+=(total*(IOF/100));
	}
}
