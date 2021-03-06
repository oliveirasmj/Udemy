package threads2;

public class Teste2 {

	public static void main(String[] args) {
		
		MinhaThreadRunnable thread1 = new MinhaThreadRunnable("Thread #1", 1000); //executar Thread e dormir por 1000ms
		Thread t1 = new Thread(thread1); //iniciar a thread - podemos colocar no construtor para ser AUTOMATICO
		t1.start(); //iniciar a thread - podemos colocar no construtor para ser AUTOMATICO
		
		MinhaThreadRunnable thread2 = new MinhaThreadRunnable("Thread #2", 200); //executar Thread e dormir por 200ms
		Thread t2 = new Thread(thread2); //iniciar a thread - podemos colocar no construtor para ser AUTOMATICO
		t2.start(); //iniciar a thread - podemos colocar no construtor para ser AUTOMATICO
	}

}
