package algocrate.dataStructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

/******************************************************************************
 * First-in-first-out (FIFO) queue implementation using a singly linked list.
 *
 * The Queue class represents a generic queue that supports the following operations:
 *      - enqueue(item)  : Adds an item to the end of the queue.
 *      - dequeue()      : Removes and returns the first item.
 *      - peek()         : Returns the first item without removing it.
 *      - isEmpty()      : Checks if the queue is empty.
 *      - size()         : Returns the number of items in the queue.
 * 
 * Implementation Details:
 *  - Uses a **singly linked list** with a static nested class for nodes.
 *  - Maintains references to both the **first** and **last** nodes for efficient enqueue and dequeue operations.
 *  - The queue follows the **FIFO (First-In-First-Out) principle**.
 * 
 * Performance:
 *  - All operations run in **O(1) worst-case time complexity**.
 *  - Uses **Θ(N) space complexity**, where N is the number of items in the queue.
 * 
 * Edge Cases:
 *  - Dequeueing or peeking from an empty queue results in an error.
 *  - Enqueueing null values is not allowed.
 * 
 * This implementation is efficient and suitable for applications requiring constant-time
 * queue operations.
 ******************************************************************************/


public class Queue<Item> implements Iterable<Item> {
    
    private Node<Item> first;   // Beginningn of the queue. 
    private Node<Item> last;    // end of queue
    private int n;              // total number of elements on queue
    
    /*
     * Would a non-static inner class work?
     * 
     * Yes, but it would be unnecessary because the Node doesn’t need to access 
     * Queue<Item>'s members (like first, last, or n). 
     * Making Node non-static would just introduce an implicit reference to the enclosing Queue, which is wasteful.
     */
    
    private static class Node<Item> { // Need generic syntax since it's an static class, not linked to the outer class, Queue
        private Item item;
        private Node<Item> next; 
    }
    
    // Initialize an empty Queue
    public Queue() {
        this.first = null;
        this.last = null;
        this.n = 0;
    }
    
    // Returns true if the queue is empty
    public boolean isEmpty() {
        return n == 0;
    }
    
    // Returns the number of items in the queue. 
    public int size() {
        return n;
    }
    
    // Returns the item least recently added added to this queue.
    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("queue underflow");
        return first.item;
    }
    
    // Adds the item to this queue. 
    public void enqueue(Item item) {
        Node<Item> oldLast = last;
        last = new Node<Item>();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else           oldLast.next = last;
        n++;
    }
    
    // Removes and return the item on this queue that was least recently added
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("queue underflow");
        Item returnItem = first.item;
        first = first.next;
        n--;
        return returnItem;
    }
    
    // Returns a String representation of this queue
    
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item: this) {
            s.append(item);
            s.append(" ");
        }
        return s.toString();
    }
    
    // Returns an iterator that iterates over the items in this queue in FIFO order.
    public Iterator<Item> iterator() {
        return new LinkedIterator(first);
    }

    private class LinkedIterator implements Iterator<Item> {
        
        private Node<Item> current;
        
        public LinkedIterator(Node<Item> first) {
            current = first;
        }
        
        @Override
        public boolean hasNext() {
            return current != null;
        }
        
        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
