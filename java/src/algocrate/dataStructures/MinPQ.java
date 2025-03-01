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

import javax.swing.JComboBox.KeySelectionManager;

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
	
	
	
	@Override
	public Iterator<Key> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}

























