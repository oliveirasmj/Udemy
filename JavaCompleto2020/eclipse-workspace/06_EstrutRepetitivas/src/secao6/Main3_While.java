package secao6;

import java.util.Scanner;

public class Main3_While {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int somaAlcool=0, somaGasolina=0, somaDiesel=0;
		
		while (x!=4) {
			if(x==1) {
				somaAlcool+=1;
			} else if(x==2){
				somaGasolina+=1;
			} else if(x==3){
				somaDiesel+=1;
			}
			
			//ler novamente variaveis
			x = sc.nextInt();
		}
		
		System.out.println("MUITO OBRIGADO");
		System.out.println("Alcool: " + somaAlcool);
		System.out.println("Gasolina: " + somaGasolina);
		System.out.println("Diesel: " + somaDiesel);
		sc.close();
	}

}
