import java.util.Arrays;
import java.util.Queue;

public class MSTKruskal { 
    private static final double FLOATING_POINT_EPSILON = 1E-12; 

    private double weight; 
    private Queue<Edge> mst = new Queue<E>();
    public kruslkalMST(EdgeWeightedGraph G) { 
        Edge[] edges = new Edge[G.V()]; 
        int t = 0;
        for(Edge e : G.edges) { 
            edges[t++] = e;
        }

        Arrays.sort(edges);

        UF uf = new UF(G.V()); 
        for(int i = 0; i < G.E() && mst.size() < G.V() - 1; i++) { 
            Edge e = edges[i]; 
            int v = e.either(); 
            int w = e.other(v);

            if(uf.find(v) != uf.find(w)) { 
                uf.union(v, w); 
                mst.enqueue(e); 
                weight += e.weight;
            }
        } 
    }
    
    public Iterable<Edge> edges() { 
        return mst;
    }
}
