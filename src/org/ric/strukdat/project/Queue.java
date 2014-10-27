package org.ric.strukdat.project;

/*
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author MONICA
 */
public class Queue<E> {
    private LinkedList<E> list;

    public Queue() {
        list = new LinkedList<>();
    }

    public void enqueue(E element) {
        list.addLast(element);
    }

    public E dequeue() {
        return list.removeFirst();
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public E peek() {
        return list.getFirst().getData();
    }

}
