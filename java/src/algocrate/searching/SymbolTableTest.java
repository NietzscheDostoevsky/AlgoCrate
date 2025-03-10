package algocrate.searching;

/*
 * Basic test case Symbol Table API which every implementation of symbol table must pass. 
 * Only tests two basic functionalities of put() and get() methods
 */

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
        Assert.assertNull(st.get("cherry"));  // Not inserted, should return null
    }

    @Test(dataProvider = "symbolTableImplementations")
    public void testOverwriteValue(SymbolTable<String, Integer> st) {
        st.put("key1", 10);
        Assert.assertEquals(st.get("key1"), Integer.valueOf(10));

        st.put("key1", 20);  // Overwrite existing value
        Assert.assertEquals(st.get("key1"), Integer.valueOf(20));

        st.put("key1", 30);
        Assert.assertEquals(st.get("key1"), Integer.valueOf(30));
    }

    @Test(dataProvider = "symbolTableImplementations")
    public void testGetNonExistentKey(SymbolTable<String, Integer> st) {
        Assert.assertNull(st.get("unknown"));
    }

    @Test(dataProvider = "symbolTableImplementations")
    public void testPutNullValueRemovesKey(SymbolTable<String, Integer> st) {
        st.put("test", 100);
        Assert.assertEquals(st.get("test"), Integer.valueOf(100));

        st.put("test", null); // Should remove the key
        Assert.assertNull(st.get("test"));
    }

    @Test(dataProvider = "symbolTableImplementations")
    public void testMultiplePutsAndGets(SymbolTable<String, Integer> st) {
        st.put("a", 1);
        st.put("b", 2);
        st.put("c", 3);

        Assert.assertEquals(st.get("a"), Integer.valueOf(1));
        Assert.assertEquals(st.get("b"), Integer.valueOf(2));
        Assert.assertEquals(st.get("c"), Integer.valueOf(3));

        // Overwriting existing values
        st.put("a", 10);
        st.put("b", 20);
        st.put("c", 30);

        Assert.assertEquals(st.get("a"), Integer.valueOf(10));
        Assert.assertEquals(st.get("b"), Integer.valueOf(20));
        Assert.assertEquals(st.get("c"), Integer.valueOf(30));
    }
}
