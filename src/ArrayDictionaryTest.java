import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayDictionaryTest {
    @Test
    public void demo() {
        int testSize = 5;
        ArrayDictionary dict = new ArrayDictionary(testSize);
        assertTrue(dict.add(2, 82));
        assertTrue(dict.add(4, 84));
        assertTrue(dict.add(7, 87));
        System.out.println(dict);
    }

    @Test
    public void remove() {
        // homework
        int testSize = 5;
        ArrayDictionary dict = new ArrayDictionary(testSize);
        dict.add(2,82);
        dict.add(3,2);
        dict.remove(2);
        assertEquals(1,dict.getCount());
        dict.remove(3);
        System.out.println(dict);
        assertEquals(0,dict.getCount());
        assertEquals(false,dict.contains(2));

    }

    @Test
    public void contains() {
        // homework
        int testSize = 5;
        ArrayDictionary dict = new ArrayDictionary(testSize);
        for(int i = 0; i<testSize;i++){
            dict.add(i,i);
            //System.out.println(dict.contains(i));
            assertTrue(dict.contains(i));
        }

        //assertTrue(false);  // place holder
    }
}