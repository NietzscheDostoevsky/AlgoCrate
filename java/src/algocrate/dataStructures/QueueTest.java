package algocrate.dataStructures;

import java.util.Iterator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class QueueTest {
    
    @Test
    public void testEnqueueAndDequeue() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        
        Assert.assertEquals(queue.dequeue().intValue(), 1);
        Assert.assertEquals(queue.dequeue().intValue(), 2);
        Assert.assertEquals(queue.dequeue().intValue(), 3);
    }
    
    @Test(expectedExceptions = java.util.NoSuchElementException.class)
    public void testDequeueEmptyQueue() {
        Queue<String> queue = new Queue<>();
        queue.dequeue();
    }
    
    @Test
    public void testPeek() {
        Queue<Double> queue = new Queue<>();
        queue.enqueue(10.5);
        queue.enqueue(20.5);
        
        Assert.assertEquals((double)queue.peek(), 10.5);
        Assert.assertEquals((double)queue.dequeue(), 10.5);
        Assert.assertEquals((double)queue.peek(), 20.5);
    }
    
    @Test
    public void testIsEmpty() {
        Queue<Character> queue = new Queue<>();
        Assert.assertTrue(queue.isEmpty());
        
        queue.enqueue('A');
        Assert.assertFalse(queue.isEmpty());
        
        queue.dequeue();
        Assert.assertTrue(queue.isEmpty());
    }
    
    @Test
    public void testSize() {
        Queue<String> queue = new Queue<>();
        Assert.assertEquals(queue.size(), 0);
        
        queue.enqueue("Hello");
        queue.enqueue("World");
        Assert.assertEquals(queue.size(), 2);
        
        queue.dequeue();
        Assert.assertEquals(queue.size(), 1);
    }
    
    @Test
    public void testToString() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        
        Assert.assertEquals(queue.toString().trim(), "1 2 3");
    }
    
    @Test
    public void testGenericTypes() {
        Queue<String> stringQueue = new Queue<>();
        stringQueue.enqueue("A");
        stringQueue.enqueue("B");
        Assert.assertEquals(stringQueue.dequeue(), "A");
        Assert.assertEquals(stringQueue.dequeue(), "B");
        
        Queue<Integer> intQueue = new Queue<>();
        intQueue.enqueue(100);
        intQueue.enqueue(200);
        Assert.assertEquals(intQueue.dequeue().intValue(), 100);
        Assert.assertEquals(intQueue.dequeue().intValue(), 200);
    }
    
    @Test
    public void testIterator() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        
        Iterator<Integer> iterator = queue.iterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(iterator.next().intValue(), 1);
        Assert.assertEquals(iterator.next().intValue(), 2);
        Assert.assertEquals(iterator.next().intValue(), 3);
        Assert.assertFalse(iterator.hasNext());
    }
}
