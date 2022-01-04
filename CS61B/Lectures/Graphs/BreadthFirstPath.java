import java.util.Queue;

public class BreadthFirstPath { 
    private static final int INFINITY = Integer.MAX_VALUE; 
    private boolean[] marked; 
    private int[] edgeTo; 
    private int[] distTo; 

    public BreadthFirstPath(Graph G, int s) { 
        marked = new boolean[G.V()]; 
        edgeTo = new int[G.V()]; 
        distTo = new int[G.V()]; 
        validateVertex(s); 
        bfs(G, s); 
        assert check(G, s);
    }

    public BreadthFirstPath(Graph G, Iterable<Integer> source) { 
        marked = new boolean[G.V()]; 
        edgeTo = new int[G.V()]; 
        distTo = new int[G.V()];  
        for(int v = 0; v < G.V(); v++) { 
            distTo[v] = INFINITY; 
        }
        validateVertex(source);  
        bfs(G, source);
    }

    private void bfs(Graph G, int s) { 
        Queue<Integer> q = new Queue<Integer>(); 
        for(int v = 0; v < G.V(); v++) 
            distTo[v] = INFINITY;  

        distTo[s] = 0; 
        marked[s] = true; 
        q.add(s); 

        while(!q.isEmpty()) { 
            int v = q.remove(); 
            for(int w : G.adj(v)) { 
                edgeTo[w] = v; 
                distTo[w] = distTo[v] + 1; 
                marked[w] = true; 
                q.add(w);
            }
        }
    }

    private void 
}