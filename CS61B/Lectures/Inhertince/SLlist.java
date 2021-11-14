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

    private Node getLastNode() { 
        Node currNode = head; 

        while(currNode.next != null) { 
            currNode = currNode.next; 
        }
        return currNode;
    }

    public Blorb getLast(){ 
        Node back = getLastNode(); 
        return back.item;
    }

    public Blorb removeLast() { 
        Node back = getLastNode(); 
        if (back == head) { 
            return null;
        }
        
        size -= 1; 
        Node currNode = head; 

        while(currNode.next != back) { 
            currNode = currNode.next; 
        } 


        currNode.next = null; 
        return back.item;
    }

    public void insert(Blorb item, int position) { 
        if(head.next == null || position == 0) { 
            addFirst(item); 
            return;
        }
        Node newNode = new Node(item, null);
        Node currNode = head;  

        if (head == null) { 
            head = newNode; 
            size++; 
            return;
        } else if (position == 0) { 
            newNode.next = head; 
            head = newNode; 
            size++;
            return;
        } 

        for(int i = 0; i < position - 1; i++) { 
            currNode = currNode.next;
        }
        newNode.next = currNode.next; 
        currNode.next = newNode;
        size++;
    }

    public Blorb get(int position) { 
        if (head.next == null) { 
            return null;
        }

        Node currNode = head; 

        for(int i = 0; i < position; i++) { 
            currNode = currNode.next;
        } 
        return currNode.item;
    } 

    public void print() { 
        for (int i = 0; i < size(); i++) {
            System.out.println(get(i));
        } 
    }

   public int size() { 
        return size;
    } 
}