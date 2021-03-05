package aula181_FileScanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		//File - Representação abstrata de um arquivo e seu caminho
		
		File file = new File("C:\\Git\\Java_Course\\JavaCompleto2020\\17_Arquivos\\in.txt"); //criar objeto do tipo file passando o caminho
		Scanner sc = null;
		
		try { 										//é preciso try porque o programa vai tentar abrir o arquivo
			sc = new Scanner(file); 				//instanciar scanner a partir do arquivo
			while(sc.hasNextLine())	{				//enquanto existir proxima linha
				System.out.println(sc.nextLine());	//imprimir a linha
			}
			//sc.close();							//não é bom colocar sc.close aqui porque se for lançada uma excepção o scanner não é fechado
		} 
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		finally {
			if(sc != null) { //apenas se tiver sido instanciado fechar do scanner
				sc.close();
			}
		}
	}
}
