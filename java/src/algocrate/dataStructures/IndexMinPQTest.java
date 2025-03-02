package algocrate.dataStructures;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IndexMinPQTest {
    private IndexMinPQ<String> pq;

    @BeforeMethod
    public void setUp() {
        pq = new IndexMinPQ<>(10);
    }

    @Test
    public void testInsertAndMin() {
        pq.insert(0, "delta");
        pq.insert(1, "alpha");
        pq.insert(2, "charlie");
        pq.insert(3, "bravo");
        
        Assert.assertEquals(pq.minIndex(), 1);
        Assert.assertEquals(pq.minKey(), "alpha");
    }
    
    @Test
    public void testDelMin() {
        pq.insert(0, "delta");
        pq.insert(1, "alpha");
        pq.insert(2, "charlie");
        pq.insert(3, "bravo");
        
        int minIndex = pq.delMin();
        Assert.assertEquals(minIndex, 1);
        Assert.assertEquals(pq.minKey(), "bravo");
    }
    
    @Test
    public void testChangeKey() {
        pq.insert(0, "delta");
        pq.insert(1, "alpha");
        pq.insert(2, "charlie");
        pq.insert(3, "bravo");
        
        pq.changeKey(3, "aardvark"); // Should become the new min
        
        Assert.assertEquals(pq.minIndex(), 3);
        Assert.assertEquals(pq.minKey(), "aardvark");
    }
    
    @Test
    public void testDelete() {
        pq.insert(0, "delta");
        pq.insert(1, "alpha");
        pq.insert(2, "charlie");
        pq.insert(3, "bravo");
        
        pq.delete(1);
        Assert.assertNotEquals(pq.minIndex(), 1);
        Assert.assertEquals(pq.minKey(), "bravo");
    }
}
