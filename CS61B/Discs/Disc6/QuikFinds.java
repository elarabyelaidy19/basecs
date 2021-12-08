public class QuikFinds { 
    static int[] parent; 

    public QuikFinds(int N) { 
        parent = new int[N];
        for(int i = 0; i < N; i += 1) { 
            parent[i] = i;
        }
    }

    public static int find(int v) { 
        while(parent[v] > 0) {
            v = parent[v]; 
        }
        return v;
    }

    public void connect(int p, int q) { 
        int pid = find(p); 
        int qid = find(q);
        parent[qid] = pid;
    } 

    public boolean isConnected(int p, int q) { 
        return (find(p) == find(q));
    }
}