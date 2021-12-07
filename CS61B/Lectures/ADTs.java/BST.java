public class BST<Key> {
    private Key key; 
    private BST left; 
    private BST right; 


    public BST(Key key, BST left, BST right) { 
        this.key = key; 
        this.left = left; 
        this.right = right;
    }


    public BST(Key key) { 
        this.key = key;
    }


    static BST search(BST T, Key sk) { 
        if(T == null) 
            return null; 
        if(sk.equals(T.key)) 
            return T; 
        else if(sk < T.key) 
            return search(T.left, sk); 
        else 
            return search(T.right, sk); 

    } 

    static BST insert(Bst T, Key ik) { 
        if(T == null) 
            return new BST(ik); 
        if(ik < T.key) 
            T.left = insert(T.left, ik); 
        else if(ik > T.key) 
            T.right = insert(T.right, ik); 
        return T;
    }

    public static BST remove(BST T, int k) {
        if (T == null)return null;
        if (k < T.label) 
            T.left = remove(T.left, L);
        else if (k > T.label)
            T.right = remove(T.right, L);
        // Otherwise, we’ve found k
        else if (T.left == null) 
            return T.right;
        else if (T.right == null)
            return T.left;
        else T.right = swapSmallest(T.right, T);
        return T; }
        /** Move the labek from the first node in T (in an inorder*  traversal) to node R (over-writing the current labek of R),
         * *  remove the first node of T from T, and return the resulting tree.*/
        private static BST swapSmallest(BST T, BST R) {
            if (T.left == null) {R.label = T.label;
                return T.right;} 
            else { 
                T.left = swapSmallest(T.left, R);
            return T;
        }
        }



}
