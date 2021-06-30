/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula004_Arvores;

/**
 *
 * @author olive
 */
public class ArvoreMaiorMenor {
    
    private static class Node {
        public Node fesq, fdir;
        public int valor;
        public Node(int valor) {
            this.valor = valor;
            fesq = null;
            fdir = null;
        }
        public String toString() {
            return ""+this.valor;
        }
    }
    
    private Node raiz;
    
    public ArvoreMaiorMenor(){
       raiz = null; 
    }
    
    private int contaNos (Node node) {
        if (node == null) return 0;
        return contaNos(node.fesq) + contaNos(node.fdir) + 1;
    }
    
    public int contaNos() {
        return contaNos(raiz);
    }
    
    private int contaFolhas(Node node){
        if (node == null) return 0;
        if (node.fesq == null && node.fdir == null) return 1;
        return contaFolhas(node.fesq) + contaFolhas(node.fdir);
    }
    
    public int contaFolhas() {
        return contaFolhas(raiz);
    }
    
    public void adiciona(int valor) {
        if (raiz == null) {
            raiz = new Node(valor);
            return;
        }
        adiciona(raiz, valor);
    }
    
    private void adiciona(Node atual, int valor) {
        if (valor == atual.valor)
            return;
        if (valor < atual.valor) {
            if (atual.fesq == null) {
                atual.fesq = new Node(valor);
            } else {
                adiciona(atual.fesq, valor);
            }
        } else {
            if (atual.fdir == null) {
                atual.fdir = new Node(valor);
            } else {
                adiciona(atual.fdir, valor);
            }
        }
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        addToString(raiz, sb);
        return sb.toString();
    }
    
    private void addToString(Node no, StringBuilder sb) {
        if (no == null) return;
        sb.append("("+no+","+no.fesq+","+no.fdir+")\n");
        addToString(no.fesq, sb);
        addToString(no.fdir, sb);
    }
    
    public static void main(String[] args) {
        ArvoreMaiorMenor a = new ArvoreMaiorMenor();
        a.adiciona(6);
        a.adiciona(2);
        a.adiciona(7);
        a.adiciona(8);
        a.adiciona(5);
        a.adiciona(6);
        System.out.println(a.contaFolhas());
        System.out.println(a.contaNos());
        System.out.println(a);
    }
}
