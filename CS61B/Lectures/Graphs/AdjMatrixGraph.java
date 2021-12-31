import java.util.Iterator;
import java.util.NoSuchElementException;

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

    public boolean contain(int v, int w) { 
        return adj[w][v];
    }

    public Iterable<Integer> adj(int v) { 
        return new adjIterator(v);
    }

    private class adjIterator implements Iterator<Integer>, Iterable<Integer> { 
        private int v; 
        private int w = 0; 

        adjIterator(int v) { 
            this.v = v;
        }

        public Iterator<Integer> iterator() { 
            return this;
        }

        public boolean hasNext() { 
            while(w < V) { 
                if(adj[w][v]) return true; 
                w++;
            }
            return false;
        }

        public Integer next() { 
            if(!hasNext()) 
                throw new NoSuchElementException();  
            
            return w++;
        }

        public void remove() { 
            throw new UnsupportedOperationException();
        }

        public String toString() { 
            StringBuilder s = new StringBuilder();  
            s.append(V + " " + E + NEWLINE);
            for(int v = 0; v < V; v++) { 
                for(int w : adj(v)) { 
                    s.append(w + " ");
                }
                s.append(NEWLINE);
            }
            return s.toString();
        }

    }

    public static void main(String[] args) {
        int V = Integer.parseInt(args[0]); 
        int E = Integer.parseInt(args[1]); 
        AdjMatrixGraph adj = new AdjMatrixGraph(E, V); 
        System.out.print(adj);
    }


}
