package algocrate.searching;

public interface SymbolTable<Key extends Comparable<Key>, Value> {
	
	void put(Key key, Value value);
	
}
