package service.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("7helloworld")
public class Helloworld {
	
	@GET
	@Path("/hello")
	public String hello() {
		return ("Hello");
	}
	
	@GET
	@Path("/hello/{name}")
	public String hello(@PathParam("name") String nome) {
		return ("Hello " + nome + "!");
	}
}
