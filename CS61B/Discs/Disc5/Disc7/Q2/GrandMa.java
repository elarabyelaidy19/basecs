package Disc7.Q2;

public class GrandMa extends Person{ 

    public GrandMa(String name, int age) {
        super(name, age);
    }
    

    @Override 
    public void greet(Person Other) { 
        System.out.println("Hello, young whippersnapper");
    }

    public void greet(GrandMa Other) { 
        System.out.println("How was bingo, " + Other.name + "?"); 


    }
}
