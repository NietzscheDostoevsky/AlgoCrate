package algocrate.searching;

public interface SymbolTable<Key, Value> {
     
    void put(Key key, Value value);
    Value get(Key key);
}
