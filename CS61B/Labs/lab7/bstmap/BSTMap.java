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

    public size() { 
        return size;
    } 

    public Node put(K k, V v) { 
        return put(root, k, v); 
        size += 1;
    }

    private Node put(Node node, K k, V v) { 
        if(node == null) { 
            return new Node(k, v);
        }

        int cmp = k.compareTo(node.k); 
        if(cmp > 0) { 
            node.right = put(node.right, k, v);
        } else if (cmp < 0) { 
            node.left = put(node.left, k, v);
        } else { 
            node.value = v; 
        }

        return node;
    } 

    public Set<K> keySet() { 
        HashSet<K> set = new HashSet<>();
        addKeys(root, set); 
        return set;
    }

    private void addKeys(Node node, Set<K> set) { 
        if(node == null) 
            return;

        set.add(node.key); 
        addKeys(node.left, set); 
        addKeys(node.right, set);
    } 

    private Node remove(Node node, K k) { 
        if(node == null) { 
            return null;
        }

        int cmp = k.compareTo(node.k); 
        if(cmp > 0) { 
            node.right = remove(node.right, K);
        }else if (cmp < 0) { 
            node.left= remove(node.left, k);
        }else { 
            if(node.left == null) { 
                return node.right;
            } 
            if(node.right == null) { 
                return node.left;
            }

            Node originalNode = node; 
            node = getMin(node.right);
            node.left = originalNode.left; 
            node.right = remove(originalNode.right, node.k);
        }
        return node;
    } 

    private Node getMin(Node node) {  
        if(node.left == null) { 
            return node;
        }
        return getMin(node.left);
    }

    public V remove(K k, V v) { 
        if(containsKey(k)) { 
            V targetValue = get(k); 
            if(targetValue.equals(v)) { 
                root = remove(root, k); 
                size--; 
                return targetValue;
            }
        }
        return null;
    }

    public Iterator<K> iterator() { 
        return keySet().iterator;
    }

    public void printOrder() { 
        printOrder(root);
    }

    private printOrder(Node node) { 
        if(node == null) { 
            return;
        }

        printOrder(node.left); 
        System.out.println(node.key.toString() + " -> " + node.value.toString()); 
        printOrder(node.right);
    }


    


    
}
