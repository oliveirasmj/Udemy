package threads6;

public class Teste {

	public static void main(String[] args) {

		int[] array = {1, 2, 3, 4, 5}; //Soma tem de dar 15
		int[] array2 = {1, 2, 3, 4, 5}; //Soma tem de dar 15
		
		MinhaThreadSoma thread1 = new MinhaThreadSoma("#1", array);
		Thread t = new Thread(thread1);
		t.start();
		
		MinhaThreadSoma thread2 = new MinhaThreadSoma("#2", array2);
		Thread t2 = new Thread(thread2);
		t2.start();
	}

}
