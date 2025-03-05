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
	
	private int maxN;		//Maximum number of elements on PQ, not using dynamic resizing.
	private int n;			//number of elements on PQ
	private int[] pq;		//binary heap using 1 based indexing
	private int[] qp;		//inverse of pq -> qp[pq[i]] = pq[qp[i]] = 1
	private Key[] keys; 	//keys[i] = priority of i
	
	
	// Constructor for an empty PQ with fixed initial capacity of maxN
	@SuppressWarnings("unchecked")
	public IndexMinPQ(int maxN) {
		if (maxN < 0) throw new IllegalArgumentException();
		this.maxN = maxN;
		n = 0;
		keys = (Key[]) new Comparable[maxN + 1];
		pq = new int[maxN + 1];
		qp = new int[maxN + 1];
		
		for (int i = 0; i <= maxN; i++)
			qp[i] = -1; 					//signifies empty index		
	}
	
	// returns true if this pq is empty 
	public boolean isEmpty() {
		return n == 0;
	}
	
	// Is index i on this pq? 
	public boolean contains(int i) {
		validateIndex(i);
		return qp[i] != -1; 				//By definition
	}
	
	// Returns the number of keys on this pq
	public int size() {
		return n;
	}
	
	// Associates key with index i
	public void insert(int i, Key key) {
		validateIndex(i);
		if (contains(i)) throw new IllegalArgumentException("index is already on the PQ");
		n++;
		qp[i] = n;
		pq[n] = i;
		keys[i] = key;
		swim(n);
	}
	
	// Returns an index associated with a minimum key
	public int minIndex() {
		if (n == 0) throw new NoSuchElementException("Priority queue underflow");
		return pq[1];
	}
	
	// Returns a minimum key. 
	public Key minKey() {
		return keys[minIndex()];
	}
	
	// Removes a minimum key and returns its associated index.
	public int delMin() {
		if (n == 0) throw new NoSuchElementException("Priority queue underflow");
		int min = pq[1];
		exch(1, n--); 				// put the last node at the top
		sink(1); 	  				// restore heap
		assert min == pq[n + 1];	// sanity check for n
		qp[min] = -1;				// delete
		keys[min] = null;			// avoid lingering
		pq[n + 1] = -1;				// not needed anymore
		return min;
	}
	
	// Returns the key assocaited with index i
	public Key keyOf(int i) {
		if (!contains(i)) throw new NoSuchElementException("index not in pq");
		else return keys[i];
		
	}
	
	// Change the key associated with index i to the specified value. 
	public void changeKey(int i, Key key) {
		if (!contains(i)) throw new NoSuchElementException("index not on pq");
		keys[i] = key;
		swim(qp[i]);
		sink(qp[i]);
	}
	
	// Decreaase the key associated with index i to the specified value. 
	public void decreaseKey(int i, Key key) {
		if (!contains(i)) throw new NoSuchElementException("index not on the PQ");
		if (keys[i].compareTo(key) == 0)
			throw new IllegalArgumentException("calling decreaseKey() with a key equal to the key in the PQ");
		if (keys[i].compareTo(key) < 0) 
			throw new IllegalArgumentException("calling decreaseKey() with a key strictly greater than the key in the PQ");
		keys[i] = key;
		swim(qp[i]);
	}
	
	// Increase the key associated with index i to the specified value. 
	public void increaseKey(int i, Key key) {
		if (!contains(i)) throw new NoSuchElementException("index not on the PQ");
		if (keys[i].compareTo(key) == 0)
			throw new IllegalArgumentException("calling increaseKey() with a key equal to the key in the PQ");
		if (keys[i].compareTo(key) > 0) 
			throw new IllegalArgumentException("calling increaseKey() with a key strictly less than the key in the PQ");
		keys[i] = key;
		sink(qp[i]);
	}
	
	// Remove the key associated with index i
	public void delete(int i) {
		if (!contains(i)) throw new NoSuchElementException("index not on the PQ");
		int index = qp[i];
		exch(index, n--);
		swim(index);
		sink(index);
		keys[i] = null;
		qp[i] = -1;
	}
	
	// throw an IllegalArgumentException if i is an invalid index
	private void validateIndex(int i) {
		if (i < 0) throw new IllegalArgumentException("negative index : " + i);
		if (i >= maxN) throw new IllegalArgumentException("index >= capacity: " + i);
	}
	
	/***************************************************************************
	 * General helper functions.
	 ***************************************************************************/
	
	// is key i greater than j
	private boolean greater(int i, int j) {
		return keys[pq[i]].compareTo(keys[pq[j]]) > 0;
	}
	
	// exchange values at index i and j
	private void exch(int i, int j) {
		int temp = pq[i];
		pq[i]= pq[j];
		pq[j] = temp;
		qp[pq[i]] = i;
		qp[pq[j]] = j;
	}
	
	/***************************************************************************
	 * Heap helper functions.
	 ***************************************************************************/
	
	// Swim a node from bottom to up 
	private void swim(int k) {
		
	}
	
	// Sink a node from top to bottom
	private void sink(int k) {
		
	}
	
	/***************************************************************************
	* Iterator
	***************************************************************************/
	
	// Returns an iterator that iterates over the keys on the pq in "ascending order"
	//		Doesn't implement remove()
	
	@Override
	public Iterator<Integer> iterator() {
		return new HeapIterator();
	}
	
	private class HeapIterator implements Iterator<Integer> {

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Integer next() {
			// TODO Auto-generated method stub
			return null;
		}
		
		public void remove() {
			
		}
	}
}