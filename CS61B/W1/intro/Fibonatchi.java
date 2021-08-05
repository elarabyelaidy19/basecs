public class Fibonatchi { 

  public static int fibo(int n) { 
    if (n <= 1) { 
      return n; 
    } else { 
      return fibo(n-1) + fibo(n-2);
    }
  }


  public static void main(String[] args) {
    int n = 7;
    System.out.println(fibo(n));
  }
    
}


