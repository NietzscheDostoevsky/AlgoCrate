package algocrate.searching.tests;

import algocrate.searching.SymbolTable;
import algocrate.searching.BinarySearchTreeST;  // Example implementation
import algocrate.searching.SeparateChainingHashST;  // Example HashTable
import algocrate.searching.OrderedST;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SymbolTableTest {

    // Data Provider: Supplies different SymbolTable implementations
    @DataProvider(name = "symbolTableImplementations")
    public Object[][] provideSymbolTables() {
        return new Object[][] {
            { new BinarySearchTreeST<String, Integer>() },  // Example BST implementation
            { new SeparateChainingHashST<String, Integer>() }  // Example Hash Table
        };
    }

    @Test(dataProvider = "symbolTableImplementations")
    public void testPutAndGet(SymbolTable<String, Integer> st) {
        st.put("apple", 1);
        st.put("banana", 2);
        
        Assert.assertEquals(st.get("apple"), Integer.valueOf(1));
        Assert.assertEquals(st.get("banana"), Integer.valueOf(2));
        Assert.assertNull(st.get("cherry"));  // Not inserted, should be null
    }

    @Test(dataProvider = "symbolTableImplementations")
    public void testContains(SymbolTable<String, Integer> st) {
        st.put("dog", 10);
        Assert.assertTrue(st.contains("dog"));
        Assert.assertFalse(st.contains("cat"));
    }

    @Test(dataProvider = "symbolTableImplementations")
    public void testDelete(SymbolTable<String, Integer> st) {
        st.put("x", 100);
        Assert.assertTrue(st.contains("x"));

        st.delete("x");
        Assert.assertFalse(st.contains("x"));
        Assert.assertNull(st.get("x"));
    }

    @Test(dataProvider = "symbolTableImplementations")
    public void testSize(SymbolTable<String, Integer> st) {
        Assert.assertEquals(st.size(), 0);

        st.put("one", 1);
        st.put("two", 2);
        Assert.assertEquals(st.size(), 2);

        st.delete("one");
        Assert.assertEquals(st.size(), 1);
    }

    @Test(dataProvider = "symbolTableImplementations")
    public void testMinMaxIfOrdered(SymbolTable<String, Integer> st) {
        if (st instanceof OrderedST) {
            OrderedST<String, Integer> orderedST = (OrderedST<String, Integer>) st;
            orderedST.put("a", 1);
            orderedST.put("c", 3);
            orderedST.put("b", 2);

            Assert.assertEquals(orderedST.min(), "a");
            Assert.assertEquals(orderedST.max(), "c");
        }
    }
}
