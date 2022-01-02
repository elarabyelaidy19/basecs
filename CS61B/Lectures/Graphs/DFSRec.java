package UCB.CS61B.Lectures.Graphs;

public class DFSRec {
    private boolean[] marked; 
    private int count; // number of veritices connected to s

    public DFSRec(Graph G, int s) { 
        marked = new boolean[G.V()];
        validateVertex(s); 
        dfs(G, s);
    }

    private void dfs(Graph G, int v) { 
        count++; 
        marked[v] = true; 
        for(int w : G.adj(v)) { 
            if(!marked[w]) { 
                dfs(G, w);
            }
        }
    }

    public boolean marked(int v) { 
        validateVertex(v);
        return marked[v];
    }

    private void validateVertex(int v) { 
        int V = marked.length; 
        if(v < 0 || v > V) { 
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
        } 
    } 

    private int count() { 
        return count;
    }
}
