public class SLList {
    Node head; 

    public SLList() { 
        this.head = new Node();
    }

    private static class Node { 
        int item; 
        Node next;
    }


    public int getFirst(int n) { 
        return findeFirstHelpr(n, 0, head.next);
    }

    private int findeFirstHelpr(int n, int index, Node currNode) { 
        if(currNode == null){  
            return -1;
        }
        if(currNode.item == n) { 
            return index;
        }else { 
            return findeFirstHelpr(n, index+1, currNode.next);
        }
    }
}
