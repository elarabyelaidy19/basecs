import java.util.ArrayList;
import java.util.List;

public class DijkestraShortestPathWithMinHeap {
    
    public class Edge { 
        double cost; 
        int to; 

        public Edge(int to, double cost) { 
            this.to = to; 
            this.cost = cost; 
        }
    }

    private final int nodes; // num of nodes 
    private int edgeCount; // number of edges 
    private double[] dist;  // distance from s to d 
    private Integer[] prev;  // visited nodes in the path 
    private List<List<Edge>> graph; // adjacncy List of Graph


    public DijkestraShortestPathWithMinHeap(int nodes) { 
        this.nodes = nodes; 
        creatEmptyGraph(); 
    }

    private void creatEmptyGraph() { 
        graph = new ArrayList<>(nodes);
        for(int i = 0; i < nodes; i++) graph.add(new ArrayList<>());
    }

    

}
