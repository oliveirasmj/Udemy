package secao_11;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.TimeZone;

public class Aula100_Datas {
	
	public static void main(String[] args) throws ParseException {
		//Declaração e instanciação do objecto
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); sdf3.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		Date x1 = new Date(); //instanciar uma nova data de agora
		Date x2 = new Date(System.currentTimeMillis()); //outra forma de instanciar uma nova data de agora
		Date x3 = new Date(0L); //hora mais antiga inicial - UTC - 1 Janeiro 1970 ----- 0L=0ms
		
		// 1 Janeiro 1970 05:00 
		Date x4 = new Date(1000L * 60L + 60L * 5L); // 1seg = 1000L | 1min = 1000L*60L | 1hora = 1000L*60L+60L| 1 Janeiro 1970 05:00 = 1000L*60L+60L*5L
		
		Date y1 = sdf1.parse("25/06/2018");
		Date y2 = sdf2.parse("25/06/2018 15:42:07");
//		Date y3 = Date.from(Instant.parse("2018-06-25T15:42:07Z")); //Horario UTC - Brasil
		
//		System.out.println(y1);
//		System.out.println(y2);
		
		System.out.println("---------------------------");
		System.out.println("x1: " + sdf2.format(x1));
		System.out.println("x2: " + sdf2.format(x2));
		System.out.println("x3: " + sdf2.format(x3));
		System.out.println("x4: " + sdf2.format(x4));
		System.out.println("y1: " + sdf2.format(y1));
		System.out.println("y2: " + sdf2.format(y2));
//		System.out.println("y3: " + sdf2.format(y3)); //hora errada porque está em UTC - Brasil
//		System.out.println("---------------------------");
//		System.out.println("y3: " + sdf3.format(y3)); //agora está certo - Brasil
		
	}
}
