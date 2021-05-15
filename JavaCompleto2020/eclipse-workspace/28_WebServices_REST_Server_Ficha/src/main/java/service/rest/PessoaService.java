package service.rest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import entities.Atividade;
import entities.Atividades;
import entities.Pessoa;

@Path("/person")
public class PessoaService {

	//Utilizadores
	static Pessoa p1 = new Pessoa(1, "Miguel", 26);
	static Pessoa p2 = new Pessoa(2, "Ana", 20);
	static Pessoa p3 = new Pessoa(3, "Tiago", 28);
	static List<Pessoa> allPessoas = Arrays.asList(p1, p2, p3);
	
	//Atividades
	static Atividade a1 = new Atividade(10, "Atividade 1");
	static Atividade a2 = new Atividade(20, "Atividade 2");
	static Atividade a3 = new Atividade(30, "Atividade 3");
	static List<Atividade> allAtividades = Arrays.asList(a1, a2, a3);
	
    //Adicionar varias atividades a um utilizador
    static Atividades ats1 = new Atividades(p1);
    static{ ats1.addAtividade(a1); ats1.addAtividade(a2); ats1.addAtividade(a3); }
    static List<Atividades> atividades = Arrays.asList(ats1);

	@GET
	@Path("/{id}/name")
	public String getName(@PathParam("id") int id) {
		for(Pessoa p : allPessoas) {
			if(p.getId() == id) {
				return p.getName().toString();
			}
		}
		return null;
	}
	
//	@GET
//	@Path("/names")
//	public String getName() {
//		StringBuilder str = new StringBuilder();
//		for(Pessoa p : allPessoas) {
//			str.append(p.toString());
//		}
//		return str.toString();
//	}
	
	@GET
	@Path("/{id}/age")
	public String getAge(@PathParam("id") int id) {
		for(Pessoa p : allPessoas) {
			if(p.getId() == id) {
				return p.getAge().toString();
			}
		}
		return null;
	}
	
	@GET
    @Path("/{id}")
    public Response getPessoa(@PathParam("id") int id) {
        for(Pessoa p : allPessoas){
            if(p.getId() == id){
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
	    for(Atividades a : atividades) {
	    	if(a.getPessoa().getId() == id) { //listar todas atividades daquela pessoa
	    		for(Atividade b : allAtividades) {
	    			if(b.getIdActivity() == idact) { //mas apenas com aquele id de atividade
	    				Gson gson = new Gson();
	    				String jsonResp = gson.toJson(b); 
	    				return Response.ok(jsonResp, MediaType.APPLICATION_JSON).build();
	    			}
	    		}
	    	}
	    }
        return null;
    }
}
