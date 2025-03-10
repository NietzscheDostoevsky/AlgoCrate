package algocrate.searching;

/**
 * Interface for an Ordered Symbol Table abstract DataType.
 * 
 * For functionality regarding methods, see {@link OrderedST.java}.
 */

public interface UnorderedST<Key, Value> extends SymbolTable<Key, Value>{
	
	void put(Key key, Value value);
	Value get(Key key);
	void deleteKey(Key key);
	boolean contains(Key key);
	boolean isEmpty();
	int size();
	Iterable<Key> keys();
}
