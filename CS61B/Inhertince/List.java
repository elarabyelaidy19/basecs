public interface List<Item> {
    public void addLast(Item x);  

    public void getLast(); 

    public void removeLast(); 

    public void addFirst(Item x); 

    public Item getFirst(); 

    public void insert(Item x, int position); 

    public int size();  

    public Item get(int position); 

    default public void print() { 
        for(int i = 0; i < size(); i++) {
            System.out.println(get(i)+" ");
        }
    }

}
