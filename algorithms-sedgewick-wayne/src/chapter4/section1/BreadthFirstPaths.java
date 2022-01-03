package chapter4.section1;

import chapter1.section3.Queue;
import chapter1.section3.Stack;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by Rene Argento on 15/09/17.
 */
public class BreadthFirstPaths {

    private boolean[] visited;
    private int[] edgeTo;
    private final int source;

    private int[] distTo;

    public BreadthFirstPaths(GraphInterface graph, int source) {
        visited = new boolean[graph.vertices()];
        edgeTo = new int[graph.vertices()];
        this.source = source;

        distTo = new int[graph.vertices()];

        distTo[source] = 0;
        for(int vertex = 0; vertex < graph.vertices(); vertex++) {
            if (vertex == source) {
                continue;
            }
            distTo[vertex] = Integer.MAX_VALUE;
        }

        bfs(graph, source);
    }

    private void bfs(GraphInterface graph, int sourceVertex) {
        Queue<Integer> queue = new Queue<>();
        visited[sourceVertex] = true;

        queue.enqueue(sourceVertex);

        while (!queue.isEmpty()) {
            int currentVertex = queue.dequeue();

            for(int neighbor : graph.adjacent(currentVertex)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;

                    edgeTo[neighbor] = currentVertex;
                    distTo[neighbor] = distTo[currentVertex] + 1;

                    queue.enqueue(neighbor);
                }
            }
        }
    }

    //O(1)
    public int distTo(int vertex) {
        return distTo[vertex];
    }

    //O(1)
    public int edgeTo(int vertex) {
        return edgeTo[vertex];
    }

    public boolean hasPathTo(int vertex) {
        return visited[vertex];
    }

    public Stack<Integer> pathTo(int vertex) {
        if (!hasPathTo(vertex)) {
            return null;
        }

        Stack<Integer> path = new Stack<>();

        for(int currentVertex = vertex; currentVertex != source; currentVertex = edgeTo[currentVertex]) {
            path.push(currentVertex);
        }

        path.push(source);
        return path;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        Graph G = new Graph(in);
        // StdOut.println(G);

        int s = Integer.parseInt(args[1]);
        BreadthFirstPaths bfs = new BreadthFirstPaths(G, s);

        for (int v = 0; v < G.V(); v++) {
            if (bfs.hasPathTo(v)) {
                StdOut.printf("%d to %d (%d):  ", s, v, bfs.distTo(v));
                for (int x : bfs.pathTo(v)) {
                    if (x == s) StdOut.print(x);
                    else        StdOut.print("-" + x);
                }
                StdOut.println();
            }

            else {
                StdOut.printf("%d to %d (-):  not connected\n", s, v);
            }

        }
    }

}
