public class WordUtil {
    public static String getLongest(List<String> list) { 
        int maxIdx = 0; 
        for(int i = 0; i < list.size(); i++) { 
            if(list.get(i).length() > list.get(maxIdx).length()) { 
                maxIdx = i;
            }
        
        } 

        return list.get(maxIdx);
    } 


    public static void main(String[] args) {
        List<String> l = new Alist<>(); 
        l.addLast("a7a"); 
        l.addLast("a7etten"); 
        l.addLast("55555555555"); 
        System.out.println(getLongest(l));
    }


}
