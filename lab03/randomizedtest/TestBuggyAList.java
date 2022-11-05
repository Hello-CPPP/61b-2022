package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;
import timingtest.AList;

import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> a = new AListNoResizing<>();
        a.addLast(4);
        a.addLast(5);
        a.addLast(6);
        BuggyAList<Integer> b = new BuggyAList<>();
        b.addLast(4);
        b.addLast(5);
        b.addLast(6);

        assertEquals(a.size(), b.size());
        assertEquals(a.removeLast(), b.removeLast());
        assertEquals(a.removeLast(), b.removeLast());
        assertEquals(a.removeLast(), b.removeLast());
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> B = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                B.addLast(randVal);
                System.out.println("L.addLast(" + randVal + ")");
                System.out.println("B.addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size_L = L.size();
                int size_B = B.size();
                System.out.println("size_L: " + size_L);
                System.out.println("size_B: " + size_B);
            } else if (operationNumber == 2) {
                if (L.size() > 0) {
                    assertEquals(L.getLast(), B.getLast());
                }
            } else if (operationNumber == 3) {
                if (L.size() > 0) {
                    assertEquals(L.removeLast(), B.removeLast());
                }
            }
        }
    }
}
