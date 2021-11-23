public class Dup1 { 
    public static Boolean dup1(int[] a) { 
        for(int i = 0; i < a.length; i++) { 
            for(int j = i+1; j < a.length; j++) { 
                if(a[i] == a[j]) { 
                    return true; 
                }
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
        System.out.println(dup1(A)); 
    }
    
}
