public class BSLog {
    
    public static int binarySearch(String[] sorts, String x, int lo, int hi) { 
        if (lo > hi) return -1; 
        int mid = (lo + hi) / 2; 
        int cmp = x.compareTo(sorts[mid]); 
        if(cmp < 0) return binarySearch(sorts, x, lo, mid - 1); 
        else if(cmp > 0) return binarySearch(sorts, x, mid + 1, hi); 
        else return mid;
    }
}
