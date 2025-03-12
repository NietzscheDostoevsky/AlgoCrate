package algocrate.searching;

import algocrate.dataStructures.Queue;

/******************************************************************************
 * Unordered Symbol Table (Sequential Search ST) using a Singly Linked List.
 *
 * The SequentialSearchST class represents an (unordered) symbol table of generic 
 * key-value pairs. It supports the following operations:
 *      - put(key, value)    : Insert a key-value pair or update an existing key.
 *      - get(key)           : Retrieve the value associated with a key.
 *      - contains(key)      : Check if a key exists in the symbol table.
 *      - delete(key)        : Remove a key and its associated value.
 *      - size()             : Return the number of key-value pairs.
 *      - isEmpty()          : Check if the symbol table is empty.
 *      - keys()             : Iterate over all keys in the table.
 *
 * Implementation Details:
 *  - Uses a **singly linked list** to store key-value pairs.
 *  - Performs **sequential search** to locate keys.
 *  - Does **not** use `compareTo()` or `hashCode()`—keys are checked using `equals()`.
 *  - The value associated with a key **cannot** be `null`; setting a value to `null` is equivalent to deletion.
 *  
 * Performance:
 *  - **put()** and **delete()**: Worst-case Θ(N) time.
 *  - **get()** and **contains()**: Worst-case Θ(N) time.
 *  - **size()** and **isEmpty()**: Θ(1) time.
 *  - **Construction**: Θ(1) time.
 *
 * This data structure is simple but inefficient for large datasets.
 * Consider using a **binary search tree (BST)** or **hash table** for better performance.
 *
 * Reference:
 * *Algorithms, 4th Edition* by Robert Sedgewick and Kevin Wayne.
 ******************************************************************************/


public class SequentialSearchST<Key, Value> implements UnorderedST<Key, Value> {
    
    private int n;      // number of key-value pairs 
    private Node first; // first node of the linked-list containing key-value pairs
    
    // Node for constructino of Linked List
    private class Node {
        private Key key;
        private Value value;
        private Node next;
        
        public Node(Key key, Value value, Node next) { // Node constructor with given key, value and next node link
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
    
    // Constructor initialize an empty symbol table
    public SequentialSearchST() {  
    }
    
    // Returns the number of key-value pairs in this symbol table
    public int size() {
        return n;
    }
    
    // Returns true if this symbol table is empty
    public boolean isEmpty() {
        return n == 0;
    }
    
    // Returns true if this symbol table contains the specified key.
    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }
   
    // Returns the value associated with the given key in this symbol table
    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("Argument to get() is null");
        
        // parse the linked list and search the key provided, terminate if found
       for (Node x = first; x != null; x = x.next)
           if (x.key.equals(key)) return x.value;
       return null; // key not found
    }
    
    // Insert the specified key-value pair into the symbol table, overwriting the old value with the new value.
    public void put(Key key, Value value) {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");
        if (value == null) {
            delete(key); // design choice
            return;
        }
        
        // parse linked list to see if the key is already on the symbol table
        for (Node x = first; x != null; x = x.next) {
           if (x.key.equals(key)) {
               x.value = value;
               return;
           }
        }
        
        // key not already on the table, create new Node, append it to the Linked list
        first = new Node(key, value, first);
        n++; // increase the total number of key-value pairs on the table
    }
    
    // Removes the specified key and its associated value from this symbol table
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");
        first = delete(first, key);
    }
    
    // deletes key in the linked list beginning at Node x
    // Can lead of stack overflow
    // TODO replace with iterative version
    private Node delete(Node x, Key key) {
       if (x == null) return null;   // Base case, end of list, return null. 
       if (key.equals(x.key)) {
           n--;
           return x.next;            // removed the node by returning its next node.
       }
       x.next = delete(x.next, key); // Recursively deletes in the rest of the list
       return x;                     // Return the current node. 
    }
    
    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<>();
        for (Node x = first; x != null; x = x.next)
            queue.enqueue(x.key);
        
        return queue;
    }
}
