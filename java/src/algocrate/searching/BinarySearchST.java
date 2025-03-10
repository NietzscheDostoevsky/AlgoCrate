package algocrate.searching;

/******************************************************************************
 * Ordered Symbol Table (Binary Search Tree - BST).
 *
 * The BST class represents an ordered symbol table of generic key-value pairs. 
 * It supports the following operations:
 *      - put(key, value)    : Insert a key-value pair or update an existing key.
 *      - get(key)           : Retrieve the value associated with a key.
 *      - contains(key)      : Check if a key exists in the symbol table.
 *      - delete(key)        : Remove a key and its associated value.
 *      - size()             : Return the number of key-value pairs.
 *      - isEmpty()          : Check if the symbol table is empty.
 *      - keys()             : Iterate over all keys in sorted order.
 * 
 * Ordered Operations:
 *      - min()      : Return the smallest key.
 *      - max()      : Return the largest key.
 *      - floor(key) : Return the largest key ≤ given key.
 *      - ceiling(key): Return the smallest key ≥ given key.
 *      - select(k)  : Return the k-th smallest key.
 *
 * Implementation Details:
 *  - Uses a **binary search tree (BST)** for ordered key-value storage.
 *  - Keys must implement **Comparable** to allow ordered comparisons.
 *  - Compares keys using `compareTo()` but does not use `equals()` or `hashCode()`.
 *  - Values **cannot** be `null`; setting a value to `null` is equivalent to deletion.
 *
 * Performance:
 *  - **put()** and **delete()**: Worst-case Θ(N), expected Θ(log N).
 *  - **get()**, **contains()**, **ceiling()**, **floor()**, **rank()**: Worst-case Θ(log N).
 *  - **size()**, **isEmpty()**, **min()**, **max()**, **select()**: Θ(1).
 *  - **Construction**: Θ(1).
 *
 * BSTs provide efficient ordered operations but can become unbalanced, leading to Θ(N) worst-case performance.
 * Consider using **Red-Black BSTs** or **AVL Trees** for balanced alternatives.
 *
 * Reference:
 * *Algorithms, 4th Edition* by Robert Sedgewick and Kevin Wayne.
 ******************************************************************************/


public class BinarySearchST<Key extends Comparable<Key>, Value> implements OrderedST<Key, Value> {

}
