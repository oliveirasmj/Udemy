package aula002_ListasLigadas;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author olive
 */
public class MyList<T> implements List{ //T = qualquer tipo de dados
    
    private static class Node<T> {

        public Node<T> next; //cada node aponta para o seguinte
        public T value; //cada node tem um valor

        public Node(T nValue) { //quando inicializa
            value = nValue;
            next = null;
        }
    }

    private Node<T> head; //criar um Node chamado - head

    public MyList() {
        head = null; //head é inicializado a nulo
    }
    
    @Override
    public int size() {
        int i = 0;
        Node actual = head;
        while (actual !=null){
            i++;
            actual = actual.next;
        }
        return i;
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object[] toArray(Object[] a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(Object e) {
        Node newNode = new Node(e); //newN
        //ir até ao fim da lista 
        Node actual = head, previous = null; //listEnd
        while (actual != null) {
            previous = actual;
            actual = actual.next;
        }
        if (previous == null) { //inserir na cabeça da lista
            //newNode.next = head;
            head = newNode;
        } else { //inserir à frente do último elemento
            //newNode.next = actual;
            previous.next = newNode;
        }
        return true;
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean containsAll(Collection c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addAll(Collection c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addAll(int index, Collection c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeAll(Collection c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean retainAll(Collection c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object get(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object set(int index, Object element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(int index, Object element) {
        if (index < 0 || index > this.size()) return; //se fora dos limites termina metodo
        
        Node newNode = new Node(element);
        Node actual = head, previous = null;
        while (index > 0) { //ir para posicao
            previous = actual; //se lista chegou ao fim
            actual = actual.next;
            index--;
        }
        
        //modificar head se lista vazia ou lastNode se lista com elementos        
        if (previous == null) { //se lista for vazia
            newNode.next = head;
            head = newNode;
        } else { //se lista nao for vazia
            newNode.next = actual; //seguinte aponta para NewNode        previous      NewNode  <-- next
            previous.next = newNode; //anterior aponta para NewNode      previous -->  NewNode      next
        }
    }

    @Override
    public Object remove(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListIterator listIterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListIterator listIterator(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        Node n = head;
        while (n!=null){
            sb.append(n.value);
            sb.append("-->");
            n=n.next;
        }
        return sb.toString();
    }
    
    
    public static void main(String[] args) {
        MyList l = new MyList();
        l.add(10);
        l.add(5);
        l.add(15);
        System.out.println(l);
        
        l.add(2, 3);
        System.out.println(l);
    }
    
}
