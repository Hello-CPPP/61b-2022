package IntList;

import static org.junit.Assert.*;
import org.junit.Test;


public class PrimesTest {
    @Test
    public void test1() {
        IntList list1 = IntList.of(1, 2, 3, 4);
        assertEquals( "1, 2, 9, 4", list1.toString());
    }
}
