package entities;

import java.util.ArrayList;
import java.util.List;

public class Atividades {
	
	private Pessoa pessoa;
	private List<Atividade> atividades = new ArrayList<Atividade>();
	

	public Atividades(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Atividade> getAtividades() {
		return atividades;
	}

	public void addPessoa(Atividade a) {
		atividades.add(a);
	}
	
	public void listarAtividades() {
		System.out.println("Nome: " + pessoa.getName() + " - ID: " + pessoa.getId());
		for(Atividade a : atividades) {
			System.out.println(" - " + a.getNameActivity());
		}
	}
	
}
