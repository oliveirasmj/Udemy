package aula195_ExercicioFixacao.model.services;

import java.util.Calendar;
import java.util.Date;

import aula195_ExercicioFixacao.model.entities.Contract;
import aula195_ExercicioFixacao.model.entities.Installment;

public class ContractService {  //Serviço para processar um contrato - instanciar as mensalidades necessarias

	private OnlinePaymentService onlinePaymentService;
	
	public ContractService(OnlinePaymentService onlinePaymentService) { //no programa principal é dito se será o PaypalService que é do tipo OnlinePaymentService
		this.onlinePaymentService = onlinePaymentService;
	}
	
	public void processContract(Contract contract, int months) { //processar um contrato para gerar mensalidades - recebe um contrato e o numero de meses
		double basicQuota = contract.getTotalValue() / months; //valor por mes sem juros e taxas
        for (int i = 1; i <= months; i++) {
            Date date = addMonths(contract.getDate(), i); //adicionar i meses à data do contrato
            double updatedQuota = basicQuota + onlinePaymentService.interest(basicQuota, i); //valor do mes i com juro mensal
            double fullQuota =  updatedQuota + onlinePaymentService.paymentFee(updatedQuota); //VALOR FINAL DO MES i (com taxa de pagamento e juro mensal)
            
            Installment installment = new Installment(date, fullQuota); //criar uma mensalidade
            contract.addInstallment(installment); //adicionar a mensalidade arraylist installments
            
            //contract.addInstallment(new Installment(date, fullQuota)); //criar uma mensalidade e adicionando ao arraylist installments
        }
	}
	
	private Date addMonths(Date date, int n) { //adicionar i meses a uma data
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, n);
		return cal.getTime();
	}
}