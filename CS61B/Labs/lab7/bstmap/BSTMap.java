public class BSM<K extends Comparable<K>, v> implements Map61B<K, V> { 

    private class Node { 
        public final K key; 
        public V value; 
        public Node left; 
        public Node right;
        
        public Node(K k, V v) { 
            this.v = value; 
            this.k = key;
        }
    }

    private Node root; 
    private int size = 0; 

    public clear() { 
        root = null; 
        size = 0;
    }

    public boolean containsKey(K k) { 
        return containsKey(root, k);
    }

    private boolean containsKey(Node node, K k) { 
        if(node == null) { 
            return null;
        }

        int cmp = k.compareTo(node.k); 
        
        if(cmp > 0) { 
            return containsKey(node.right, k)
        } else if (cmp < 0) { 
            return containsKey(node.left, k); 
        }
        return true;
       
    }

    public V get(K k) { 
        return get(root, k);
    }

    private get(Node node, K k) { 
        if(node == null) { 
            return null;
        }

        int cmp = k.compareTo(node.k); 
        if(cmp > 0) { 
            return get(node.right, k);
        } else if { 
            return get(node.left, k);
        }

        return node.value;
    }

    


    
}
