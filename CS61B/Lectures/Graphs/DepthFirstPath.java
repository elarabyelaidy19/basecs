import java.util.Stack;

public class DepthFirstPath {
    private boolean[] marked; // is ther a path form s-w
    private int[] edgeTo; // last edge on the path 
    private final int s; // source vertix

    public DepthFirstPath(Graph G, int s) { 
        this.s = s;
        marked = new boolean[G.V()]; 
        edgeTo = new int[G.V()]; 
        validateVertix(s); 
        dfs(G, s);
    }

    private void dfs(Graph G, int v) { 
        marked[v] = true; 
        for(int w : G.adj(v)) { 
            if(!marked[w]) { 
                edgeTo[w] = v; 
                dfs(G, w);
            }
        }
    }  

    public boolean hasPathTo(int v) { 
        validateVertex(v); 
        return marked[v];
    }

   

    public Iterable<Integer> pathTo(int v) { 
        validateVertex(v);  
        if(!hasPathTo(v)) return null;
        Stack<Integer> path = new  Stack<Integer>(); 
        for(int x = v; x != s; x = edgeTo[x]) { 
            path.push(x); 
        }
        path.push(s);
        return path;
    }

    private void validateVertex(int v) { 
        int V = marked.length; 
        if(v < 0 || v >= V) { 
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
        }
    }

    

}
