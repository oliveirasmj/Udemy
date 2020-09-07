package aula140_Finally;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		File file = new File("C:\\temp\\in.txt"); //iniciar uma variavel do tipo File (classe do Java.io) com caminho do arquivo
		Scanner sc = null; //iniciar o scanner
		try {
			sc = new Scanner(file); //instanciar scanner e apontá-lo para o caminho - se nao existir vai ser lançada excepção de arquivo nao encontrado
			while (sc.hasNextLine()) { //percorrer o arquivo
				System.out.println(sc.nextLine()); //imprimir na tela linha a linha
			}
			
		} catch (FileNotFoundException e) { //caso arquivo nao exista
			System.out.println("Error opening file: " + e.getMessage());
			
		} finally { //é sempre executado
			if (sc != null) {
				sc.close(); // é sempre preciso fechar o arquivo independentemente de haver ou não excepção
			}
			System.out.println("O arquivo foi fechado");
		}
	}

}
