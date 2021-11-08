package Alists;
public class Alist {
    private int size; 
    private int[] items;  

    public Alist() { 
        items = new int[100]; 
        size = 0;
    }

    public int getlast() { 
        return items[size - 1];
    }

    private void resize(int capacity) { 
        int[] a = new int[capacity]; 
        System.arraycopy(items, 0, a, 0, size); 
        a = items;
    }

    public void addLast(int x) {  
        if(size == items.length) { 
            resize(size * 2); 
        }
        items[size] = x; 
        size += 1;
    }

    public int get(int i) { 
        return items[i];
    }

    public int size() { 
        return size;
    }

    public int removeLast() { 
        int x = items[size - 1]; 
        items[size - 1] = 0; 
        size -= 1; 
        return x; 
    }

}
