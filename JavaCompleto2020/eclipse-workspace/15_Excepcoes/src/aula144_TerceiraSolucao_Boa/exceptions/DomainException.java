package aula144_TerceiraSolucao_Boa.exceptions;

public class DomainException extends Exception { // Exception - tem de tratar excepção com try catch ou throws ||| RuntimeException - não tem de ser tratada
	
	private static final long serialVersionUID = 1L; // isto é gerado automatico porque Exception é serialazable e necessita da versao
	public DomainException(String msg) {
		super(msg); // passar para o construtor da superclasse
	}
}
