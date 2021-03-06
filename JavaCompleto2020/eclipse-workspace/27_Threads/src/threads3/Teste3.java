package threads3;

public class Teste3 {

	public static void main(String[] args) {

		MinhaThreadRunnable thread1 = new MinhaThreadRunnable("Thread #1", 500); // executar Thread e dormir por 1000ms
		Thread t1 = new Thread(thread1); // iniciar a thread - podemos colocar no construtor para ser AUTOMATICO
		t1.start(); // iniciar a thread - podemos colocar no construtor para ser AUTOMATICO

		MinhaThreadRunnable thread2 = new MinhaThreadRunnable("Thread #2", 500); // executar Thread e dormir por 200ms
		Thread t2 = new Thread(thread2); // iniciar a thread - podemos colocar no construtor para ser AUTOMATICO
		t2.start(); // iniciar a thread - podemos colocar no construtor para ser AUTOMATICO

		MinhaThreadRunnable thread3 = new MinhaThreadRunnable("Thread #3", 500); // executar Thread e dormir por 200ms
		Thread t3 = new Thread(thread3); // iniciar a thread - podemos colocar no construtor para ser AUTOMATICO
		t3.start(); // iniciar a thread - podemos colocar no construtor para ser AUTOMATICO

		
		while (t1.isAlive() || t2.isAlive() || t3.isAlive()) //enquanto as threads estiverem vivas
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		System.out.println("Programa finalizado");
	}

}
