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

    private void resize(int capacity) { 
        assert n < capacity; 
        Key[] temp = (Key[]) new Object[capacity]; 
        for(int i = 0; i <= n; i++) { 
            temp[i] = pq[i];
        }
        pq = temp;
    } 

    private void exchange(int i, int j) { 
        int temp = i; 
        i = j; 
        j= temp;
    }

    private boolean greater(int i, int j) { 
        if(comparator == null) { 
            return ((Comparable<Key>) pq[i].compareTo(pq[j]) > 0;
        } else { 
            return comparator.compare(pq[i], pq[j]);
        }
    }

    












}
