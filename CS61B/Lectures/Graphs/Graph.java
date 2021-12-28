public class graph { 
    private static final String NEW_LINE = System.getProperty("line.separator"); 
    private final int V; 
    private int E; 
    private Bag<Integer>[] adj;
    
    
    public Graph(int V) {  
        if(V < 0) throw new IllegalArgumentException("Number of vertices must be nonnegative");
        this.V = V; 
        this.E = 0; 
        adj = (Bag<Integer>[]) new Bag(V); 
        for(int v = 0; v < V; v++) { 
            adj[v] = new Bag<Integer>(); 
        }
    }

    public Graph(In in) { 
        if(in == null) throw new IllegalArgumentException("argument is null"); 
        try { 
            this.V = in.readInt(); 
            if(V < 0) throw new IllegalArgumentException("number of vertices in a Graph must be nonnegative"); 
            adj = (Bag<Integer>[]) new Bag[V]; 
            for(int v = 0; v < V; v++) { 
                adj[v] = new Bag<Integer>(); 
            }
            this.E = in.readInt(); 
            if(E < 0) throw new IllegalArgumentException("number of edges in a Graph must be nonnegative"); 
            for(int i = 0; i < E; i++) { 
                int v = in.readInt(); 
                int w = in.readInt(); 
                validateVertex(v); 
                validateVertex(w); 
                addEdge(v, w);
            } 
        }catch(NoSuchElementException e) { 
            throw new IllegalArgumentException("invalid input format in Graph constructor", e); 
        }
    } 

    




}