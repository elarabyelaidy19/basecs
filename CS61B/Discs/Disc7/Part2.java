package CS61B.Disc.Disc7;

public class Part2 {
    
    public static int primesFactor(int N) { 
        int factor = 2; // 
        int count = 0;

        while(factor * factor <= N) { 
            while(N % factor == 0) { 
                System.out.println(factor); // 2  2  5  5
                count += 1; // 1  2  3   4
                N /= factor; // 50  25  5 1

            }
            factor += 1; //  3  4   5 6
        }
        return count;
    }

    public static void main(String[] args) {
        int N = 100;
        System.out.println(primesFactor(N));
    }

}