public class FillGrid {
    
    public static void fillGrid(int[][] grid, int[] LL, int[]UR) { 
        int N = grid.length; 
        int KR, KL; 
        KL= KR = 0; 
        // i in the LL > j in UR
        for(int i = 0; i<N; i+= 1) { 
            for(int j = 0; j<N; j += 1) { 
                if (i>j) { 
                    grid[i][j] = LL[KL]; 
                    KL += 1;
                }else if(j>i){ 
                    grid[i][j] = UR[KR]; 
                    KR += 1;
                }
            }
        }
    }

    public static void fillGrid2(int[][] grid, int[]UR, int[] LL) { 
        int N = grid.length; 
        int KL = 0; 
        int KR = 0; 
        for(int i = 0; i<N; i+=1) { 
            for(int j = 0; j<i; j+=1) { 
                grid[i][j] = LL[KL]; 
                KL += 1; 
            } 
            for(int j = i+1; j<N; j+= 1) { 
                grid[i][j] = UR[KR];
                KR += 1;
            }
        }
    }


    public static void fillGrid3(int[][] grid, int[]UR, int[] LL) { 
        int N = grid.length; 
        int KL = 0; 
        int KR = 0; 
        for(int i = 0; i<N; i+=1) { 
            System.arraycopy(LL, KL, grid[i], 0, i); 
            System.arraycopy(UR, KR, grid[i], i+1, N-i-1);
            KL += i; 
            KR += N - i - 1; 
        }
    }

    
}
