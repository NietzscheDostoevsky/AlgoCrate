package algocrate.dataStructures;

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

}
