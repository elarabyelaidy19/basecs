import java.util.ArrayList;
import java.util.Arrays;
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

    public void addEdge(int from, int to, double cost) { 
        edgeCount++; 
        graph.get(from).add(new Edge(to, cost));
    } 

    public List<List<Edge>> getGraph() { 
        return graph;
    }

    public double dijkestra(int start, int to) { 
        int degree = edgeCount / nodes;  
        MinIndexedHeap<Double> ipq = new MinIndexedHeap<>(degree, nodes); 
        ipq.insert(start, 0.0); 

        dist = new double[nodes]; 
        Arrays.fill(dist, double.POSITIVE_INFINITY); 
        dist[start] = 0.0; 

        boolean visited = new boolean[nodes]; 
        prev = new Integer[nodes]; 

        while(!ipq.isEmpty()) { 
            int nodeId = ipq.peekMinKeyIndex(); 
            visited[nodeId] = true; 
            double minValue = ipq.pollMinValue; 

            if(minValue > dist[nodeId]) continue;

            for(Edeg edge : graph.get(nodeId)) { 
                if(visited[edge.to]) continue; 

                double newdist = dist[nodeId] + edge.cost; 
                if(newdist < dist[edge.to]) { 
                    prev[edge.to] = nodeId; 
                    dist[edge.to] = newdist;

                    if(!ipq.contains(edge.to)) { 
                        ipq.insert(edge.to, newdist); 
                    }else { 
                        ipq.decrease(edge.to, newdist);
                    }
                }
            }
            if(nodeId == end) return dist[end];
        }
    }


}
