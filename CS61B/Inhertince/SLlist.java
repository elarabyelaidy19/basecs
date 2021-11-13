public class SLlist<Blorb> implements List<Blorb> {
 
    public class Node {
        public Blorb item;
        Node next;
        public Node(Blorb item, Node next) {
            this.item = item;
            this.next = null;
        }
    }

    private Node head; 
    private int size; 
    
    public SLlist() {
        head = new Node(null, null);
        size = 0;
    }

    public SLlist(Blorb item) {
        size = 1; 
        head.next = new Node(null, null); 
        head = new Node(item, null); 
    }

    public void addFirst(Blorb item) { 
        Node oldHead = head.next; 
        Node newHead = new Node(item, oldHead); 
        head.next = newHead; 
        size++;
    } 

    public Blorb getFirst() { 
        if (size == 0) { 
            return null;
        }

        return head.next.item;
    }


    public void addLast(Blorb item) { 
       size += 1; 
       Node curNode = head; 

       while(curNode.next != null) { 
           curNode = curNode.next; 
       }

       curNode.next = new Node(item, null);
    }

    

}
