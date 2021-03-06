package threads1;

public class Teste {

	public static void main(String[] args) {
		
		MinhaThread thread1 = new MinhaThread("Thread #1", 1000); //executar Thread e dormir por 1000ms
		thread1.start(); //iniciar a thread - podemos colocar no construtor para ser AUTOMATICO
		
		MinhaThread thread2 = new MinhaThread("Thread #2", 200); //executar Thread e dormir por 200ms
		thread2.start(); //iniciar a thread - podemos colocar no construtor para ser AUTOMATICO
		
	}

}
