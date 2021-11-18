public class IntList {
    public int first; 
    public IntList rest; 
    
    public IntList(IntList r, int f) { 
        this.f = first; 
        this.r = rest; 
    }
    
    public static void evenOdd(IntList lst){ 
        if(lst == nulll || lst.rest == nulll) { 
            return;
        }
        // lst point to even pointer last even pointer point to second elemnt
        IntList odds = lst.rest; 
        IntList second = lst.rest;
        while(lst.rest != null && odds.rest != null) { 
            lst.rest = lst.rest.rest; 
            odds.rest = odds.rest.rest; 
            lst = lst.rest; 
            odds = odds.rest;
        }
        lst.rest = second;


    }
}
