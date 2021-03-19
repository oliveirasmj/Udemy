package diversos.imutabilidade;

import java.util.Date;

public class MainImutabilidade {

	public static void main(String[] args) {
		
		SemImutabilidade si = new SemImutabilidade("ola");
		si.setLinha("TESTE");
        System.out.println("texto.getLinha() = " + si.getLinha());
        System.out.println("------------------------------");
        
        
		ComImutabilidade ci = new ComImutabilidade("ola");  //ComImutabilidade ci = ComImutabilidade.make();
		//ci.setLinha("TESTE");
        System.out.println("texto.getLinha() = " + ci.getLinha());
        System.out.println("------------------------------");
        
        
        ComImutabilidade2 ci2 = new ComImutabilidade2("ola", new Date());
		//ci.setLinha("TESTE");
        System.out.println("texto.getLinha() = " + ci2.getData());
        System.out.println("------------------------------");
	}

}
