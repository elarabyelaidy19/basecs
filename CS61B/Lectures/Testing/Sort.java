class Sort {
    public static void sort( String[] x) { 
        // 1- find smallest  
        // 2- sort
        // 3- swap  

        sort(x, 0);
    }

    private static void sort(String[] x, int start) {  
        if (x.length == start) { 
            return;
        }
        int smallest = findSmallest(x, start); 
        swap(x, start, smallest);  
        sort(x, start+1);
    }

    public static int findSmallest(String[] input, int start) { 
        int smallestIndex = start;
        for(int i = start; i<input.length; i++) { 
            int cont = input[i].compareTo(input[smallestIndex]);

            if(cont<0) { 
                smallestIndex = i;
            }
            
        }
        return smallestIndex;
    }

    public static void swap(String[] x, int a, int b) { 
        String temp = x[a]; 
        x[a] = x[b]; 
        x[b] = temp;
    }

    public static void main(String[] args) {
        String[] arr = { "i", "have", "an", "egg" };
        sort(arr);
    }




    
}
