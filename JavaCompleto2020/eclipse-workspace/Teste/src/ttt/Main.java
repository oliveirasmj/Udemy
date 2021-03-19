package ttt;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		List<Pessoa> pessoas = new ArrayList<>();
		Pessoa p1 = new Pessoa("Mike", 26);
		Pessoa p2 = new Pessoa("Ana", 20);
		Pessoa p3 = new Pessoa("Olga", 25);

		pessoas.add(p1);
		pessoas.add(p2);
		pessoas.add(p3);

//		//REMOVER OP1 - Ciclo for (listar até ao fim e remover)
//		for(int i=0; i<pessoas.size(); i++) {
//			if(pessoas.get(i).getName().equals("Olga")) {
//				pessoas.remove(i);
//			}
//		}

//		//REMOVER OP2 - Iterator(usado para remover e parar quando quiser)
//		ListIterator<Pessoa> it = pessoas.listIterator();
//		while(it.hasNext()){
//		    if(it.next().getName().equals("Olga")){
//		        it.remove();
//		        //break;
//		    }
//		}

		//Remover por index
		//pessoas.remove(0);
		System.out.println(pessoas.get(0));

		// LISTAR
		for (Pessoa p : pessoas) {
			System.out.println(p);
		}

		sc.close();
	}

}
