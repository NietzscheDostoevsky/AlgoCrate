package algocrate.dataStructures;

import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StackTest {
    
    @Test
    public void testPushAndPop() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        
        Assert.assertEquals(stack.pop().intValue(), 3);
        Assert.assertEquals(stack.pop().intValue(), 2);
        Assert.assertEquals(stack.pop().intValue(), 1);
    }
    
    @Test(expectedExceptions = java.util.NoSuchElementException.class)
    public void testPopEmptyStack() {
        Stack<String> stack = new Stack<>();
        stack.pop();
    }
    
    @Test
    public void testPeek() {
        Stack<Double> stack = new Stack<>();
        stack.push(10.5);
        stack.push(20.5);
        
        Assert.assertEquals((double)stack.peek(), 20.5);
        Assert.assertEquals((double)stack.pop(), 20.5);
        Assert.assertEquals((double)stack.peek(), 10.5);
    }
    
    @Test
    public void testIsEmpty() {
        Stack<Character> stack = new Stack<>();
        Assert.assertTrue(stack.isEmpty());
        
        stack.push('A');
        Assert.assertFalse(stack.isEmpty());
        
        stack.pop();
        Assert.assertTrue(stack.isEmpty());
    }
    
    @Test
    public void testSize() {
        Stack<String> stack = new Stack<>();
        Assert.assertEquals(stack.size(), 0);
        
        stack.push("Hello");
        stack.push("World");
        Assert.assertEquals(stack.size(), 2);
        
        stack.pop();
        Assert.assertEquals(stack.size(), 1);
    }
    
    @Test
    public void testToString() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        
        Assert.assertEquals(stack.toString().trim(), "3 2 1");
    }
    
    @Test
    public void testGenericTypes() {
        Stack<String> stringStack = new Stack<>();
        stringStack.push("A");
        stringStack.push("B");
        Assert.assertEquals(stringStack.pop(), "B");
        Assert.assertEquals(stringStack.pop(), "A");
        
        Stack<Integer> intStack = new Stack<>();
        intStack.push(100);
        intStack.push(200);
        Assert.assertEquals(intStack.pop().intValue(), 200);
        Assert.assertEquals(intStack.pop().intValue(), 100);
    }
    
    @Test
    public void testIterator() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        
        Iterator<Integer> iterator = stack.iterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(iterator.next().intValue(), 3);
        Assert.assertEquals(iterator.next().intValue(), 2);
        Assert.assertEquals(iterator.next().intValue(), 1);
        Assert.assertFalse(iterator.hasNext());
    }
}
