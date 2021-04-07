package Question3;

public class CustomSymbolTable<Key extends Comparable<Key>, Value> {
	
    private Key[] keys;
    private Value[] values;
    private int n = 0;
    
    public CustomSymbolTable(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];
    }
    
    public Value get(Key key) {
    	int i = rank(key);
    	if(i < n && keys[i].compareTo(key) == 0)
    		return values[i];
    	else 
    		return null;
    }

    private int rank(Key key) {
    	int lo = 0, hi = n - 1;
    	while(lo <= hi) {
    		int mid = lo + (hi - lo) / 2;
    		int cmp = key.compareTo(keys[mid]);
    		
    		if(cmp < 0) 
    			hi = mid - 1;
    		else if(cmp > 0)
    			lo = mid + 1;
    		else if (cmp == 0)
    			return mid;
    	}
    	return lo;
    }
    
    public void put(Key key, Value value) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }

        int rank = rank(key);

        if (rank < n && keys[rank].compareTo(key) == 0) {
            values[rank] = value;
            return;
        }

        for(int i = n; i > rank; i--) {
            keys[i] = keys[i - 1];
            values[i] = values[i - 1];
        }
        keys[rank] = key;
        values[rank] = value;
        n++;
    }
}
