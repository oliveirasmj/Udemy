/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula003_ListasBiLigadas;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author mjfr
 */
public class ListaGenerica<T> implements List {
    
    private class Node<T> {
        public Node<T> next;
        public T value;
        public Node (T nValue) {
            value = nValue;
            next = null;
        }
    }

    private Node<T> head;
    private int size;
    public ListaGenerica() {
        head = null;
        size = 0;
    }
    
    public boolean isEmpty() {
        return head == null;
    }
    
    @Override
    public boolean add(Object e) {
        Node newNode = new Node(e);
        //ir até ao fim da lista
        Node actual = head, previous = null;
        while (actual != null) {
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
        return true;
    }
    
    @Override
    public void add(int i, Object e) {
        Node newNode = new Node((int) e);
        //ir até ao fim da lista
        Node actual = head, previous = null;
        for(  ; i > 0 && actual != null; i--) {
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
    
    /*public boolean add (int nValue) {
        Node newNode = new Node(nValue);
        //ir até ao fim da lista
        Node actual = head, previous = null;
        while (actual != null) {
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
    }*/
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        //vamos percorrer a lista desde o início...
        Node temp = head;
        //.. até ao fim
        while (temp != null) {
            sb.append(temp.value);//colocar o valor do Node no StringBuilder
            sb.append(" ");
            //ir para o próximo node
            temp = temp.next;
        }
        return sb.toString();
    }
    
    @Override
    public boolean remove(Object o) {
        if(head == null)
            return false; //teste de lista vazia
        //procurar o elemento a eliminar
        Node delete = head, previous = null;
        while (delete != null && o != delete.value) {
            previous = delete;
            delete = delete.next;
        }
        //remover se o elemento existir
        if(delete == head) { //remover o nó inicial
            head = head.next;
            size--;
            return true;
        } else if (delete != null) {//remover outro nó
            previous.next = delete.next;
            size--;
            return true;
        }
        return false;
    }
    
    @Override
    public Object remove(int i) {
        if (i < 0 || i >= size())
            throw new IndexOutOfBoundsException();
        Node n = head, previous = null;
        for ( ; i > 0; i--) {
            previous = n;
            n = n.next;
        }
        if (previous == null) {//é o primeiro nó a ser removido
            head = n.next;
        } else {
            previous.next = n.next;
        }
        return n.value;
    }
        
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        Node n = head;
        while(n != null) {
            if (o == n.value) {
                return true;
            }
            n = n.next;
        }
        return false;
    }
    
    @Override
    public void clear() {
        head = null;
        size = 0;
    }
    
    @Override
    public Object get(int i) {
        if (i < 0 || i >= size())
            throw new IndexOutOfBoundsException();
        
        Node n = head;
        for( ; i > 0; i--)//dar i saltos
            n = n.next;
        return n;
    }
    
    @Override
    public Object set(int i, Object e) {
        if (e == null)
            throw new NullPointerException();
        
        if (i < 0 || i >= size())
            throw new IndexOutOfBoundsException();
        
        Node n = head;
        for( ; i > 0; i--)//dar i saltos
            n = n.next;
        
        //Node aux = n;//Não funciona porque apontam para o mesmo local
        Node aux = new Node (n.value);//apontam para o mesmo local!!!
        n.value = e;//pq para já a lista é de inteiros
        return aux.value;
    }
    
    @Override
    public int indexOf(Object o) {
        Node n = head;
        for(int i= 0 ; n != null; i++) {
            if (n.value == o)
                return i;
            n = n.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        Node n = head;
        int index = -1;
        for(int i= 0 ; n != null; i++) {
            if (n.value == o)
                index = i;
            n = n.next;
        }
        return index;
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
    public Object[] toArray(Object[] ts) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean containsAll(Collection clctn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addAll(Collection clctn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addAll(int i, Collection clctn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeAll(Collection clctn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean retainAll(Collection clctn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListIterator listIterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListIterator listIterator(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List subList(int i, int i1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void main(String[] args) {
        // TODO code application logic here
        ListaGenerica l = new ListaGenerica();
        l.add(10);
        l.add(25);
        l.add(20);
        System.out.println(l);
        l.add(0, 40);
        System.out.println(l);
        l.add(4, 35);
        System.out.println(l);
        l.add(2, 27);
        System.out.println(l);
        int x = (int) l.set(2, (Object) 30);
        System.out.println("devolvido "+x);
        System.out.println(l);
        l.remove(3);
        System.out.println(l);
        /*l.remove((Object) 20);
        System.out.println(l);
        l.remove((Object) 21);
        System.out.println(l);
        l.remove((Object)40);
        System.out.println(l);
        l.remove((Object) 35);
        System.out.println(l);
        */
        System.out.println("-----------------");
        System.out.println(l.set(0, 888));
        System.out.println(l);
    }
    
}
