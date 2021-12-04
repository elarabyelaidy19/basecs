import java.util.*;
public class FilteredList<T> implements Iterable<T> { 
    List<T> list; 
    Predicate<T> predicate;

    public FilteredList(List<T> list, Predicate<T> predicate) {
        this.list = list;
        this.predicate = predicate;
    }

    public Iterator<T> iterator() { 
        return new FilteredListIterator(); 
    }

    private class FilteredListIterator implements Iterator<T> { 
        int index; 

        public FilteredListIterator() { 
            index = 0; 
            moveIndex();
             
        }
    

    public boolean hasNext() { 
        return index < list.size();
    }

    public T next() { 
        if(!hasNext()) { 
            throw new NoSuchElementException();
        }

        T item = list.get(index); 
        index += 1;  
        moveIndex();
        return item;
        
    }

    private void moveIndex() { 
        while(hasNext() && !predicate.test(list.get(index))) { 
            index += 1; 
        }
    }

}
}
