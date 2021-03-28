package client.hello;

public class Client {

	public static void main(String[] args) {
		
		HelloworldService hws = new HelloworldService();
		Helloworld hw = hws.getHelloworldPort();
		System.out.println(hw.sayHello("Mike"));
	}

}
