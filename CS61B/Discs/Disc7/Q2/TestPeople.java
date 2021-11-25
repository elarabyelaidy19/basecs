package Disc7.Q2;
public class TestPeople {
    public static void main(String[] args) {
    
        Person n = new Person("neil", 23); 
        Person a = new GrandMa("ada", 22); 

        GrandMa v = new GrandMa("vidya", 80); 
        // GrandMa a1 = new Person("alex", 27); // Compile error can not put Person in GrandMa

        n.greet(a); // Hello ada
        n.greet(v); // Hello vidya

        v.greet(a); // hello young whippersnapper
        v.greet((GrandMa) a); // how was bingo, ada?

        a.greet(n); // hello young whippersnapper
        a.greet(v); // hello young whippersnapper

        ((GrandMa) a).greet(v); // how wa bingo 
        ((GrandMa) n).greet(v);// Run time error
    } 
}