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
     

}












































