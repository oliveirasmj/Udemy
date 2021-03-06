package threads5;

public class Teste5 {

	public static void main(String[] args) {

		MinhaThreadRunnable thread1 = new MinhaThreadRunnable("Thread #1", 500); // executar Thread e dormir por 1000ms
		MinhaThreadRunnable thread2 = new MinhaThreadRunnable("Thread #2", 500); // executar Thread e dormir por 200ms
		MinhaThreadRunnable thread3 = new MinhaThreadRunnable("Thread #3", 500); // executar Thread e dormir por 200ms
		
		Thread t1 = new Thread(thread1); // iniciar a thread - podemos colocar no construtor para ser AUTOMATICO
		Thread t2 = new Thread(thread2); // iniciar a thread - podemos colocar no construtor para ser AUTOMATICO
		Thread t3 = new Thread(thread3); // iniciar a thread - podemos colocar no construtor para ser AUTOMATICO

		t1.start(); // iniciar a thread - podemos colocar no construtor para ser AUTOMATICO
		t2.start(); // iniciar a thread - podemos colocar no construtor para ser AUTOMATICO
		t3.start(); // iniciar a thread - podemos colocar no construtor para ser AUTOMATICO
		
		//atribuir prioridades - valores de 1 a 10
		t1.setPriority(5); 
		t2.setPriority(3);
		t3.setPriority(1);
		
		try { //apenas depois de as 3 threads terminares o programa continua
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Programa finalizado");
	}

}
