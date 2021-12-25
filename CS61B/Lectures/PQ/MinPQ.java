import java.util.Comparator;
import java.util.NoSuchElementException;

public class MinPQ<Key> implements Iterable<Key> {
    private Key[] pq; 
    private int n;  
    private Comparator<Key> comparator;

    public MinPQ(int initCapacity) {
        pq = (Key[]) new Object[initCapacity + 1];
        n = 0;
    }

    public MinPQ() {
        this(1);
    }

    public MinPQ(int initCapacity, Comparator<Key> comparator) { 
        this.comparator = comparator; 
        pq = (Key[]) new Object[initCapacity+1]; 
        n = 0;
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
        return n == 0;
    }

    public int size() { 
        return n;
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

    public void insert(Key x) { 
        if(n == pq.length) resize(2 * pq.length); 
        pq[++n] = x;
        swim(n); 
        assert isMinHeap();
    }

    public Key delMin() { 
        if(isEmpty()) throw new  NoSuchElementException(); 
        Key min = pq[1]; 
        exchange(1, n--); 
        sink(1); 
        pq[n+1] = null; 
        if((n > 0) && (n == (pq.length - 1)/4)) resize(2*pq.length/2); 
        assert isMinHeap();
        return min;
    }

    // bubble up if parent(k/2) > children(k)
    private void swim(int k) { 
        while(i > 1 && greater(k/2, k)) { 
            exchange(k/2, k); 
            k = k/2;
        }
    }

    private void sink(int k) { 
        while(2*k <= n) { 
            j = 2*k; 
            if(j < n && greater(j, j+1)) j++; 
            if(!greater(k, j)) break; 
            exchange(k, j); 
            k = j;
        }
    }


    private void exchange(int i, int j) { 
        Key temp = i; 
        i = j; 
        j= temp;
    }

    private boolean greater(int i, int j) { 
        if(comparator == null) { 
            return ((Comparable<Key>) pq[i]).compareTo(pq[j]) > 0;
        } else { 
            return comparator.compare(pq[i], pq[j]);
        }
    } 

    public boolean isMinHeap() { 
        for(int i = 1; i < n; i++) { 
            if(pq[i] == null) return false;
        }
        for(int i = n+1; i < pq.length; i++) { 
            if(pq[i] != null) return false; 
        }
        if(pq[1] != null) return false; 
        return isMinHeapOrdered(1);
    }

    private boolean isMinHeapOrdered(int k) { 
        if(k > N) return true; 
        int left = k * 2; 
        int right = k * 2 + 1; 
        if((left <= n) && greater(left, k)) return false; 
        if((right <= n) && greater(right, k)) return false; 
        return isMinHeapOrdered(left) && isMinHeapOrdered(right);
    } 

    public Iterator<Key> iterator() {
        return new HeapIterator();
    }

    private class HeapIterator implements Iterator<Key> {
        // create a new pq
        private MinPQ<Key> copy;

        // add all items to copy of heap
        // takes linear time since already in heap order so no keys move
        public HeapIterator() {
            if (comparator == null) copy = new MinPQ<Key>(size());
            else                    copy = new MinPQ<Key>(size(), comparator);
            for (int i = 1; i <= n; i++)
                copy.insert(pq[i]);
        }

        public boolean hasNext()  { return !copy.isEmpty();                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Key next() {
            if (!hasNext()) throw new NoSuchElementException();
            return copy.delMin();
        }
    }


}
