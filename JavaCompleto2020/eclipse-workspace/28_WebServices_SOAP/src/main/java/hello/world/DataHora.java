package hello.world;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public class DataHora {

	//	@WebMethod
	//	public String sayDataHora(String form) {
	//		DateFormat formato = new SimpleDateFormat("HH:mm:ss");
	//		String formattedDate = formato.format(new Date());
	//		return formattedDate;
	//	}

	@WebMethod
	public String sayDataHora(@WebParam(name = "a") String form) {
		// DateFormat formato = new SimpleDateFormat("HH:mm:ss");
		DateFormat formato = new SimpleDateFormat(form);
		String formattedDate = formato.format(new Date());
		return formattedDate;
	}

	public static void main(String[] args) {
		DataHora dh = new DataHora();
		// System.out.println(dh.sayDataHora());
		System.out.println(dh.sayDataHora("HH:mm:ss"));
	}
}
