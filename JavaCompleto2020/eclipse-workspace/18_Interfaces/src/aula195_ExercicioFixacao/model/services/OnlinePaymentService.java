package aula195_ExercicioFixacao.model.services;

public interface OnlinePaymentService {
	
	double paymentFee(double amount); //Taxa Pagamento
	double interest(double amount, int months); //Juro mensal
}
