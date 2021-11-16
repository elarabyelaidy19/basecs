public class HoF { 
    public static int doTwice(IntUnaryFuction f, int x) { 
        return f.apply(f.apply(x)); 
    }

    public static void main(String[] args) { 
        IntUnaryFuction x = new TenX();
        System.out.println(doTwice(x, 10));
    }
}