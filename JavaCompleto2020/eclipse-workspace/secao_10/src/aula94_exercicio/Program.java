package aula94_exercicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		List<Empregado> list = new ArrayList<>();

		System.out.print("How many employees be registered? ");
		int num = sc.nextInt();
		sc.nextLine();
		
		//declaracao da classe
		Empregado empregado=null;
		
		//Ler os dados
		for (int i = 0; i < num; i++) {
			System.out.println("Emplyoee #" + (i+1));
			
			System.out.print("Id: ");
			int id = sc.nextInt();
			
			//ver se id já existe esse id - atraves do metodo criado abaixo
			while (hasId(list, id)!=-1) {
				System.out.println("Id already taken! Try again: ");
				id = sc.nextInt();
			}
//			//Outra forma com outro método - ver se já existe esse id
//			while (hasId2(list, id)) { //se retornar true --> hasId2(list, id)==true
//				System.out.println("Id already taken! Try again: ");
//				id = sc.nextInt();
//			}
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Salary: ");
			double salary = sc.nextDouble();

			empregado = new Empregado(id, name, salary);
			list.add(empregado); //adicionar à lista list
		}
		
		//Aumentar o salário de um funcionario
		System.out.println();
		System.out.print("Enter the employee id that will have salary increase: ");
		int idAumentar = sc.nextInt(); sc.nextLine();
		
		// Ver se existe id senao retorna -1
		int pos = hasId(list, idAumentar);
		if(pos == -1) {
			System.out.println("This id does not exist!");
		} else {
			System.out.println("Enter the percentage: ");
			double percentagem = sc.nextDouble();
			empregado.Aumentar(percentagem); //aumentar o funcionario
		}
		
//		// Outra forma com outro método - ver se existe id, se nao existir retorna nulo
//		empregado = list.stream().filter(x -> x.getId() == idAumentar).findFirst().orElse(null); 
//		if (empregado == null) {
//			System.out.println("This id does not exist!");
//		} else {
//			System.out.println("Enter the percentage: ");
//			double percentagem = sc.nextDouble();
//			empregado.Aumentar(percentagem);
//		}

		//Imprimir lista
		System.out.println();
		for (Empregado obj : list) {
			System.out.println(obj);
		}

		sc.close();
	}

	//metodo para ver se já existe id
	public static int hasId(List<Empregado> list, int id) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == id) {
				return i;
			}
		}
		return -1;
	}
	
//	//Outra forma com outro método - metodo para ver se já existe id
//	public static boolean hasId2(List<Empregado> list, int id) {
//		Empregado empregado = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null); //se id não existir retorna nulo
//			//1 - cria um empregado --> Empregado empregado
//			//2 - converter a lista para stream(para aceitar lambda) --> list.stream()
//			//3 - operacao lamda(predicado) --> filter(x -> x.getId() == id) - vê se é igual ao id
//			//4 - retorna o primeiro ou nulo --> x -> x.getId() == id
//		return empregado != null; //retorna se for diferente de nulo - ou seja retorna se id for igual
//	}

}
