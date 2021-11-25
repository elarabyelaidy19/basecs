public class TestPeople {
    public static void main(String[] args) {
    
        Person n = new Person("neil", 23); 
        Person a = new Person("ada", 22); 

        GrandMa v = new GrandMa("vidya", 80); 
        // GrandMa a1 = new Person("alex", 27); // Compile error can not put Person in GrandMa

        n.greet(a); // Hello ada
        n.greet(v); // Hello vidya

        v.greet(a); // hello young whippersnapper
        v.greet((GrandMa) a); // how was bingo

        a.greet(n); 
        a.greet(v);

        ((GrandMa) a).greet(v); 
        ((GrandMa) n).greet(v);
    } 
}