public class TrieHT<Value> { 
    private static final int R = 256; 

    private Node root; 
    private int N; 

    private static class Node { 
        private Object val; 
        private Node[] next = new Node[R];
    }

    public TrieHT() { 
    }

    public Value get(String key) {  
        if (key == null) throw new IllegalArgumentException();
        Node x = get(root, key, 0); 
        if (x == null) return null; 
        return (Value) x.val; 
    }  

    public boolean contains(String key) { 
        if (key == null) throw new IllegalArgumentException(); 
        return get(key) != null;
    }

    private Node get(Node x, String key, int d) { 
        if (x == null) return null; 
        if (d == key.length()) return x; 
        char c = key.charAt(d);
        return get(x.next[c], key, d+1);
    } 

    public void put(String key, Value val) { 
        if (key == null) throw new IllegalArgumentException(); 
        if (val == null) delete(key); 
        
    }

    private void put(Node x, String key, Value val, int d) { 
        if (x == null) x = new Node(); 
        if (d == key.length()) { 
            if(x.val == null) N++; 
            x.val = val; 
            return x; 
        }

        char c = key.charAt(d); 
        x.next[c] = put(x.next[c], key, val, d+1);
    }

}