/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula005_Ordenacao;

import java.util.Arrays;

/**
 *
 * @author olive
 */
public class Ordenacao {

    private void troca(int[] v, int indexA, int indexB) {
        int aux = v[indexA];
        v[indexA] = v[indexB];
        v[indexB] = aux;
    }
        
    public void bubbleSort(int[] v) {
        int k = v.length;
        boolean houveTroca = false;
        int i = 0;
        do {
            houveTroca = false;
            k = k - 1;
            i = 0;
            while (i < k) {
                if (v[i] > v[i + 1]) { //trocar o sinal de quiser ordem descrescente
                    //troca(v[i], v[i + 1]);
                    troca(v, i, i + 1); //trocar elemento i com elemento i+1
                    houveTroca = true;
                }
                i++;
            }
        } while (houveTroca);
    }
    
    public void insertSort(int[] v) {
        int i = 1;
        int valor;
        int j;
        while (i < v.length) {
            valor = v[i];
            j = i -1;
            while (j >= 0 && v[j] > valor) { //descrescente trocar o 2º sinal (j >= 0 && v[j] < valor)
                v[j+1] = v[j];
                j--;
            }
            v[j+1] = valor;
            i++;
        }
    }
    
    public void quicksort(int[] A, int p, int r) {
        //System.out.println("p="+p+" r="+r+" vetor="+Arrays.toString(A));
        if (p < r) {
            int q = particao(A, p, r);
            //System.out.println("\tparticao em q="+q);
            quicksort(A, p, q);
            quicksort(A, q+1, r);
        }
    }
    
    private int particao(int[] A, int p, int r) {
        int x = A[p]; //elemento do vector A na posição p
        int i = p - 1; //contador
        int j = r + 1; //contador
        boolean continua = true;
        while (continua) {
            do {
                j=j-1;
            } while (A[j] > x); //descrescente trocar sinal
            do {
                i=i+1;
            } while (A[i] < x); //descrescente trocar sinal
            if (i < j) {
                troca(A, i, j);
            } else {
                continua = false;
            }
        }
        return j;
    }
    
    public int[] mergesort(int[] A) {
        //Critério de paragem
        if (A.length < 2) {
            return A;
        }
        //Divisão
        int meio = A.length / 2 - 1;
        int[] esquerda = new int[ meio + 1];
        int[] direita = new int[ A.length - esquerda.length];
        int i = 0;
        while (i < esquerda.length) {
            esquerda[i] = A[i];
            i++;
        }
        i=0;
        while(i < direita.length) {
            direita[i] = A[i + esquerda.length];
            i++;
        }
        //Conquista
        esquerda = mergesort(esquerda);
        direita = mergesort(direita);
        //Combinação
        int[] resultado = new int[esquerda.length + direita.length];
        if (esquerda[esquerda.length-1] > direita[0])
            resultado = merge(esquerda, direita);
        else
            resultado = adiciona(esquerda, direita);
        
        return resultado;
    }
    
    private int[] merge(int[] esquerda, int[] direita) {
        //System.out.print("Merge de "+Arrays.toString(esquerda)+" com "+Arrays.toString(direita)+"...  ");
        int[] R = new int[esquerda.length + direita.length];
        int k = 0;
        int i = 0;
        int j = 0;
        while (k < R.length) {
            if (i < esquerda.length) {
                if (j < direita.length) {
                    if (esquerda[i] < direita[j]) {
                        R[k] = esquerda[i];
                        i++;
                    } else {
                        R[k] = direita[j];
                        j++;
                    }
                } else {
                    R[k] = esquerda[i];
                    i++;
                }
            } else {
                R[k] = direita[j];
                j++;
            }
            k++;
        }
        //System.out.println("Resultado = "+Arrays.toString(R));
        return R;
    }

    private int[] adiciona(int[] esquerda, int[] direita) {
        //System.out.print("Adiciona "+Arrays.toString(esquerda)+" com "+Arrays.toString(direita)+"...  ");
        int[] R = new int[esquerda.length + direita.length];
        int i = 0;
        while (i < esquerda.length) {
            R[i] = esquerda[i];
            i++;
        }
        i=0;
        while (i < direita.length) {
            R[i + esquerda.length] = direita[i];
            i++;
        }
        //System.out.println("Resultado = "+Arrays.toString(R));
        return R;
    }
    
    public void heapsort(int[] A) {
        constroiHeapMaximo(A);
        int i = A.length - 1;
        while (i > 1) {
            troca(A, i, 0);
            heapMaximo(A, 0, i);
            i--;
        }
        troca(A, 1, 0);
    }
    
    private void constroiHeapMaximo(int[] A) {
        int i = A.length/ 2 - 1;
        while (i >= 0) {
            heapMaximo(A, i, A.length);
            i--;
        }
    }

    private void heapMaximo(int[] A, int pos, int n) {
        //System.out.println("heapMaximo pos="+pos+" n="+n+" de "+Arrays.toString(A));
        int max = 2 * pos + 1;
        int d = max + 1;
        if (max < n) {
            if (d < n && A[max] < A[d]) {
                max = d;
            }
            if (A[max] > A[pos]) {
                //System.out.println("\ttroca indice "+max+"  com indice "+pos);
                troca(A, max, pos);
                heapMaximo(A, max, n);
            }
        }
        //System.out.println();
    }



    public static void main(String[] args) {
        Ordenacao ord = new Ordenacao();
        int[] a = {5, 10, 3, 8, 9, 4, 1, 11};
        System.out.println("Original: " + Arrays.toString(a));
        
        //BubbleSort
        ord.bubbleSort(a);
        System.out.println("BubbleSort: " + Arrays.toString(a));
        
        //InsertionSort
        ord.insertSort(a);
        System.out.println("InsertionSort: " + Arrays.toString(a));
        
        //QuickSort
        ord.quicksort(a, 0, 7);
        System.out.println("QuickSort: " + Arrays.toString(a));
        
        //MergeSort
        ord.mergesort(a);
        System.out.println("MergeSort: " + Arrays.toString(a));
        
        //HeapSort
        ord.heapsort(a);
        System.out.println("HeapSort: " + Arrays.toString(a));
    }

}
