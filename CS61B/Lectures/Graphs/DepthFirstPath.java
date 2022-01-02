public class DepthFirstPath {
    private boolean[] marked; // is ther a path form s-w
    private int[] edgeTo; // last edge on the path 
    private final int s; // source vertix

    public DepthFirstPath(Graph G, int s) { 
        marked = new boolean[G.V()]; 
        edgeTo = new int[G.V()];
        
    }
}
