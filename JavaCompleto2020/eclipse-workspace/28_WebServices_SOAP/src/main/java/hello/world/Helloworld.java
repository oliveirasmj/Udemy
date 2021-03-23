package hello.world;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public class Helloworld {
	
	@WebMethod
	public String sayHello(@WebParam(name="a") String name) { //"a": nome que vai para o exterior
		return "Hello " + name;
	}
	
	public static void main(String[] args) {
		Helloworld hw = new Helloworld();
		System.out.println(hw.sayHello("Mike"));
	}
}
