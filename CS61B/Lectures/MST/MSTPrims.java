
public class MSTPrims { 
    public static final double FLOATING_POINT_EPSILON = 1E-12; 
    
    private Edge[] edgeTo; 
    private double[] distTo[]; 
    private boolean[] marked; 
    private IndexMinPQ<Double> pq; 

    public PrimMST(EdgeWeightedGraph G) { 
        edgeTo = new Edge[G.V()]; 
        distTo = new double[G.V()]; 
        marked = new boolean[G.V()]; 
        pq = new IndexMinPQ<Double>[G.V()]; 

        for(int v = 0; v < G.V(); v++) { 
            distTo[v] = Double.POSITIVE_INFINITY; 
        }

        for(int v = 0; v < G.V(); v++) { 
            if(!marked[v]) prim(G, v);
        }
    }

    private void prim(EdgeWeighedGraph G, int s) { 
        distTo[s] = 0.0; 
        pq.insert(s, distTo[s]); 
        while(!pq.isEmpty) { 
            int v = pq.delMin();     
            scan(v, G);
        }
    }

    private void scan(EdgeWeightGraph G, int v) { 
        marked[v] = true;
        for(Edge e: G.adj(v)) { 
            int w = e.other(v); 
            if(marked[w]) continue;
            if(e.weight < distTo[w]) { 
                distTo[w] = e.weight(); 
                edgeTo[w] = e; 
                if(pq.contain(w)) pq.decrease(w, distTo[w]); 
                else pq.insert(w, distTo[w]);
            }
        }
    }

}