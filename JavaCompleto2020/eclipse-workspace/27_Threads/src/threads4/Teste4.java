package threads4;

public class Teste4 {

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
		//t1.join(200); // a thread t2 só vai iniciar quando a t1 acabar ou 200ms depois de ter iniciado
		
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
