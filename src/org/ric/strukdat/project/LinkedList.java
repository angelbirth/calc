package org.ric.strukdat.project;

/**
 * 
 * @author Riyadlah
 */
public class LinkedList<E> {

    private ListNode head;

    public ListNode getFirst() {
        return head.next;
    }

    public ListNode getLast() {
        return head.prev;
    }

    private int size;

    public int size() {
        return size;
    }

    public LinkedList() {
        head = new ListNode();
        head.next = head;
        head.prev = head;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private ListNode addBefore(E x, ListNode bantu) {
        ListNode baru = new ListNode(x, bantu, bantu.prev);
        bantu.prev.next = baru;
        bantu.prev = baru;
        size++;
        return baru;
    }

    public void addFirst(E e) {
        addBefore(e, head.next);
    }

    public void addLast(E e) {
        addBefore(e, head);
    }

    private E remove(ListNode n) {
        if (isEmpty()) {
            throw new NullPointerException("List kosong");
        } else {
            n.next.prev = n.prev;
            n.prev.next = n.next;
            n.next = null;
            n.prev = null;
            size--;
        }
        return (E) n.getData();
    }

    public E removeFirst() {
        return remove(head.next);
    }

    public E removeLast() {
        return remove(head.prev);
    }

    public class ListNode {

        private E data;
        private ListNode next;
        private ListNode prev;

        public ListNode() {
        }

        public ListNode(E elemen) {
            this.data = elemen;
        }

        public ListNode(E elemen, ListNode next, ListNode prev) {
            this.data = elemen;
            this.next = next;
            this.prev = prev;
        }

        public E getData() {
            return data;
        }

        public ListNode getNext() {
            return next;
        }

        public ListNode getPrev() {
            return prev;
        }
    }
}
