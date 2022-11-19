package deque;

import org.junit.Test;
import org.junit.jupiter.api.RepeatedTest;

import javax.sound.midi.Soundbank;

import static org.junit.Assert.*;

public class ArrayDequeTest {
    @Test
    public void addTest() {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        arrayDeque.addLast(12);
        arrayDeque.addLast(33);
        arrayDeque.addLast(22);
        arrayDeque.addLast(22);
        arrayDeque.addLast(22);
        arrayDeque.addLast(22);
        arrayDeque.addLast(22);
        arrayDeque.addLast(22);
        arrayDeque.addLast(22);

        ArrayDeque<Integer> arrayDeque1 = new ArrayDeque<>();
        arrayDeque1.addLast(33);
        arrayDeque1.addFirst(12);

        assertEquals(arrayDeque.get(0), arrayDeque1.get(0));
    }

    @Test
    public void isEmptyTest() {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        System.out.println(arrayDeque.isEmpty());
        arrayDeque.addLast(12);
        arrayDeque.addLast(33);
        arrayDeque.addLast(22);

        System.out.println(arrayDeque.isEmpty());
        arrayDeque.removeLast();
        System.out.println(arrayDeque.isEmpty());
        arrayDeque.removeLast();
        System.out.println(arrayDeque.isEmpty());
        arrayDeque.removeFirst();
        System.out.println(arrayDeque.isEmpty());
        arrayDeque.removeLast();
    }

    @Test
    public void sizeTest() {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        arrayDeque.addLast(12);
        arrayDeque.addLast(33);
        arrayDeque.addLast(22);

        System.out.println(arrayDeque.size());
    }

    @Test
    public void printDequeTest() {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        arrayDeque.addLast(12);
        arrayDeque.addLast(33);
        arrayDeque.addLast(22);

        ArrayDeque<Integer> arrayDeque1 = new ArrayDeque<>();
        arrayDeque1.addLast(33);
        arrayDeque1.addFirst(12);

        ArrayDeque<Integer> arrayDeque2 = new ArrayDeque<>();
        arrayDeque.printDeque();
        arrayDeque1.printDeque();
        arrayDeque2.printDeque();
    }

    @Test
    public void removeTest() {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        arrayDeque.addLast(12);
        arrayDeque.addLast(33);
        arrayDeque.addLast(22);

        arrayDeque.removeLast();
        arrayDeque.removeLast();
        arrayDeque.removeFirst();
        arrayDeque.removeLast();

        ArrayDeque<Integer> arrayDeque1 = new ArrayDeque<>();
        arrayDeque1.addLast(33);
        arrayDeque1.addFirst(12);

        arrayDeque.printDeque();
    }

    @Test
    public void getTest() {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        arrayDeque.addLast(12);
        arrayDeque.addLast(33);
        arrayDeque.addLast(22);

        arrayDeque.printDeque();
        for (int i = 0; i < arrayDeque.size; i++) {
            System.out.println(arrayDeque.get(i));
        }
    }

    /* ======================= */
    @Test
    public void testaddsizeempty() {
        ArrayDeque<String> dq = new ArrayDeque<>();
        assertEquals(true, dq.isEmpty());

        dq.addFirst("first");
        assertEquals(1, dq.size());

        dq.addLast("last");
        assertEquals(2, dq.size());

        dq.printDeque();

        String first = dq.removeFirst();
        assertEquals("first", first);

        String last = dq.removeLast();
        assertEquals("last", last);

        assertEquals(0, dq.size());
    }


    @Test
    public void testgrowshrink() {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < 16; i++) {
            dq.addLast(i);
        }
        for (int i = -16; i < 0; i++) {
            dq.addFirst(i);
        }
        //for (int i = -1; i <= 16; i--) {
        //    assertEquals(i, dq.get(i));
        //}
        for (int i = 0; i < 30; i++) {
            dq.removeFirst();
        }
        assertEquals(2, dq.size());
        dq.printDeque();
    }
}


