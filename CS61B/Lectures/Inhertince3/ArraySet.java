import java.util.Iterator;

public class ArraySet<T> implements Iterable<T>{ 
    private T[] items; 
    private int size; 

    public ArraySet() { 
        items = (T[]) new Object[100]; 
        size = 0;
    }

    public boolean conatain(T element) { 
        for(int i = 0; i<size; i+= 1) { 
            if(element.equals(items[i])) { 
                return true;
            }
        }
        return false;
    }

    public void add(T element) { 
        if (element == null) {
            throw new IllegalArgumentException("elemnt can not be null");
        }
        if(conatain(element)) { 
            return;
        }
        items[size] = element; 
        size += 1;
    }

    public int size() { 
        return size;
    } 


   
    public Iterator<T> iterator() {
        return new ArraySetIterator();
    }

    private class ArraySetIterator implements Iterator<T> { 
        private int pos;  

        public ArraySetIterator() { 
            int pos = 0;
        }

        public boolean hasNext() { 
            return pos < size;
        }

        public T next() { 
            T returnItem = items[pos];
            pos += 1; 
            return returnItem;
        }
        
    }
    // String builder is mutable it apped to the same String
    public String toString() { 
        StringBuilder str = new StringBuilder("{"); 
        for(int i = 0; i<size; i+=1) { 
            str.append(items[i].toString()); 
            str.append(", ");
        }

        str.append("}"); 
        return str.toString();
    }

    public boolean equals(Object other) { 
        if(this == other) { 
            return true;
        }

        if(other == null) { 
            return false;
        }

        if(other.getClass() != this.getClass()) { 
            return false;
        }

        ArraySet<T> o = (ArraySet<T>) other; 
        if(o.size != this.size) { 
            return false;
        }

        for(T item : this) { 
            if(!o.conatain(item)) { 
                return false;
            }
        }

        return true;
    }


    /*  
    inefficinet method evry call to the method it crete new string evry time and add the prev string again 
    public String toString() { 
        String str = "{";
        for(int i = 0; i<size; i+=1) { 
            str += items[i]; 
            str += ", ";
        }
        str += "}"; 
        return str;

    } */




    public static void main(String[] args) {
        ArraySet<Integer> aset = new ArraySet<>();
        aset.add(5);
        aset.add(23);
        aset.add(42);

        //iteration
        for (int i : aset) {
            System.out.println(i);
        }

        //toString
        System.out.println(aset);

        //equals
        ArraySet<Integer> aset2 = new ArraySet<>();
        aset2.add(5);
        aset2.add(23);
        aset2.add(42);

        System.out.println(aset.equals(aset2));
        System.out.println(aset.equals(null));
        System.out.println(aset.equals("fish"));
        System.out.println(aset.equals(aset));
        
    }

}