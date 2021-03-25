package hello.world;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public class IMC {

	@WebMethod
	public String indice(@WebParam(name = "peso") double peso, @WebParam(name = "altura") double altura) {        
        
        double imc = peso/(altura*altura);
        String texto = "";
        
        if (imc < 18.5) {
            texto = "Abaixo do peso! ";
        }else if(imc >= 18.6 && imc <= 24.9){
        	texto = "Normal! ";
        }else if(imc >= 25 && imc <= 29.9){
        	texto = "Sobrepeso! ";
        }else{
        	texto = "Obeso! ";
        }
        
        texto += "Seu IMC é: " + String.format("%.2f", imc);
        return texto;
	}
	
	public static void main(String[] args) {
		IMC imc = new IMC();
		System.out.println(imc.indice(65, 1.72));
	}

}
