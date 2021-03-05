package aula182_FileReaderBufferedReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Program {

	public static void main(String[] args) { //Outra forma de ler o arquivo - FileReader ou BufferedReader
		//FileReader (stream de leitura de caracteres a partir de arquivos)
		//BufferedReader (mais rápido)
		
		String path = "C:\\Git\\Java_Course\\JavaCompleto2020\\17_Arquivos\\in.txt"; //caminho do arquivo
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(path); //instanciar filereader com o caminho do arquivo
			br = new BufferedReader(fr); //br = new BufferedReader(new FileReader(path))
			
			String line = br.readLine(); //se arquivo estiver no final é devolvido nulo
			
			while(line != null) { //enquanto nao estiver no final
				System.out.println(line); //escrever a linha
				line = br.readLine();	  //ler a linha
			}
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		//FORMA NAO COMUMs
		finally {
			try {
				if(br != null) {
					br.close();
				}
				if(fr != null) {
					fr.close();
				}
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
