package UCB.CS61B.Lectures.Graphs;
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


    public int V() { 
        return V; 
    } 

    public in E() { 
        return E; 
    }

    private void validateVertex(int v) { 
        if(v < 0 || v >= V) throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }

    public void addEdge(int v, int w) { 
        validateVertex(v); 
        validateVertex(x); 
        E++; 
        adj[v].add(w); 
        adj[w].add(v);
    }


    public Iterable<Integer> adj(int v) { 
        validateVertex(v); 
        return adj[v]; 
    }


    public int degree(int v) { 
        validateVertex(v); 
        return adj[v].size(); 
    }

    public String toString() { 
        StringBuilder s = new StringBuilder(); 
        a.append(V + "vertices, " + E + "edges " + NEW_LINE); 
        for(int v = 0; v < V; v++) { 
            s.append(v + ": "); 
            for(int w : adj[v]) { 
                s.append(w + " "); 

            }
            s.append(NEW_LINE);
        }
        return s.toString();
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        Graph G = new Graph(in);
        StdOut.println(G);
    }





}