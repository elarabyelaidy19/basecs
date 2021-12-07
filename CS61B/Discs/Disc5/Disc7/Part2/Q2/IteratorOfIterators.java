import java.util.Iterator;
import java.util.LinkedList;

public class IteratorOfIterators implements Iterator<Integer>  { 
    LinkedList<Iterator<Integer>> iterators;

    public IteratorOfIterators(LinkedList<Iterator<Integer>> a) {
        iterators = new LinkedList<>();
        for(Iterator<Integer> iterator : a) { 
            if(iterator.hasNext()) { 
                iterators.add(iterator);
            }
        }
    }

    public boolean hasNext(){ 
        return !iterators.hasNext(); 
    }

    public Integer next(){ 
        
        if(!iterator.hasNext()) { 
            throw new NoSuchElementException();
        }

        Iterator<Integer> iterator = iterators.removeFirst();
        Integer next = iterator.next();
        if(iterator.hasNext()) { 
            iterators.add(iterator);
        }
        return next;
    }




    
}
