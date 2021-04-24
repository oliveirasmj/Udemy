package application;

import entities.Atividade;
import entities.Atividades;
import entities.Pessoa;

public class Program {

	public static void main(String[] args) {
		
		Pessoa p1 = new Pessoa(1, "Miguel", 26);
		Pessoa p2 = new Pessoa(2, "Tiago", 22);
		Pessoa p3 = new Pessoa(3, "Ana", 23);

		Atividade a1 = new Atividade("Atividade 1");
		Atividade a2 = new Atividade("Atividade 2");
		Atividade a3 = new Atividade("Atividade 3");
		
		Atividades ats1 = new Atividades(p1);
		ats1.addPessoa(a1);
		ats1.addPessoa(a2);
		ats1.addPessoa(a3);
		
		ats1.listarAtividades();
	}

}
