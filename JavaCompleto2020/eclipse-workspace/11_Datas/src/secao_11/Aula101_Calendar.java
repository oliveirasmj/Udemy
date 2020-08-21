package secao_11;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

public class Aula101_Calendar {

	public static void main(String[] args) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//		Date d = Date.from(Instant.parse("2018-06-25T15:42:07Z")); //Horario UTC
		Date d = new Date(); //Data atual
		System.out.println(sdf.format(d));
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(d); //calendario com a data d instanciada
		
		cal.add(Calendar.HOUR_OF_DAY, 4); //Acrescentar 4 horas à hora que estava no calendario
		d = cal.getTime(); //atualizar variavel d com a nova hora
		System.out.println(sdf.format(d));
		
		//saber os minutos da data
		int minutes = cal.get(Calendar.MINUTE);
		System.out.println("Minutos da hora: " + minutes);
		
		//saber o mês da data
		int month = cal.get(Calendar.MONTH);
		System.out.println("Mês da hora: " + month+1); //mes comeca em 0
		
	}

}
