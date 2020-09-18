package aula195_ExercicioFixacao.model.services;

public class PaypalService implements OnlinePaymentService{

	private static final double FEE_PERCENTAGE = 0.02; //Taxa Pagamento
	private static final double MONTHLY_INTEREST = 0.01; //Juro mensal

	@Override
	public double paymentFee(double amount) { //Taxa Pagamento
		return amount * FEE_PERCENTAGE;
	}

	@Override
	public double interest(double amount, int months) { //Juro mensal
		return amount * MONTHLY_INTEREST * months;
	}
}