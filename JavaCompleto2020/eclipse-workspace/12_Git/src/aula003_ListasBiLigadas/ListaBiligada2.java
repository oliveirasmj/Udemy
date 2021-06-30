/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula003_ListasBiLigadas;

/**
 *
 * @author olive
 */
public class ListaBiligada2 {

    private class Node {

        public int element;
        public Node next;
        public Node previous;

        public Node(int nValue) {
            element = nValue;
            next = null;
            previous = null;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    private Node head;
    private Node tail;
    public int size;

    public ListaBiligada2() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    //adiciona no fim
    public void add(int nValue) {
        Node no = new Node(nValue);
        if (isEmpty() == true) {
            head = no;
            tail = no;
        } else {
            tail.next = no;
            no.previous = tail;
            tail = no;
        }
    }

    //adiciona na posicao pretendida
    public void add(int i, Object e) {
        Node newNode = new Node((int) e);
        //ir até ao fim da lista
        Node actual = head, previous = null;
        for (; i > 0 && actual != null; i--) {
            previous = actual;
            actual = actual.next;
        }
        if (previous == null) { //inserir na cabeça da lista
            newNode.next = head;
            head = newNode;
        } else { //inserir à frente do último elemento
            newNode.next = actual;
            previous.next = newNode;
        }
        size++;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node actual = head;
        if (head == null) {
            return "Lista vazia!";
        }
        sb.append("Todos:\n");

        while (actual.next != null) {
            sb.append(" " + actual.element);
            actual = actual.next;

        }
        sb.append(" " + actual.element); //ultimo

        return sb.toString();
    }

    public boolean contains(int element) {
        Node atual = head;
        while (atual != null) {
            if (atual.element == element) {
                return true;
            }
            atual = atual.next;
        }
        return false;
    }

    public boolean remove(int element) {
        //para criar o purge é necessário ter o contains  
        if (contains(element) == false) {
            return false;
        }
        Node atual = head;
        while (atual != null) {
            if (element == atual.element) {
                if (atual == head) {
                    head = head.next;
                    head.previous = null;
                }
                if (atual == tail) {
                    tail = tail.previous;
                    tail.next = null;
                } else {
                    atual.previous.next = atual.next;
                    atual.next.previous = atual.previous;
                }
            }
            atual = atual.next;
        }
        return true;
    }

    public Object removePos(int i) {
        if (i < 0 || i >= size()) {
            throw new IndexOutOfBoundsException();
        }
        Node n = head, previous = null;
        for (; i > 0; i--) {
            previous = n;
            n = n.next;
        }
        if (previous == null) {//é o primeiro nó a ser removido
            head = n.next;
        } else {
            previous.next = n.next;
        }
        return n.element;
    }

    public Object get(int i) {
        if (i < 0 || i >= size()) {
            throw new IndexOutOfBoundsException();
        }

        Node n = head;
        for (; i > 0; i--)//dar i saltos
        {
            n = n.next;
        }
        return n;
    }

    public Object set(int i, int e) {
        //if (e == null)
        //    throw new NullPointerException();

        if (i < 0 || i >= size()) {
            throw new IndexOutOfBoundsException();
        }

        Node n = head;
        for (; i > 0; i--)//dar i saltos
        {
            n = n.next;
        }

        //Node aux = n;//Não funciona porque apontam para o mesmo local
        Node aux = new Node(n.element);//apontam para o mesmo local!!!
        n.element = e;//pq para já a lista é de inteiros
        return aux.element;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public static void main(String[] args) {
        ListaBiligada2 ll = new ListaBiligada2();
        ll.add(6);
        ll.add(9);
        ll.add(5);
        ll.add(4);
        System.out.println(ll.toString());
        //System.out.println(ll.contains(5));
        System.out.println(ll.remove(5));
        System.out.println(ll.toString());
        ll.add(0, 33);
        System.out.println(ll.toString());
        ll.removePos(0);
        System.out.println(ll.toString());
        System.out.println(ll.set(0, 888));
        System.out.println(ll.toString());
    }

}
