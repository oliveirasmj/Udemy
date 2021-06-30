package aula002_ListasLigadas;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author olive
 */
public class Lista {

    private static class Node {
        public Node next; //cada node aponta para o seguinte
        public int value; //cada node tem um valor
        public Node(int nValue) { //quando inicializa
            value = nValue;
            next = null; //começa sem next
        }
    }

    private Node head; //criar um Node chamado - head
    public Lista() {
        head = null; //head é inicializado a nulo
    }

    public boolean isEmpty() {
        return head == null; //metodo vazio - retorna nulo
    }

    public void insert(int nValue) {
        Node newNode = new Node(nValue);        // criar nó com nValue=x, next=null 
        Node actual = head, previous = null;    // actual=null/1º   , previous=null
        while (actual != null) {    // percorrer lista - quando actual for nulo é o fim
            previous = actual;      // ultimo elemnto
            actual = actual.next;   // cai fora
        }
        if (previous == null) {     // se ultimo for nulo é o fim da lista - lista vazia
            head = newNode;         // inserir na cabeça da lista
        } else {                    // inserir à frente do último elemento
            previous.next = newNode;// inserir no fim
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node actual = head;
        while (actual != null) { //ate ao fim (o nulo = ultimo)
            sb.append(actual.value); //guardar na string
            sb.append(" ");
            //ir para o proximo no
            actual = actual.next;
        }
        return sb.toString();
    }

    public void insertCrescente(int nValue) {
        Node newNode = new Node(nValue);
        //procurar o local onde vamos inserir o novo nó
        Node actual = head, previous = null;
        while (actual != null && nValue > actual.value) {
            previous = actual;
            actual = actual.next;
        }
        if (previous == null) { //inserir na cabeça da lista
            newNode.next = head;
            head = newNode;
        } else { //inserir à frente do elemento "actual"
            newNode.next = actual;
            previous.next = newNode;
        }
    }

    public void delete(int nValue) {
        if (head == null) {
            return; //teste de lista vazia
        }//procurar o elemento a eliminar
        Node delete = head, previous = null;
        while (delete != null && nValue != delete.value) {
            previous = delete;
            delete = delete.next;
        }
        //remover se o elemento existir
        if (delete == head) { //remover o nó inicial
            head = head.next;
        } else if (delete != null) {//remover outro nó
            previous.next = delete.next;
        }
    }
    
    public void insertDecrescente(int nValue) {
        Node newNode = new Node(nValue);
        //procurar o local onde vamos inserir o novo nó
        Node actual = head, previous = null;
        while (actual != null && nValue < actual.value) {
            previous = actual;
            actual = actual.next;
        }
        if (previous == null) { //inserir na cabeça da lista
            newNode.next = head;
            head = newNode;
        } else { //inserir à frente do elemento "actual"
            newNode.next = actual;
            previous.next = newNode;
        }
    }

    public static void main(String[] args) {
        Lista l = new Lista();
        l.insertDecrescente(10);
        l.insertDecrescente(5);
        l.insertDecrescente(15);
        System.out.println(l);
    }
}
