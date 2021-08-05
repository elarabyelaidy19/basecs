public class Fibonatchi { 

  public static int fibo(int n) { 
    if (n <= 1) { 
      return n; 
    } else { 
      return fibo(n-1) + fibo(n-2);
    }
  }

  public static int fibo2(int n, int k,int f0, int f1 ) {
     
    if (n == k) { 
       return f0; 
    } else { 
       return fibo2(n, k + 1, f1, f0 + f1);
    }
  }


  public static void main(String[] args) {
    int n = 9;
    int f0 = 7; int f1 = 8; int k = 9;
    System.out.println(fibo2(n, k, f0, f1));
  }
    
}


