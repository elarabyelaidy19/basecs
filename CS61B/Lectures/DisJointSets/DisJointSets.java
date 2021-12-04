public interface DisJointSets {
     
    void connect(int x, int y); 

    boolean isConnected(int x, int y);
}
