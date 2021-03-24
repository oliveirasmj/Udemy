package hello.world;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public class Matematica {

	@WebMethod
	public int fatorial(@WebParam(name = "a") int n) {
		if (n == 0) { // se n=0 retorna 0
			return 1;
		}
		return n * fatorial(n - 1); // caso contrario, metodo recursivo
	}

	@WebMethod
	public int maiorPrimo(@WebParam(name="a") int a, @WebParam(name="b") int b) {
		int soma = 0, maior = 0;
		for (int i = a; i <= b; i++) {
			if (i % 1 == 0 && i % i == 0) { // se tiver os dois divisiveis
				soma = 0;
				for (int j = 1; j <= 20; j++) {
					if (i % j == 0) { // verificar se tem mais do que 2 divisiveis
						soma++;
					}
				}
				if (soma == 2) { // se tiver apenas os 2 divisores
					maior = i;
				}
			}
		}
		return maior;
	}
	
	@WebMethod
	public int menorPrimo(@WebParam(name="a") int a, @WebParam(name="b") int b) {
		int soma = 0, menor = 0;
		for (int i = a; i <= b; i++) {
			if (i % 1 == 0 && i % i == 0) { // se tiver os dois divisiveis
				soma = 0;
				for (int j = 1; j <= 20; j++) {
					if (i % j == 0) { // verificar se tem mais do que 2 divisiveis
						soma++;
					}
				}
				if (soma == 2) { // se tiver apenas os 2 divisores
					menor = i;
					return menor;
				}
			}
		}
		return 0;
	}

	@WebMethod
	public int soma(@WebParam(name="a") int a, @WebParam(name="b") int b) {
		int soma = 0;
		for (int i = a; i <= b; i++) {
			soma += i;
		}
		return soma;
	}
	
	public static void main(String[] args) {
		Matematica m = new Matematica();
		System.out.println(m.fatorial(5));
		System.out.println(m.maiorPrimo(1, 20));
		System.out.println(m.menorPrimo(12, 29));
		System.out.println(m.soma(1, 5));
	}

}
