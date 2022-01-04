import java.util.Queue;
import java.util.Stack;

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

    private void bfs(Graph G, Iterable<Integer> sources) { 
        Queue<Integer> q = new Queue<Integer>(); 
        for(int s : sources) { 
            distTo[s] = 0; 
            marked[s] = true; 
            q.add(s);
        }

        while(!q.isEmpty()) { 
            int v = q.remove(); 
            for(int w : G.adj(v)) { 
                distTo[w] = distTo[v] + 1; 
                marked[w] = true; 
                edgeTo[w] = v; 
                q.add(w);
            }
        }
    }

    private boolean hasPathTo(int v) { 
        validateVertex(v); 
        return marked[v];
    }

    private int distTo(int v) { 
        validateVertex(v); 
        return distTo[v];
    } 

    private void validateVertex(int v) { 
        int V = marked.length; 
        if(v < 0 || v >= V) { 
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
        }
    } 

    public Iterable<Integer> pathTo(int v) { 
        validateVertex(v); 
        if(!hasPathTo(v)) return null; 
        Stack<Integer> path = new Stack<>(); 
        int x;
        for(x = v; distTo[x] != 0; x = edgeTo[x]) { 
            path.push(x); 
        }
        path.push(x); 
        return path;
    }
}