public class Dup {
    
    public boolean dup1(int[] array) { 

        int N  = array.length; 

        // Runtime O(n) 
        // Memory O(1)
        for(int i = 0; i < N; i+= 1) { 
            if(array[i] == array[i+1]) 
                return true;
            
        }
        return false;
    }


    public boolean dup2(int[] array) { 
        int N  = array.length; 

        // Rutime O(n^2) ====> N(N-1)/2, Area of the triangle
        // Memory O(1)
        for(int i = 0 ; i<N; i+= 1) { 
            for(j = 0; j<N; j+= 1) { 
                if(array[i] == array[j]) 
                    return true;
            }
        }
        return false;
    }
}
