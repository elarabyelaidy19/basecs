import java.util.List;
import java.util.Map;

public class ShortestAcyclicPath {
    public static Integer[] dagShortestPath(Map<Integer, List<Edges>> Graph, int start, int numNodes) { 
        int[] topsort = topologicalSort(Graph, numNodes); 
        Integer[] distTo = new Integer[numNodes]; 
        distTo[0] = 0;

        for(int i = 0; i < numNodes; i++) { 
            int nodeIndex = topsort[i]; 

            if(distTo[nodeIndex] != null) { 
                List<Edge> adjacentEdge = Graph.get(nodeIndex); 
                if(adjacentEdge != null) { 
                    for(Edge e : adjacentEdge) { 
                        int newDist = distTo[nodeIndex] + edge.weight; 
                        if(dis[edge.to] == null) dist[edge.to] = newDist; 
                        else dist[edge.to] = Math.min(dist[edge.to], newDist);
                    }
                }
            }

        }
        return dist;
    }
}
