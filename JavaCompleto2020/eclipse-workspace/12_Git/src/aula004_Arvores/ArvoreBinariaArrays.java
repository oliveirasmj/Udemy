/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula004_Arvores;

import java.util.ArrayList;

/**
 *
 * @author olive
 */
public class ArvoreBinariaArrays {

    private class No {

        public No fmenor, fmaior;
        public int valor;

        public No(int valor) {
            this.valor = valor;
            fmenor = null;
            fmaior = null;
        }

        public String toString() {
            return "" + this.valor;
        }
    }

    private No raiz;

    public ArvoreBinariaArrays() {
        raiz = null;
    }
    
    public void add (int valor){
        if( raiz == null){
            raiz = new No(valor);
            return;
        }
        add(raiz, valor);
    }
    
    private void add(No atual, int valor){
        if(valor == atual.valor){
            return;
        }
        if (valor < atual.valor){
            if(atual.fmenor == null){
                atual.fmenor = new No(valor);
            }else{
                add(atual.fmenor, valor);
            } if (valor > atual.valor){
                if(atual.fmaior == null){
                    atual.fmaior = new No(valor);
                }else{
                    add(atual.fmaior, valor);
                }
            }
        }
    }



    public boolean contains(int valor) {
        return contains(raiz, valor);
    }

    private boolean contains(No no, int valor) {
        if (no == null) {
            return false;
        }
        if (valor == no.valor) {
            return true;
        } else if (valor < no.valor) {
            return contains(no.fmenor, valor);
        } else {
            return contains(no.fmaior, valor);
        }
    }
    
    public boolean remove (int valor){
        if ( contains(valor) == true){
            raiz = remove(raiz, valor);
            return true;
        }else{
            return false;
        }
        
    }
    
    private No remove(No no, int valor){
        if(no == null){
            return null;
        }
        if ( valor < no.valor){
          no.fmenor = remove(no.fmenor, valor);  
        } if (valor > no.valor){
            no.fmaior = remove (no.fmaior, valor);
        }if (no.fmenor == null){
                //existe 1 filho à direita
                return no.fmaior;
                } if (no.fmaior == null){
                //existe um filho à esquerda
                return no.fmenor;
                }else{
                //nao tem filhos tanto à direita como à esquerda
                No aPromover = no.fmenor;
                while (aPromover.fmaior != null){
                aPromover = aPromover.fmaior;
                }
                no.valor = aPromover.valor;
                remove (no.fmenor, aPromover.valor);
                return no;
                }
    }
        
    
    public ArrayList<Integer> caminho(int origem, int destino){
        if (contains(origem) == false || contains(destino) == false){
            return null;
        }
        ArrayList<Integer> caminho1 = new ArrayList<>();
        ArrayList<Integer> caminho2 = new ArrayList<>();
        caminho1 = caminhoraiz(raiz, origem, caminho1);
        caminho2 = caminhoraiz(raiz, origem, caminho2);
        ArrayList<Integer> caminho = new ArrayList<>();
        int i = -1;
        do{
            i++;
            caminho.add(caminho1.get(i));
        }while (i < caminho1.size() && caminho2.contains(caminho1.get(i)));
        int j = caminho2.size() -1;
        while (j >= 0){
            if(caminho1.contains(caminho2.get(j))){
                caminho.add(caminho2.get(j));
            }
            j--;
        }
        return caminho;
    }
    
    private ArrayList<Integer> caminhoraiz(No no, int valor, ArrayList caminho){
        caminho.add(no.valor);
        if(valor < no.valor){
            caminhoraiz (no.fmenor, valor, caminho);
        } if (valor > no.valor){
            caminhoraiz (no.fmaior, valor, caminho);
        }
        ArrayList<Integer> caminhoraiz = new ArrayList<>();
        for (int i = caminho.size() -1; i>= 0; i--){
            caminhoraiz.add((Integer) caminho.get(i));
        }
        return caminhoraiz;
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        addToString(raiz, sb);
        return sb.toString();
    }
    
    private void addToString(No no, StringBuilder sb) {
        if (no == null) return;
        sb.append("("+no+","+no.fmenor+","+no.fmaior+")\n");
        addToString(no.fmenor, sb);
        addToString(no.fmaior, sb);
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        ArvoreBinariaArrays a = new ArvoreBinariaArrays();
        a.add(60);
        a.add(20);
        a.add(10);
        a.add(70);
        a.add(40);
        a.add(30);
        a.add(80);
        a.add(50);   
        //a.adiciona(35);
        //a.adiciona(65);
        System.out.println(a.toString());
        //a.remove(60);
        System.out.println(a);
    }
}
