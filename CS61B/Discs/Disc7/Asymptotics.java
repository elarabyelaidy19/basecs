public class Asymptotics {
    
    public void asymp1(int[] a, int N, int M) {  
        boolean condition = true;
        for(int i = 0; i < N; i += 1) { 
            for(int j = 1 ; j < M; ) {  
                // Worst Case  equall == O(N * M)
                if(condition == true) 
                    j += 1; 
                else 
                // Best Case equall == O(log M * N)
                    j *= 2;   
            }
        }
    } 

    public int curse(int a) { 
        if(a == 0) 
            return 0; 

        return a + curse(a - 1); // Recursve call equall to a + 1 
        // O(N) Numbers of calls
    }   

    public static BST find(BST T, Key sk) { 
        if(T == null) 
            return null; 
        if(sk.compareTo(T.sk) == 0) // CompareTo  return false if the two value are equll
            return T;
        else if(sk.compareTo(T.sk) > 0)  // > 0 sk is greater  
            return find(T.right, sk);  
        else 
            return find(T.left, sk); 

        // O(log N)
    }   


    

}
