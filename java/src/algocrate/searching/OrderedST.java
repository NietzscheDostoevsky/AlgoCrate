package algocrate.searching;

// Interface for an Ordered Symbol Table abstract DataType. 
public interface OrderedST<Key extends Comparable<Key>, Value> {
	
	void put(Key key, Value value); 	// put key-value pair into the table, remove key from table if value is null
	Value get(Key key); 				//value paired with key, null if key is absent
	void delete(Key key); 				//remove key and its value from table
	boolean contains(Key key); 			// is there a value paired with key?
	boolean isEmpty();					// is the table empty? 
	int size(); 						// number of key-value pairs
	Key min();							// smallest key
	Key max();							// largest key
	Key floor(Key key);					// largest key less than or equal to key
	Key ceiling(Key key);				// smallest key greater than or equal to key
	int rank(Key key);					// number of keys less than key
	Key select(int k);					// key of rank k
	
	default void deleteMin() {			// delete smallest key
		delete(min());
	}
	
	default void deleteMax() {			// delete largest key
		delete(max());
	}
	
	default int size(Key lo, Key hi) {	// number of keys in [lo...hi]
		if (hi.compareTo(lo) < 0) 
			return 0;
		else if (contains(hi)) 
			return rank(hi) - rank(lo) + 1;
		else return rank(hi) - rank(lo);
	}
	
	Iterable<Key> keys(Key lo, Key hi); // keys in [lo...hi] in sorted order
	
	default Iterable<Key> keys() {		// all keys in the table, in sorted order
		return keys(min(), max());
	}
}