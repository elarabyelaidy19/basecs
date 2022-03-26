package Lectures;

public class LRUCache<K, V> { 
    private int cachsize; 

    private int capacity; 

    private CacheNode<K, V> head; 

    private CacheNode<K, V> tail;

    private static class CacheNode<K, V> {
        K key;
        V val;

        CacheNode<K, V> next; 
        CacheNode<K, V> prev; 

        public CacheNode(K key, V val, CacheNode<K, V> next, CacheNode<K, V> prev) {
            this.key = key; 
            this.val = val; 
            
            this.next = next; 
            this.prev = prev;

        }
    }


    public LRUCache(int capacity) { 
        this.capacity = capacity;
        clear();
    }

     public String print() {
        String s = ""; 

        CacheNode<K, V> curr = head;

        while(curr != tail) { 
            s += "C" + curr.key +", " + curr.val + ")"; 
            
            if(curr.next != tail) 
                s += ", "; 

            curr = curr.next;
        }
        return s;
    }

    public void clear() { 
        head = new CacheNode<K, V>(null, null, null, null); 
        tail = new CacheNode<K, V>(null, null, head, null);
    }

    public int size() { 
        return cachsize;
    }

    public boolean isEmpty() { 
        return cachsize == 0;
    }

    public V LRUGet(K key) { 
        CacheNode<K, V> curr = head.next;

        while(curr != tail) { 
            if(curr.key.equals(key)) {
                moveNodeToTheEnde(curr);
                return curr.val;
            }
            curr = curr.next;
        }
        return null;
    }

    public void moveNodeToTheEnde(CacheNode<K, V> node) { 
        CacheNode<K, V> priorNode = node.prev; 
        CacheNode<K, V> nextNode = node.next; 
        priorNode.next = nextNode; 
        nextNode.prev = priorNode; 
        cachsize--;

        CacheNode<K, V> prevTail = tail.prev;
        prevTail.next = node; 
        tail.prev = node;
        node.next = tail; 
        node.prev = prevTail; 
        cachsize++;
    } 

    public void LRUPut(K key, V val) {
        CacheNode<K, V> curr = head.next; 
        CacheNode<K, V> prevTail = tail.prev;
        CacheNode<K, V> newNode = new CacheNode<K, V>(key, val, tail, prevTail); 
        prevTail.next = newNode; 
        tail.prev = newNode; 
        cachsize++;

        while(curr != tail) { 
            // if the key exits in the LRU update it's value and move it to the end  
            if(newNode.key.equals(curr.next.key)) { 
                newNode.next.val = curr.val; 
            }

            if(cachsize > capacity) { 
                CacheNode<K, V> first = head.next; 
                CacheNode<K, V> afterFirst = first.next;

                head.next = afterFirst; 
                afterFirst.prev = head; 
                cachsize--;
            }

            curr = curr.next;
        }
    } 


    public static  void main(String[] args) {
        LRUCache<Integer, Integer> cache = new LRUCache<Integer, Integer>(4);
		cache.LRUPut(1, 5);
		System.out.println("cache after calling LRUPUT(1,5): " + cache.toString());
		cache.LRUPut(2, 2);
		System.out.println("cache after calling LRUPUT(2,2): " + cache.toString());
		cache.LRUPut(3, 7);
		System.out.println("cache after calling LRUPUT(3,7): " + cache.toString());
		cache.LRUPut(4, 9);
		System.out.println("cache after calling LRUPUT(4,9): " + cache.toString());
		cache.LRUPut(1, 9);
		System.out.println("cache after calling LRUPUT(1,9): " + cache.toString());
		System.out.println("LRUGET(3) returned: " + cache.LRUGet(3));
		System.out.println("cache after calling LRUGET(3): " + cache.toString());
		cache.LRUPut(5, 10);
		System.out.println("cache after calling LRUPUT(5,10): " + cache.toString());
		cache.LRUGet(4);
		System.out.println("LRUGET(4) returned: " + cache.LRUGet(4));
		System.out.println("cache after calling LRUGET(4): " + cache.toString());
		cache.LRUGet(10);
		System.out.println("cache after calling LRUGET(10): " + cache.toString());
    }
}


