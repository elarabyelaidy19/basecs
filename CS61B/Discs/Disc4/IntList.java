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
        // second rever to the first odd ele
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

    public static IntList[] partition(IntList lst, int k) { 
        IntList array = new IntList[k]; 
        int index = 0; 
        IntList L = revers(lst); 
        while(L != null) { 
            IntList prevAtIndex = array[index]; 
            IntList next = L.rest; 
            array[index] = L; 
            array[index].rest = prevAtIndex; 
            L = next; 
            index = (index + 1) % array.length;
        }  

        return array;
    }
}
