package aula212_ExercicioFixacao.application;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import aula212_ExercicioFixacao.entities.Student;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Set<Student> courseA = new HashSet<>();
		Set<Student> courseB = new HashSet<>();
		Set<Student> courseC = new HashSet<>();

		System.out.print("How many students for course A? ");
		int alunos = sc.nextInt();
		for (int i = 1; i <= alunos; i++) {
			int matricula = sc.nextInt();
			courseA.add(new Student(matricula));
		}
		
		System.out.print("How many students for course B? ");
		alunos = sc.nextInt();
		for (int i = 1; i <= alunos; i++) {
			int matricula = sc.nextInt();
			courseB.add(new Student(matricula));
		}
		
		System.out.print("How many students for course C? ");
		alunos = sc.nextInt();
		for (int i = 1; i <= alunos; i++) {
			int matricula = sc.nextInt();
			courseC.add(new Student(matricula));
		}
		
		Set<Student> total = new HashSet<>(courseA);
		total.addAll(courseB);
		total.addAll(courseC);

		System.out.println("Total students: " + total.size());

		sc.close();
	}

}
