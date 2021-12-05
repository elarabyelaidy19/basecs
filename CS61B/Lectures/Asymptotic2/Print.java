public class Print {
    
    public static void printParty(int N) { 
        for(int i = 1; i <= N; i = i * 2) { // 1 + 2 + 4 + 8 + ...... + N = 2N - 1 === > 0(N)
            for(int j = 0; j < i; j += 1) { 
                System.out.println("Test"); 
                int SUM = 1 + 1;
            }
        }
    }

    public static void main(String[] args) {
        printParty(3);
    }
}
