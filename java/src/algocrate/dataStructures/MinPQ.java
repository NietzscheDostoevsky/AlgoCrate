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

public class MinPQ<Key> implements Iterable<Key> {

	private Key[] pq; 					// stores indices from 1 to N, 0 being empty for calculations in heap.
	private int N; 						// number of items on the PQ
	private Comparator<Key> comparator; // comparator 
	
	// Constructor for an empty PQ
	@SuppressWarnings("unchecked")
	public MinPQ(int initialCapacity) {
		pq = (Key[]) new Object[initialCapacity + 1]; // 0th index to be left emtpy
		N = 0;
	}
	
	
	@Override
	public Iterator<Key> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}

























