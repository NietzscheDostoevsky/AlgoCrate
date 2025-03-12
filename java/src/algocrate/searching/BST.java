package algocrate.searching;
/******************************************************************************
 * Ordered Symbol Table (Binary Search Tree - BST) using a Linked Structure.
 *
 * The BST class represents an **ordered symbol table** of generic 
 * key-value pairs. It supports the following operations:
 *      - put(key, value)    : Insert a key-value pair or update an existing key.
 *      - get(key)           : Retrieve the value associated with a key.
 *      - contains(key)      : Check if a key exists in the symbol table.
 *      - delete(key)        : Remove a key and its associated value.
 *      - size()             : Return the number of key-value pairs.
 *      - isEmpty()          : Check if the symbol table is empty.
 *      - min() / max()      : Retrieve the smallest/largest key.
 *      - floor(key)         : Largest key ≤ given key.
 *      - ceiling(key)       : Smallest key ≥ given key.
 *      - rank(key)          : Number of keys less than the given key.
 *      - select(k)          : Retrieve the k-th smallest key.
 *      - keys()             : Iterate over all keys in sorted order.
 *
 * Implementation Details:
 *  - Uses an **unbalanced binary search tree (BST)**.
 *  - Each node contains a key, value, and references to left and right subtrees.
 *  - The key type **must** implement Comparable.
 *  - The value associated with a key **cannot** be `null`; setting a value to `null` is equivalent to deletion.
 *  
 * Performance:
 *  - **put()**, **get()**, **contains()**, **delete()**, **rank()**: 
 *    Worst-case Θ(N) time (for a skewed tree), but expected Θ(log N) for a balanced tree.
 *  - **min()**, **max()**, **floor()**, **ceiling()**, **select()**: 
 *    Worst-case Θ(N), expected Θ(log N).
 *  - **size()**, **isEmpty()**: Θ(1) time.
 *  - **keys()**: Worst-case Θ(N) time (in-order traversal).
 *  - **Construction**: Θ(1) time.
 *
 * This implementation performs well for **randomly ordered insertions**, 
 * but can become inefficient (degrading to Θ(N) operations) if keys are inserted in 
 * sorted order without rebalancing. Consider using a **Red-Black BST** or **AVL Tree** 
 * for guaranteed logarithmic performance.
 *
 * Reference:
 * *Algorithms, 4th Edition* by Robert Sedgewick and Kevin Wayne.
 ******************************************************************************/

public class BST<Key extends Comparable<Key>, Value> implements OrderedST<Key, Value> {
     
    private Node root;          // root of BST
    
    private class Node {
        private Key key;        // sorted by key
        private Value value;    // associated value
        private Node left;      // left subtree
        private Node right;     // right subtree
        
        private int size;       // number of nodes in subtree rooted here.
                                // Every node maintains the invariant that 
                                // size(x) = size(x.left) + size(x.right) + 1
    
        public Node(Key key, Value value, int N) {
            this.key = key;
            this.value = value;
            this.size = N;
        }
    }
    
    // Initialize an empty symbol table 
    public BST() {
    }
  
    // Returns true if this ST is empty 
    public boolean isEmpty() {
        return size() == 0;
    }
    
    // Returns the number of key-value pairs in this symbol table.
    public int size() {
        return size(root);
    }
    
    // Returns the number of key-value pairs in a BST rooted at node x.
    private int size(Node x) {
        if (x == null)  return 0;
        else            return x.size;
    }
    
    // Does this ST contains the given key? 
    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("Argument to contains() is null");
        return get(key) != null;
    }
    
    // Returns the value associated with the given key
    public Value get(Key key) {
        return get(root, key);
    }
    
    // Searches the subtree rooted at Node X for the key, and returns the associated value, null if key is the subtree
    private Value get(Node x, Key key) {
        if (key == null) throw new IllegalArgumentException("calls get() with a null key");
        if (x == null) return null;
        int compare = key.compareTo(x.key);
        if      (compare > 0) return get(x.right, key);  // If key > root, look in the right node
        else if (compare < 0) return get(x.left, key);   // if key < root, look in the left node
        else                  return x.value;            // key == key @ root node.
    }
}












































