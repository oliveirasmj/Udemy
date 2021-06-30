/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula001_Recursividade;

import static java.lang.Math.pow;
import java.util.Scanner;

/**
 *
 * @author mjfr
 */
public class Recursividade {

    public double fatorial(double n) {
        if(n == 0) return 1;
        return n*fatorial(n-1);
    }
    
    public int fibonacci(int n) {
        if (n==0) return 0;
        if (n==1) return 1;
        return fibonacci(n-1) + fibonacci(n-2);
    }
    
    public double seno(double x, int N) {
        if (N==1) return x;//resultado da fórmula para n=N-1=0
        return (pow(-1,N-1)*(pow(x,2*N-1))/(fatorial(2*N-1))) + seno(x,N-1);
    }
    
    public boolean capicua(char v[], int n) {
        if (v[n]!=v[v.length-(n+1)]) return false;//se caracteres diferentes então não é capicua
        if (n>=v.length-(n+1)) return true;//se chegamos ao fim do vetor então todas as letras eram iguais
        return capicua(v, n+1);//continuar processo
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
	//TODO iniciar a capicua
        Recursividade f = new Recursividade();
        //System.out.println("Qual o número? ");
        Scanner sc = new Scanner(System.in);
        //int n = sc.nextInt();
        //System.out.println("O fatorial de "+n+" é "+f.fatorial(n));
        //System.out.println("O Fibonacci de "+n+" é "+f.fibonacci(n));
        System.out.println("Número para calcular o seno ? ");
        double x = sc.nextDouble();
        System.out.println("Qual o N para o seno de "+x+"? ");
        int n = sc.nextInt();
        System.out.println("O seno de "+x+" é "+f.seno(x,n));
    }
    
}
