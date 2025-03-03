/******************************************************************************
 * Minimum-oriented indexed priority queue (IPQ) using a binary heap.
 *
 * The IndexMinPQ class represents an indexed priority queue of generic keys.
 * It supports the following operations in O(log N) time (N being the number of elements):
 * 		- insert(index, key)        : Insert a key with a given index.
 * 		- delMin()                  : Delete the minimum key (highest priority).
 * 		- delete(index)             : Remove the key associated with an index.
 * 		- changeKey(index, newKey)  : Change the key at a given index.
 * 		- decreaseKey(index, newKey): Decrease the key value at an index.
 * 		- increaseKey(index, newKey): Increase the key value at an index.
 *
 * In order to let the client refer to keys in the PQ, an integer between 0 and maxN - 1 
 * is associated with each key. This integer is used to specify which key to delete or modify.
 *
 * Implementation Details:
 *  - Uses a **binary heap** stored in an array.
 *  - Maintains two auxiliary arrays (`pq` and `qp`) for fast index lookups.
 *  - Supports priority updates while maintaining the **min-heap property**.
 *
 * The **key** represents the priority of an item in the priority queue. 
 * The item with the smallest key (highest priority) is always at the front.
 * The PQ automatically reorders itself after any change to maintain the correct order.
 *
 * Edge Cases:
 *  - Attempting to access an invalid index results in an error.
 *  - Duplicate keys are allowed but may not behave predictably when updated.
 *  - `decreaseKey()` and `increaseKey()` should be used carefully to avoid logical errors.
 ******************************************************************************/

package algocrate.dataStructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IndexMinPQ<Key extends Comparable<Key>> implements Iterable<Integer> { //Key being generic, should be comaparable
																					//Iterable<Integer> ensures PQ itself can be iterated over, returning indices(not keys)
	
	private int maxN;		//Maximum number of elements on PQ
	private int n;			//number of elements on PQ
	private int[] pq;		//binary heap using 1 based indexing
	private int[] qp;		//inverse of pq -> qp[pq[i]] = pq[qp[i]] = 1
	private Key[] keys; 	//keys[i] = priority of i
	
	@Override
	public Iterator<Integer> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
}









































