/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula004_Arvores;

/**
 *
 * @author mjfr
 */
public class ArvoreBinaria {

      private static class No {
        public No fesq, fdir;
        public int valor;
        public No(int valor) {
            this.valor = valor;
            fesq = null;
            fdir = null;
        }
        public String toString() {
            return ""+this.valor;
        }
    }
    
    private No raiz;
    
    public ArvoreBinaria() {
        raiz = null;
    }
    
    public void adiciona(int valor) {
        if (raiz == null) {
            raiz = new No(valor);
            return;
        }
        adiciona(raiz, valor);
    }
    
    private void adiciona(No atual, int valor) {
        if (valor == atual.valor)
            return;
        if (valor < atual.valor) {
            if (atual.fesq == null) {
                atual.fesq = new No(valor);
            } else {
                adiciona(atual.fesq, valor);
            }
        } else {
            if (atual.fdir == null) {
                atual.fdir = new No(valor);
            } else {
                adiciona(atual.fdir, valor);
            }
        }
    }
    
    /*public void adiciona(int valor) {
        No novoNo = new No(valor); 
        //se árvore fazia, criar raiz
        if (raiz == null) {
            raiz = novoNo;
            return;
        }
        //caso contrário, procurar onde inserir
        No atual = raiz;
        while(true) {// e recursividade?
            if (atual.valor > novoNo.valor) {
                if (atual.fesq == null) {
                    atual.fesq = novoNo;
                    break;
                } else {
                    atual = atual.fesq;
                }
            }
            //...
        }
    }*/
    
    
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        addToString(raiz, sb);
        return sb.toString();
    }
    
    private void addToString(No no, StringBuilder sb) {
        if (no == null) return;
        sb.append("("+no+","+no.fesq+","+no.fdir+")\n");
        addToString(no.fesq, sb);
        addToString(no.fdir, sb);
    }
    
    public boolean existe(int valor) {
        return existe(raiz, valor);
    }
    
    private boolean existe(No no, int valor) {
        if (no == null) return false;
        if (valor == no.valor) return true;
        if (valor < no.valor) return existe(no.fesq, valor);
        else return existe(no.fdir, valor);
    }
    
    public int nivel(int valor) {
        return nivel(raiz, valor);
    }
    
    private int nivel(No no, int valor) {
        int n;
        if (no == null) return -1;
        if (valor == no.valor) return 0;
        n = valor < no.valor ? nivel(no.fesq, valor) : nivel(no.fdir, valor);
        return n == -1 ? -1 : 1 + n;
        /*if (valor < no.valor) {
            n = nivel(no.fesq, valor);
        } else {
            n = nivel(no.fdir, valor);
        }*/
        //if (n == -1) return -1;
        //else return 1 + n;
    }
    
    public int altura() {
        return altura(raiz);
    }
    
    public No findMax(No no) {
        //o max é sempre à direita
        while (no.fdir != null) {
            no = no.fdir;
        }
        return no;
    }
    
    public No findMin(No no) {
        //o min é sempre à esquerda
        while (no.fesq != null){
            no = no.fesq;
        }
        return no;
    }
    
    /***
     * Devolve o Pai do nó mínimo
     */
    public No findPaiMin(No no) {
        No pai = null;
        //o min é sempre à esquerda
        while (no.fesq != null){
            pai = no;
            no = no.fesq;
        }
        return pai;
    }
    
    
    private int altura(No no) {
        if (no == null) return -1;
        int alturaEsq = altura(no.fesq);
        int alturaDir = altura(no.fdir);
        return 1 + (alturaEsq < alturaDir ? alturaEsq : alturaDir);
    }
    
    /**
     * 
     */
    public void remove(int valor) {
        raiz = remove(raiz, valor);
    }
    
    private No remove(No atual, int valor) {
        if (atual == null)//percorrermos a árvore e não encontrámos o nó
            return null;
        if (valor < atual.valor) {//navegação na árvore
            atual.fesq = remove(atual.fesq, valor);
            return atual;
        } else if (valor > atual.valor) {
            atual.fdir = remove(atual.fdir, valor);
            return atual;
        } 
        //afinal estamos no nó a ser eliminado
        // (atual.valor == valor)
        if (atual.fdir == null) {
            return atual.fesq;
        } else if (atual.fesq == null) {
            return atual.fdir;
        } else {//caso com 2 filhos, ver a seguir
            No aPromover = atual.fesq;
            while (aPromover.fdir != null) {
                aPromover = aPromover.fdir;
            }
            atual.valor = aPromover.valor;//substituimos o conteudo do atual
            atual.fesq = remove(atual.fesq, aPromover.valor);
            return atual;
        }
        
    }
    
    private int contaNos (No node) {
        if (node == null) return 0;
        return contaNos(node.fesq) + contaNos(node.fdir) + 1;
    }
    
    public int contaNos() {
        return contaNos(raiz);
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArvoreBinaria a = new ArvoreBinaria();
        a.adiciona(60);
        a.adiciona(20);
        a.adiciona(10);
        a.adiciona(70);
        a.adiciona(40);
        a.adiciona(30);
        a.adiciona(80);
        a.adiciona(50);   
        //a.adiciona(35);
        //a.adiciona(65);
        System.out.println(a);
        a.remove(60);
        System.out.println(a);
        System.out.println(a.contaNos());
    }
    
}
