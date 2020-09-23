package aula207_HashCodeEquals;

public class Program {

	public static void main(String[] args) {
		
		String a = "Maria";
		String b = "Alex";
		
		System.out.println(a.equals(b)); //retorna false porque não são iguais
		
		System.out.println(a.hashCode()); //gera um código de 32bits para cada texto
		System.out.println(b.hashCode()); //gera um código de 32bits para cada texto
		//mas se os códigos forem iguais certamente os objetos são iguais
		//se forem diferentes há uma pequena probabiblidade de serem iguais
	}

}
