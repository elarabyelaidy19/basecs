public class Dup2 { 
    public static Boolean dup2(int[] a) { 
        for(int i = 0; i < a.length; i++) { 
            if(a[i] == a[i+1]) { 
                return true; 
            }
        }
        return false;
    }

    public static int[] makeArray(int N) { 
        int[] A = new int[N]; 
        for(int i = 0; i < N; i++) { 
            A[i] = i; 
        }
        return A;
    }

    public static void main(String[] args) { 
        int N = Integer.parseInt(args[0]); 
        int[] A = makeArray(N); 
        System.out.println(dup2(A)); 
    }
    
}
