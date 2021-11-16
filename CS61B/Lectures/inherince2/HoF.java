public class HoF { 
    public static int doTwice(IntUnaryFuction f, int x) { 
        return f.apply(f.apply(x)); 
    }

    public static void main(String[] args) {
        System.out.println(doTwice(new TenX, 10));
    }
}