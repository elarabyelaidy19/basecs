public class ConnectedComponent { 
    private boolean[] marked; 
    private int[] id; 
    private int[] size; 
    private int count; 


    public ConnectedComponent(Graph G) { 
        marked = new boolean[G.V()]; 
        id = new int[G.V()]; 
        size = new int[G.V()]; 
        for(int v = 0; v < G.V(); v++) { 
            if(!marked[v]) { 
                dfs(G, v); 
                count++;
            }
        }
    } 

    public ConnectedComponent(EdgeWeightedGraph G) { 
        marked = new boolean[G.V()];  
        id = new int[G.V()]; 
        size = new int[G.V()]; 
        for(int v = 0; v < V; v++) { 
            if(!marked[v]) { 
                dfs(G, v); 
                count++;
            }
        }
    }


    private void dfs(Graph G, int v) { 
        marked[v] = true; 
        id[v] = count; 
        size[count]++; 
        for(int w : G.adj(v)) { 
            if(!marked[w]) 
                dfs(G, w);
        }
    }


    private void dfs(EdgeWeightGraph G, int v) { 
        marked[v] = true;  
        id[v] = count; 
        size[count]++;
        for(Edge e : G.adj(v)) { 
            int w = e.other(v); 
            if(!marked[w]) { 
                dfs(G, v);
            } 
        }
    }

    public int id(int v) { 
        validateVertix(v); 
        return id[v];
    }

    public int size(int v) { 
        validtaeVertix(v); 
        return size[id[v]];
    }

    public int count() { 
        return count;
    }

    public boolean connected(int v, int w) { 
        validateVertix(v); 
        validateVertix(w); 
        return id(v) == id(w);
    }

    public void validateVertix(int v) { 
        int V = marked.length;
        if(v < 0 || v >= V) { 
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        Graph G = new Graph(in);
        CC cc = new CC(G);

        // number of connected components
        int m = cc.count();
        StdOut.println(m + " components");

        // compute list of vertices in each connected component
        Queue<Integer>[] components = (Queue<Integer>[]) new Queue[m];
        for (int i = 0; i < m; i++) {
            components[i] = new Queue<Integer>();
        }
        for (int v = 0; v < G.V(); v++) {
            components[cc.id(v)].enqueue(v);
        }

        // print results
        for (int i = 0; i < m; i++) {
            for (int v : components[i]) {
                StdOut.print(v + " ");
            }
            StdOut.println();
        }
    }


}