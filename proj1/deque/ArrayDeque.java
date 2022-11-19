package deque;

import org.hamcrest.core.StringEndsWith;

import java.util.Iterator;

/**
 * 头操作的开销太大，每次都要全部移动
 */
public class ArrayDeque<T> implements Iterable<T>{
    T[] items;
    int size;
    int capacity;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
    }

    public void addFirst(T item) {
        T[] demo = (T[]) new Object[size + 1];
        demo[0] = item;
        System.arraycopy(items, 0, demo, 1, size);
        items = demo;
        size++;
    }

    public void addLast(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[size] = item;
        size++;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public void printDeque() {
        System.out.print("[");
        for (int i = 0; i < size -1; i++) {
            System.out.print(get(i));
            System.out.print(", ");
        }
        System.out.print(get(size-1));
        System.out.println("]");
    }
    public void resize(int capacity) {
        this.capacity = capacity;
        T[] demo = (T[]) new Object[capacity];
        System.arraycopy(items, 0, demo, 0, size);
        items = demo;
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T returnItem = items[0];
        if (capacity > 16 && capacity > (size-1)*4) {
            T[] demo = (T[]) new Object[size/2];
            System.arraycopy(items, 1, demo, 0, size-1);
            items = demo;
            size--;
            return returnItem;

        } else {
            T[] demo = (T[]) new Object[size-1];
            System.arraycopy(items, 1, demo, 0, size-1);
            items = demo;
            size--;
            return returnItem;
        }
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T item= items[size - 1];
        size--;
        return item;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return items[index];
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof ArrayDeque lld && lld.size == this.size) {
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
        int pos = 0;
        @Override
        public boolean hasNext() {
            return pos < size;
        }
        @Override
        public T next() {
            if (hasNext()) {
                T demo = items[pos];
                pos++;
                return demo;
            }
            return null;
        }
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        arrayDeque.addLast(12);
        arrayDeque.addLast(33);
        arrayDeque.addLast(22);

        //对于你自己实现的iterator，增强for的功能是由你自定义的
        //如果你返回items里的值，则for也会返回这样的值
        for (int i : arrayDeque) {
            System.out.println(i);
        }
    }
}
