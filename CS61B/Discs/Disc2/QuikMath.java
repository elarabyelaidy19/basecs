public class QuikMath {
    public static void multiblyBy3(int[] A) { 
        for (int x : A) { 
            x = x * 3;
        }
    }

    public static void multiblyBy2(int[] A) { 
        int[] B = A; 
        for(int i = 0; i < B.length; i+= 1) { 
            B[i] *= 2; 
        }
    }

    public static void swap(int A, int B) { 
        int temp = A; 
        A = B; 
        B = temp;
    }


    public static void main(String[] args) {
        int[] arr;
        arr = new int[]{2, 4, 3, 6}; 
        multiblyBy3(arr); 

        arr = new int[] { 2, 4, 3, 6 }; 
        multiblyBy2(arr); 

        int a = 7; 
        int b = 11; 
        swap(a, b);

    }

}
