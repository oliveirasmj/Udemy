package aula183_TryWithResources;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Program {

	public static void main(String[] args) { //Classe para ler arquivo com FileReader
		
		// Bloco try-with-resources - é um bloco try que declara recursos e garante que eles serão fechados no final(não é preciso fecho manual)
		
		String path = "C:\\Git\\Java_Course\\JavaCompleto2020\\17_Arquivos\\in.txt"; // caminho do arquivo

		try(BufferedReader br = new BufferedReader(new FileReader(path))) { //Não é preciso mais declarações a seguir
			
			String line = br.readLine(); // se arquivo estiver no final é devolvido nulo
			while (line != null) { // enquanto nao estiver no final
				System.out.println(line); // escrever a linha
				line = br.readLine(); // ler a linha e quebra
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		//Não é preciso mais o finally
	}

}
