class Sort {
    public static void sort( String[] x) { 
        // 1- find smallest 
    }

    public static String findSmallest(String[] input) { 
        int smallestIndex = 0; 
        for(int i = 0; i<input.length; i++) { 
            int cont = input[i].compareTo(input[smallestIndex]);

            if(cont<0) { 
                smallestIndex = i;
            }
            
        }
        return input[smallestIndex];
    }
    
}
