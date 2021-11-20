package Q2;
public class A { 
    public int x = 5; 
    public void m1() { 
        System.out.println("Am1-> " + x);
    }

    public void m2() { 
        System.out.println("Am2-> " + this.x);
    }

    public void update() { 
        x = 99;
    }


    public static void main(String[] args) {
        // B a0 = new A(); // Dynamic type must be of type B or a subclass of B
        // a0.m1(); 
        // a0.m2(16); 

        A b0 = new B(); 
        System.out.println(b0.x); // 5
        b0.m1(); // Am1-> 5
        b0.m2();  // Bm2-> 5  beacause m2 of B override m2 of A

        B b1 = new B(); 
        b1.m2(16); // Bm2y-> 16
        b1.m3(); // Bm3-> called 

        A c0 = new C(); 
        c0.m2(); // Cm2-> 5

        // C c1 = (A) new C(); // can not assign A to C
        A a1 = (A) c0; 
        C c2 = (C) a1;

        c2.m3(); // Bm3-> called
        // c2.m4(); // undefined method m4
        c2.m5(); // Cm5-> 6
        ((C) c0).m3(); // Bm3-> called
        // (C) c0.m2(); NOT RUNTIME ERROR This would cast the result of what the method returns andit returnsvoidtherefore compile-time error


        b0.update(); 
        b0.m1(); // Am1-> 99

    }
}