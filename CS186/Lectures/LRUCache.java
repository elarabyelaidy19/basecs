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


    public LRUCache() { 
        this.capacity = capacity;
        clear();
    }

    public String toString() { 
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

    



    
}