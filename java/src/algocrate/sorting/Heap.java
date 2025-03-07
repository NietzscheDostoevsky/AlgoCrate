/******************************************************************************
 * Sorting an 0-index array using HeapSort algorithm. 
 * 
 * The class Heap provides a static method sort() to sort an array using heapsort
 * The sorting algorithm is NOT stable. 
 *
 * This implementation takes time O(log n) to sort.
 * This implementation takes O(1) extra space.  
 ******************************************************************************/

package algocrate.sorting;

public class Heap {
	
	// This class cannot be instantiated.
	private Heap() {
	}

	// Rearrange the array in ascending otder, using natural order of the
	// elements/keys.
	@SuppressWarnings("rawtypes")
	public static void sort(Comparable[] pq) {
		int n = pq.length;
		
		//Heapify
		for (int k = n/2; k >=1; k--)
			sink(pq, k, n);
		
		// sortdown from the top node
		
		int k = n;
		while (k > 1) {
			exch(pq, 1, k--);
			sink(pq, 1, k);
		}
	}

	/***************************************************************************
	 * Helper functions to restore the heap invariant.
	 ***************************************************************************/

	private static void sink(@SuppressWarnings("rawtypes") Comparable[] pq, int k, int n) {
		while (2*k <= n) { 						   // there still exists a child for the node
			int j = 2*k;						  // the child node index from parent k
			if (j < n && less(pq, j, j+1)) j++;  // if right node is larger than the left node, move to right node
			if (!less(pq, k, j)) break; 	    // if parent is larger than right node as well, break the loop
			exch(pq, k, j);					   // swap parent with child
			k = j; 							  // move down the tree
		}
	}

	/***************************************************************************
	 * Helper functions for comparisons and swaps. Indices are "off-by-one" to
	 * support 1-based indexing used in pq algos.
	 ***************************************************************************/
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static boolean less(Comparable[] pq, int i, int j) {
		return pq[i-1].compareTo(pq[j-1]) < 0;
	}

	private static void exch(Object[] pq, int i, int j) {
		Object temp = pq[i-1];
		pq[i-1] = pq[j-1];
		pq[j-1] = temp;
		
	}
	
}
