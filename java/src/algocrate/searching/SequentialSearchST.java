package algocrate.searching;

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
    
    // Constructor iniatilizint an empty symbol table
    public SequentialSearchST() {
        
    }
}