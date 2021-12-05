public class Recurence {
    public static int f3(int n) { 
        if (n <= 1) 
            return 1; 
        
        return f3(-1) + f3(n-1);  
        // c(n) = 1 + 2 + 4 + .... + 2^n-1 = 2(Q) - 1 == 2(2^n) - 1 == 2^n
    }
}


