package service.rest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import entities.Atividade;
import entities.Atividades;
import entities.Pessoa;

@Path("/person")
public class PessoaService {

	//Utilizadores
	static Pessoa p1 = new Pessoa(1, "Miguel", 26);
	static Pessoa p2 = new Pessoa(2, "Tiago", 22);
	static Pessoa p3 = new Pessoa(3, "Ana", 23);
	static List<Pessoa> pessoas = Arrays.asList(p1, p2, p3);
	
	//Atividades
	static Atividade a1 = new Atividade("Atividade 1");
	static Atividade a2 = new Atividade("Atividade 2");
	static Atividade a3 = new Atividade("Atividade 3");
	static List<Atividade> atividades = Arrays.asList(a1, a2, a3);
	
	//Adicionar varias atividades a um utilizador
	static Atividades ats1 = new Atividades(p1);
	static List<Atividade> atividadesAll = Arrays.asList(a1, a2, a3);

	@GET
	@Path("/{id}/name")
	public String getName(@PathParam("id") int id) {
		for(Pessoa p : pessoas) {
			if(p.getId() == id) {
				return pessoas.get(id).getName();
			}
		}
		return null;
	}
}
