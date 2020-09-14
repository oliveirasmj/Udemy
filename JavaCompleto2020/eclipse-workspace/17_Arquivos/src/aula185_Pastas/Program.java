package aula185_Pastas;

import java.io.File;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a folder path: ");
		String strPath = sc.nextLine();
		File path = new File(strPath); //criar variavel do tipo File e instanciar com o caminho
		
		File[] folders = path.listFiles(File::isDirectory); //guardar num vetor de files todos os caminhos que são diretorios
		System.out.println("FOLDERS:");
		for(File folder : folders) {
			System.out.println(folder);
		}
		
		File[] files = path.listFiles(File::isFile); //guardar num vetor de files todos os caminhos que são ficheiros
		System.out.println("FILES:");
		for(File file : files) {
			System.out.println(file);
		}
		
		boolean success = new File(strPath + "\\subdir").mkdir(); //criar um diretorio e se for criado com sucesso devolver true
		System.out.println("Directory created successfully: " + success);
	}

}
