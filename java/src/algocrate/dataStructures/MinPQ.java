/******************************************************************************
 * The MinPQ class represents a priority queue of generic keys. It supports 
 * 		- insert
 * 		- delete the minimum
 * operations in O(logN) , N being the number of elements in the PQ
 * 
 * The implementation uses a Binary Heap data Structure to achieve this. 
 * 
 * 
 ******************************************************************************/

package algocrate.dataStructures;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MinPQ<Key> implements Iterable<Key> {

	private Key[] pq; 					// stores indices from 1 to N, 0 being empty for calculations in heap.
	private int N; 						// number of items on the PQ
	private Comparator<Key> comparator; // custom comparator if required
	
	// Constructor for empty PQ with a given initial capacity N
	@SuppressWarnings("unchecked")
	public MinPQ(int initialCapacity) {
		pq = (Key[]) new Object[initialCapacity + 1]; // 0th index to be left emtpy
		N = 0;
	}
	
	//Constructor for an emttpy PQ
	public MinPQ() {
		this(1);
	}
	
	// Constructor for an empty PQ with the given initial capacity, using the given comparator
	@SuppressWarnings("unchecked")
	public MinPQ(int initialCapacity, Comparator<Key> comparator) {
		pq = (Key[]) new Object[initialCapacity + 1]; 
		N = 0; 
		this.comparator = comparator;
	}
	
	// Constructor for an PQ using an array of Keys
	// 		Takes time proportional to the number of keys, using sink based heap construction.
	@SuppressWarnings("unchecked")
	public MinPQ(Key[] keys) {
		N = keys.length;
		pq = (Key[]) new Object[keys.length + 1];
		for (int i = 0; i < N; i++) 
			pq[i+1] = keys[i]; // initialize the array using keys, with 0 index empty.
		for (int k = N/2; k >= 1; k--) 
			sink(k); // heapify the array
		assert isMinHeap();
	}
	
	// Constructor for empty PQ with a given comparator. 
	public MinPQ(Comparator<Key> comparator) {
		this(1, comparator);
	}
	
	// Returns the number of keys in this PQ
	public int size() {
		return N;
	}
	
	// Returns if the PQ is empty of not
	public boolean isEmpty() {
		return N == 0;
	}
	
	// Returns the smallest key on the PQ
	public Key min() {
		if (isEmpty()) throw new NoSuchElementException("Priority Queue underflow");
		return pq[1]; // min pq has the smallest element @index 1
	}
	
	// Resize the underlying array to have the given capacity
	private void resize(int capacity) {
		assert capacity > N; 
		@SuppressWarnings("unchecked")
		Key[] temp = (Key[]) new Object[capacity];
		for (int i = 1; i < capacity; i++)
			temp[i] = pq[i];
		pq = temp;
	}
	
	// Adds new key to the PQ
	public void insert(Key x) {
		// double the array size if necessary. 
		if (N == pq.length - 1) resize(2 * pq.length); 
		
		//add x to the pq, and swim it to maintain the heap invariant ( Page 317, Algorithms, 4th ed)
		pq[++N] = x;
		swim(N);
		assert isMinHeap();
	}
	
	// Remove and return the smallest key on the PQ
	public Key delMin() {
		if(isEmpty()) throw new NoSuchElementException("Priority Queue Underflow");
		Key minKey = pq[1];
		exch(1,N--);
		sink(1);
		pq[N+1] = null; // avoid loitering
		
		//resize the array 
		if (N > (pq.length - 1) / 4) resize(pq.length / 2);
		assert isMinHeap();
		return minKey;
	}
	
	/***************************************************************************
	 * Helper functions to restore the heap invariant.
	 ***************************************************************************/
	
	//Swim 
	private void swim(int k) {
		
	}
	
	//Sink
	private void sink(int k) {
		
	}
	
	/***************************************************************************
	 * Helper functions for compares and swaps in array
	 ***************************************************************************/
	
	//Comparison of keys
	
	private boolean greater(int i, int j) {
		if (comparator == null) {
			return ((Comparable<Key>) pq[i]).compareTo(pq[j]) > 0; // might cause ClassCastException, change TODO
		} else {
			return comparator.compare(pq[i], pq[j]) > 0;
		}
	}
	
	//Exchange/swap positions
	private void exch(int i, int j) {
		Key temp = pq[i];
		pq[i] = pq[j];
		pq[j] = temp;
	}
	
	//Sanity Check if the pq is in fact a min heap. 
	private boolean isMinHeap() {
		for (int i = 1; i <= N; i++) {
			if (pq[i] == null) return false;
		}
		for (int i = N + 1; i < pq.length; i++) {
			if (pq[i] != null) return false;
		}
		if (pq[0] != null) return false;
		return isMinHeapOrdered(1);
	}
	
	//Sanity check if subtree of pq[1...n] rooted at k is a min heap? 
	private boolean isMinHeapOrdered(int k) {
		if (k > N) return true; 								  // base condition, reached end of heap without any violations.
		
		int left = 2*k; 										  // binary heap property
		int right = 2*k + 1; 							    	  // binary heap property
		if (left  <= N && greater(k, left)) return false;   	  // binary heap violation, Every parent node is smaller than or equal to its children.
		if (right <= N && greater(k, right)) return false;  	  // binary heap violation
		return isMinHeapOrdered(left) && isMinHeapOrdered(right); // Recursively checks the left and right subtrees.
	}
	
	@Override
	public Iterator<Key> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}

























