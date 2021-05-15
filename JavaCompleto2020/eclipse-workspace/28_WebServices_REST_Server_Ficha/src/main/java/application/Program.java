package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import entities.Atividade;
import entities.Atividades;
import entities.Pessoa;

public class Program {

	public static void main(String[] args) {
		
		Pessoa p1 = new Pessoa(1, "Miguel", 26);
		Pessoa p2 = new Pessoa(2, "Tiago", 22);
		Pessoa p3 = new Pessoa(3, "Ana", 23);
		List<Pessoa> pessoas = Arrays.asList(p1, p2, p3);

		Atividade a1 = new Atividade(10, "Atividade 1");
		Atividade a2 = new Atividade(20, "Atividade 2");
		Atividade a3 = new Atividade(30, "Atividade 3");
		List<Atividade> atividade = Arrays.asList(a1, a2, a3);
		
	    //Adicionar varias atividades a um utilizador
	    Atividades ats1 = new Atividades(p1);
	    ats1.addAtividade(a1); ats1.addAtividade(a2); ats1.addAtividade(a3); //adicionar atividades
	    List<Atividades> atividades = Arrays.asList(ats1);
	    
	    //ats1.listarAtividades();
	}

}
