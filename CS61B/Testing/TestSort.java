public class TestSort {
    public static void sortTest() { 
        String[] input = {"i", "have", "an", "egg"}; 
        String[] expected = {"an", "egg", "have", "i"}; 

        Sort.sort(input);  
        
    
        /* org.junit.Assert.asserEquals(); */


        for(int i = 0; i<input.length; i++) { 
            if(input[i] != expected[i]) { 
                System.out.println("mismatch at inndex "+ i + " input should be "+ input[i]+" and got "+expected[i]);
                return;
            }
        }
        /* 
        if(input != expected) { 
            System.out.println("what the hell is this");
        }
        */
       

    }
    
    public static void main(String[] args) {
        sortTest();
    }
}