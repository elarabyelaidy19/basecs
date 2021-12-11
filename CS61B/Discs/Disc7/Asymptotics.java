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


    public void silly(int[] arr) { // O(log N)
        if(arr.length  <= 1) 
            System.out.println("you win");  

        int newLen = arr.length / 2; 
        int[] firstHalf = new int[newLen]; 
        int[] secondHalf = new int[newLen]; 

        System.arraycopy(arr, 0, firstHalf, 0, newLen); // O(N) 
        System.arraycopy(arr, newLen, secondHalf, 0, newLen); // O(N)
        silly(firstHalf); // O(N)
        silly(secondHalf); // O(N)

        // the outer function takes O(log N) 
        // the inner functions  takes O( 4 N) 
        // the overall runtime  O(NlogN)
    } 

    public static boolean findSum(int[] A, int x) { 
        for(int i = 0; i < A.length; i+= 1) { 
            for(int j = 0; j < A.length; j+= 1) { 
                if(A[i] + A[j] == x) // O(N^2)
                    return true;
            }
        }
        return false;
    }

    
    

}
