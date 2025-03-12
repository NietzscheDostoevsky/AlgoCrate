package algocrate.searching;

/*
 * Unit tests for BST symbol table implementation
 */

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BSTTest {
    private BST<Integer, String> bst;

    @BeforeMethod
    public void setUp() {
        bst = new BST<>();
    }

    @Test
    public void testPutAndGet() {
        bst.put(5, "Five");
        bst.put(3, "Three");
        bst.put(7, "Seven");
        
        Assert.assertEquals(bst.get(5), "Five");
        Assert.assertEquals(bst.get(3), "Three");
        Assert.assertEquals(bst.get(7), "Seven");
        Assert.assertNull(bst.get(10));
    }

    @Test
    public void testContains() {
        bst.put(2, "Two");
        bst.put(8, "Eight");
        
        Assert.assertTrue(bst.contains(2));
        Assert.assertTrue(bst.contains(8));
        Assert.assertFalse(bst.contains(5));
    }

    @Test
    public void testSize() {
        Assert.assertEquals(bst.size(), 0);
        bst.put(1, "One");
        Assert.assertEquals(bst.size(), 1);
        bst.put(2, "Two");
        bst.put(3, "Three");
        Assert.assertEquals(bst.size(), 3);
    }

    @Test
    public void testDelete() {
        bst.put(6, "Six");
        bst.put(4, "Four");
        bst.put(7, "Seven");
        bst.delete(6);
        
        Assert.assertFalse(bst.contains(6));
        Assert.assertEquals(bst.size(), 2);
    }

    @Test
    public void testMinMax() {
        bst.put(5, "Five");
        bst.put(2, "Two");
        bst.put(8, "Eight");
        bst.put(1, "One");
        bst.put(10, "Ten");
        
        Assert.assertEquals((int) bst.min(), 1);
        Assert.assertEquals((int) bst.max(), 10);
    }

    @Test
    public void testFloorCeiling() {
        bst.put(5, "Five");
        bst.put(2, "Two");
        bst.put(8, "Eight");
        
        Assert.assertEquals((int) bst.floor(6), 5);
        Assert.assertEquals((int) bst.ceiling(6), 8);
    }

    @Test
    public void testKeys() {
        bst.put(3, "Three");
        bst.put(1, "One");
        bst.put(4, "Four");
        bst.put(2, "Two");
        
        Iterable<Integer> keys = bst.keys();
        Integer[] expected = {1, 2, 3, 4};
        Assert.assertEquals(keys, expected);
    }
}
