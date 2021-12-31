public class GraphClient {
    public static int maxDegree(Graph G) {  
        // degree of vertix is the number of edges incident on it. 
        int  max = 0; 
        for(int v = 0; v < G.v(); v++) { 
            if(G.degree(v) > max) 
                max = G.degree(v);
        }
        return max;
    }

    public static int avgDegree(Graph G) { 
        return 2 * G.E() / G.V(); // equall to sum of degree to every node
    }

    public static int numOfSelfLoop(Graph G) { 
        int count = 0; 
        for(int v = 0; v < G.V(); v++) { 
            for(int w : G.adj(v)) { 
                if(v == w) count++;
            }
        } 
        return count/2;
    }

    public static void main(String[] args) {
        In in = new In(args[0]); 
        Graph G = new Graph(in);
        System.out.println(G); 

        StdOut.println("vertex of maximum degree = " + maxDegree(G));
        StdOut.println("average degree           = " + avgDegree(G));
        StdOut.println("number of self loops     = " + numberOfSelfLoops(G));
    }




}
