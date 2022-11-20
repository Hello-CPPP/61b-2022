package deque;

import java.awt.event.ItemEvent;
import java.util.Iterator;

public class LinkedListDeque<T> implements Iterable<T>{
    private class node {
       node prev;
       node next;
       T item;

       node(node p, T i, node n) {
           prev = p;
           item = i;
           next = n;
       }
    }

    T test;
    node sentinel;
    int size;

    public LinkedListDeque() {
        size = 0;
        sentinel = new node(null, test, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    LinkedListDeque(T item) {
        size = 1;
        sentinel = new node(null, test, null);
        this.addFirst(item);
    }

    public void addFirst(T item) {
        size++;
        node demo = new node(sentinel, item, sentinel.next);
        sentinel.next.prev = demo;
        sentinel.next = demo;
    }

    public void addLast(T item) {
        size++;
        node demo = new node(sentinel.prev, item, sentinel);
        sentinel.prev.next = demo;
        sentinel.prev = demo;
    }

    public boolean isEmpty() {
        if (sentinel.next == sentinel) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        node p = sentinel.next;
        while (p.next != sentinel) {
            System.out.println(p.item + " ");
            p = p.next;
        }
        System.out.print(p.item);
        System.out.println();
    }

    public T removeFirst() {
        if (this.isEmpty()) {
            return null;
        }
        T demo = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        --size;
        return demo;
    }

    public T removeLast() {
        if (this.isEmpty()) {
            return null;
        }
        T demo = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        --size;
        return demo;
    }

    public T get(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        node demo = sentinel.next;
        for (int i = 0; i < index; i++) {
            demo = demo.next;
        }
        return demo.item;
    }

    public T getHelper(node p, int index) {
        if (index == 0) {
            return p.next.item;
        }
        return getHelper(p.next, --index);

    }

    public T getRecursive(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return getHelper(sentinel, index);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof LinkedListDeque lld && lld.size == this.size) {
            for (int i = 0; i < size; i++) {
                if (lld.get(i) != this.get(i)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new returnIterator();
    }

    private class returnIterator implements Iterator<T> {
        int pos;
        returnIterator() {
            pos = 0;
        }
        @Override
        public boolean hasNext() {
            return size > pos;
        }
        @Override
        public T next() {
            if (hasNext()) {
                T demo = LinkedListDeque.this.get(pos);
                pos++;
                return demo;
            }
            return null;
        }
    }

    public static void main(String[] args) {
        LinkedListDeque<String> lld = new LinkedListDeque<>();
        System.out.println(lld.isEmpty());
        lld.addFirst("hello");
        lld.addFirst("hello1");
        lld.addFirst("hello2");
        lld.printDeque();
        System.out.println(lld.size);
        System.out.println(lld.get(2));

    }
}

