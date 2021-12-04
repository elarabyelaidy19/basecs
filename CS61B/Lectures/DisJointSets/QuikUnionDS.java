public class QuikUnionDS implements DisJointSets { 

    static int[] parent; 

    public QuikUnionDS(int num) { 
        parent = new int[num]; 
        for(int i =0 ; i<parent.length; i+= 1) { 
            parent[i] = i; 
        }
    }

    private static int find(int p) { 
        while(parent[p] > 0) { 
           p = parent[p];
        }
        return p;
    }

    public void connect(int p, int q) { 
        int i = find(p); 
        int j = find(q); 
        parent[i] = j; 
    }

    public boolean isConnected(int p, int q) { 
        return (find(p) == find(q));        
    }


    public static void main(String[] args) {
    }
    
}
