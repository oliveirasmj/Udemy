package hello.server;

import javax.xml.ws.Endpoint;

import hello.world.DataHora;
import hello.world.Helloworld;
import hello.world.Matematica;

//criar projeto maven: https://www.simplilearn.com/tutorials/maven-tutorial/maven-project-in-eclipse

public class Server {

	public static void main(String[] args) {
		
		//Aceder pelo browser: http://127.0.0.1:9999/helloworld?wsdl
		Endpoint ep = Endpoint.create(new Helloworld());
		ep.publish("http://127.0.0.1:9999/helloworld");
		
		//Aceder pelo browser: http://127.0.0.1:9999/datahora?wsdl
		Endpoint ep2 = Endpoint.create(new DataHora());
		ep2.publish("http://127.0.0.1:9999/datahora");
		
		//Aceder pelo browser: http://127.0.0.1:9999/matematica?wsdl
		Endpoint ep3 = Endpoint.create(new Matematica());
		ep3.publish("http://127.0.0.1:9999/matematica");
		
	}
}
