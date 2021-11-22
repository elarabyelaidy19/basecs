public class DMSList { 
    private IntNode sentinel;
    public DMSList() { sentinel = new IntNode(-1000, new LsatNode); } 

    public class IntNode { 
        public int item; 
        public IntNode next;
    
        public IntNode(int item, IntNode next) { 
            this.item = item; 
            this.next = next; 
        }

        public int max() { 
            return Math.max(item, next.max());
        }
    }

    public class LsatNode extends IntNode { 
        public LsatNode() { super(0, null); } 
        
        public int max() { return 0; }
    }

    public int max() { 
        return sentinel.next.max(); 
    } 
    
    public void insertFront(int item) { 
        sentinel.next = new IntNode(item, sentinel.next); 
    }
}