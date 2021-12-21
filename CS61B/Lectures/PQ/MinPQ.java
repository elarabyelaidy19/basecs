import java.util.Comparator;
import java.util.NoSuchElementException;

public class MinPQ<Key> implements Iterable<Key> {
    private Key[] pq; 
    private int N;  
    private Comparator<Key> comparator;

    public MinPQ(int initCapacity) {
        pq = (Key[]) new Object[initCapacity + 1];
        N = 0;
    }

    public MinPQ() {
        this(1);
    }

    public MinPQ(int initCapacity, Comparator<Key> comparator) { 
        this.comparator = comparator; 
        pq = (Key[]) new Object[initCapacity+1]; 
        N = 0;
    }

    public MinPQ(Comparator<Key> comparator) { 
        this(1, comparator);
    }

    public MinPQ(Key[] keys) { 
        n = keys.length; 
        pq = (Key[]) new Object[keys.length + 1]; 
        for(int i = 0; i < n; i++) { 
            pq[i+1] = keys[i]; 
        } 
        for(int k = n/2; k >= 1; i--) { 
            sink(k);
        }

    }  

    public boolean isEmpty() { 
        return N == 0;
    }

    public int size() { 
        return N;
    }

    public Key min() { 
        if (isEmpty()) { 
            throw new NoSuchElementException("Prority Queue underflow");
        }
        return pq[1];
    } 

    




}
