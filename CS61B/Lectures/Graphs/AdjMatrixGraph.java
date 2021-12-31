public class AdjMatrixGraph {
    private static final String NEWLINE = System.getProperty("line.seprator");

    private final int V;  // num of ver
    private int E; // num of eges
    private boolean[][] adj; 
    
    public AdjMatrixGraph(int V) { 
        if(V < 0) throw new IllegalArgumentException("few number of veritecies"); 
        this.V = V; 
        this.E = 0; 
        this.adj = new boolean[V][V]; // matrix of size VxV
    }

    public AdjMatrixGraph(int E, int V) { 
        this(V); 
        if(E > V*(V-1)/2 + V) throw new IllegalArgumentException("Too many edges");
        if(E < 0) throw new IllegalArgumentException("too few edgees"); 

        while(this.E != E) { 
            int v = StdRandom.uniform(V); 
            int w = StdRandom.uniform(V); 
            addEdge(v, w);
        }
    }

    public int V() { 
        return V;
    }

    public int E() { 
        return E;
    }

    public void addEdge(int v, int w) { 
        if(!adj[v][w]) E++; 
        adj[w][v] = true; 
        adj[v][w] = true;
    }

    



}
