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
        //empty dict
        assertFalse(dict.remove(1));

        //no collision in dictionary
        for(int i = 0;i<3;i++){
            dict.add(i,i+3);
        }
        dict.remove(2);
        assertEquals(2,dict.getCount());
        //System.out.println(dict);

        //key does not exist with no collision
        dict.remove(4);
        assertNull(dict.get(4));

        //key exists that has collisions, key in the collisions
        for(int i = 2; i<18;i+=5){
            dict.add(i,i*2);
        }
        dict.remove(12);
        assertEquals((Integer)4,dict.get(2));
        assertEquals((Integer)14,dict.get(7));
        assertEquals((Integer)34,dict.get(17));
        assertNull(dict.get(12));
        //System.out.println(dict);

        //key exists that has collisions, key not in the collisions
        assertTrue(dict.remove(0));
        assertNull(dict.get(0));
        //System.out.println(dict);

        //key does not exists in dictionary with collisions
        assertFalse(dict.remove(5));


    }

    @Test
    public void contains() {

        //set 1, empty dict
        int testSize = 0;
        ArrayDictionary dict = new ArrayDictionary(testSize);
        for(int i = -1; i<2;i++){
            assertFalse(dict.contains(i));
        }

        //set2, capacity = 1
        int testTwoSize = 1;
        ArrayDictionary dict2 = new ArrayDictionary(testTwoSize);
        dict2.add(0,103);
        //System.out.println(dict2.toString());
        //assertEquals(false, dict2.contains(2));
        assertTrue(dict2.contains(0));

        //set3, capacity = 2
        int testThreeSize = 2;
        ArrayDictionary dict3 = new ArrayDictionary(testThreeSize);
        dict3.add(0,103);
        dict3.add(1,105);
        boolean[] expected = {true, true, false, false};
        for(int i = 0;i<4;i++){
            assertEquals(expected[i],dict3.contains(i));
        }

    }
}