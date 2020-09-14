package aula184_FileWriterBufferedWriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Program {

	public static void main(String[] args) { //Classe para gerar um arquivo
		
		String[] lines = new String[] { "Good morning", "Good afternoon", "Good night" };
		String path = "C:\\Users\\luisp\\Downloads\\Estudo\\Udemy\\JavaCompleto2020\\17_Arquivos\\out.txt"; // caminho final para o arquivo
		
		//try(BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) { //true - indicar que não é para recriar arquivo
			for(String line : lines) { 	//para cada linha do array
				bw.write(line); 		//escrever na linha o texto da posicao do array
				bw.newLine(); 			//dar quebra de linha
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
