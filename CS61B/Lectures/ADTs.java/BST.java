private class BST<Key> {
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

}
