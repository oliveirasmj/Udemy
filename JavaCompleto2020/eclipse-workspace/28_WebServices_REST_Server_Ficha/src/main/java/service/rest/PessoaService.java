package service.rest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import entities.Atividade;
import entities.Atividades;
import entities.Pessoa;

@Path("/person")
public class PessoaService {

	// Utilizadores
	static Pessoa p1 = new Pessoa(1, "Miguel", 26);
	static Pessoa p2 = new Pessoa(2, "Ana", 20);
	static Pessoa p3 = new Pessoa(3, "Tiago", 28);
	// static List<Pessoa> allPessoas = Arrays.asList(p1, p2, p3);
	static List<Pessoa> allPessoas = new ArrayList<Pessoa>();
	static {
		allPessoas.add(p1);
		allPessoas.add(p2);
		allPessoas.add(p3);
	}

	// Atividades
	static Atividade a1 = new Atividade(10, "Atividade 1");
	static Atividade a2 = new Atividade(20, "Atividade 2");
	static Atividade a3 = new Atividade(30, "Atividade 3");
	static List<Atividade> allAtividades = Arrays.asList(a1, a2, a3);

	// Adicionar varias atividades a um utilizador
	static Atividades ats1 = new Atividades(p1);
	static {
		ats1.addAtividade(a1);
		ats1.addAtividade(a2);
		ats1.addAtividade(a3);
	}
	static List<Atividades> atividades = Arrays.asList(ats1);

	@GET
	@Path("/{id}/name")
	public String getName(@PathParam("id") int id) {
		for (Pessoa p : allPessoas) {
			if (p.getId() == id) {
				return p.getName().toString();
			}
		}
		return null;
	}

	@GET
	@Path("/{id}/age")
	public String getAge(@PathParam("id") int id) {
		for (Pessoa p : allPessoas) {
			if (p.getId() == id) {
				return p.getAge().toString();
			}
		}
		return null;
	}

	@GET
	@Path("/{id}")
	public Response getPessoa(@PathParam("id") int id) {
		for (Pessoa p : allPessoas) {
			if (p.getId() == id) {
				Gson gson = new Gson();
				String jsonResp = gson.toJson(p);
				return Response.ok(jsonResp, MediaType.APPLICATION_JSON).build();
			}
		}
		return null;
	}

	@GET
	@Path("/{id}/activity/{idact}")
	public Response getAtividades(@PathParam("id") int id, @PathParam("idact") int idact) {
		for (Atividades a : atividades) {
			if (a.getPessoa().getId() == id) { // listar todas atividades daquela pessoa
				for (Atividade b : allAtividades) {
					if (b.getIdActivity() == idact) { // mas apenas com aquele id de atividade
						Gson gson = new Gson();
						String jsonResp = gson.toJson(b);
						return Response.ok(jsonResp, MediaType.APPLICATION_JSON).build();
					}
				}
			}
		}
		return null;
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON) // vai ler json
	@Produces(MediaType.APPLICATION_JSON) // vai produzir json
	@Path("/update/{id}")
	public Response updatePessoa(@PathParam("id") int id, String jsonFromUrl) { // jsonFromUrl: o que vai no body
		Gson g = new Gson();
		Pessoa updatedPerson = g.fromJson(jsonFromUrl, Pessoa.class); // colocar jsonFromUrl numa variavel
		for (Pessoa p : allPessoas) {
			if (p.getId() == id) {
				// atualizar pessoa pelo jsonFromUrl
				p.setName(updatedPerson.getName());
				p.setAge(updatedPerson.getAge());
				// colocar pessoa para String
				String jsonResp = g.toJson(p.toString());
				// Retornar json
				return Response.ok(jsonResp).build();
			}
		}
		return Response.status(400).type(MediaType.APPLICATION_JSON).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/newPerson")
	public Response addPerson(String newPerson) {
		Gson g = new Gson();
		Pessoa newPersson = g.fromJson(newPerson, Pessoa.class);
		Pessoa np = new Pessoa(newPersson.getId(), newPersson.getName(), newPersson.getAge());
		allPessoas.add(np);
		String jsonResp = g.toJson(allPessoas);
		return Response.ok(jsonResp).build();
	}

	@DELETE
	@Path("/delete/{id}")
	public Response deletePerson(@PathParam("id") int id) {
		Gson g = new Gson();

		for(int i=0; i<allPessoas.size(); i++) {
			if (allPessoas.get(i).getId() == id) {
				allPessoas.remove(i);
			}
		}
			
		String jsonResp = g.toJson(allPessoas);
		return Response.ok(jsonResp).build();
	}
	
	@DELETE
	@Path("/deleteAllActivities/{id}")
	public Response deleteAllActivities(@PathParam("id") int id) {
		Gson g = new Gson();

		for (Atividades a : atividades) {
			if (a.getPessoa().getId() == id) { // listar todas atividades daquela pessoa
				for (int i=0; i<allAtividades.size(); i++) {
					allAtividades.remove(i);
				}
			}
		}
		
		//String jsonResp = g.toJson(atividades);
		return Response.ok("Eliminadas").build();
	}

}
