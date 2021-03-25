package hello.world.exercicio5;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

@WebService
public class Turma {
	
	private String nomeTurma;
	private List<Aluno> alunos = new ArrayList<Aluno>();

	public Turma(String nomeTurma) {
		this.nomeTurma = nomeTurma;
	}

	public String getNomeTurma() {
		return nomeTurma;
	}

	public void setNomeTurma(String nomeTurma) {
		this.nomeTurma = nomeTurma;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}
	
	public void adicionaAluno(String nome, int numero, String estatuto) {
		Aluno a = new Aluno(nome, numero, estatuto);
		alunos.add(a);
	}

	public void listaAlunos() {
		for(Aluno a : alunos) {
			System.out.println(a);
		}
	}
	
}
