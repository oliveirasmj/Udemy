package threads7;

public class TiqueTaque {

	boolean tique;

	synchronized void tique(boolean estaExecutando) {
		if (!estaExecutando) {
			tique = true;
			notify(); // notificar a outra thread
			return;
		}
		System.out.print("Tique ");
		tique = true;
		notify(); // notificar a outra thread

		try {
			while (tique) { // enquanto for true
				wait();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} // esperar

	}

	synchronized void taque(boolean estaExecutando) {
		if (!estaExecutando) {
			tique = false;
			notify(); // notificar a outra thread
			return;
		}
		System.out.println("Taque");
		tique = false;
		notify(); // notificar a outra thread

		try {
			while (!tique) { // enquanto for true
				wait();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} // esperar
	}
}
