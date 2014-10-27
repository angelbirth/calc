package org.ric.strukdat.project;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author MONICA
 */
public class Stack<E> {

    LinkedList<E> list;

    public Stack() {
        list = new LinkedList<E>();
    }

    public E pop() {
        return list.removeLast();
    }

    public void push(E data) {
        list.addLast(data);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public E peek() {
        return (E) (list.getLast().getData());
    }

    public int size() {
        // TODO Auto-generated method stub
        return list.size();
    }
}
