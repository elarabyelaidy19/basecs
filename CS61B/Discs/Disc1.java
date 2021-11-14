public class Foo { 
   public int x, y; 
   
   public Foo(int x, int y) { 
      this.x = x; 
      this.y = y; 
   }
   
   public static void switchroo(Foo a, Foo b) { 
      Foo temp = a; 
      a = b; 
      b = temp; 
   } 
   
   
    public static void flibroo(Foo a, Foo b) {  
      Foo temp = new Foo(a.x, a.y);
      a.x = b.x; 
      a.y = b.y; 
      b.x = temp.x; 
      b.y = temp.y;
    } 

    public static void swaproo(Foo a, Foo b) { 
      Foo temp = a; 
      a.x = b.x; 
      b.x = temp;  
      b.x = temp.x; 
      b.y = temp.y;
    }

    public static void main(String[] args) {
        Foo foobar = new Foo(10, 20); 
        Foo foobaz = new Foo(30, 40); 
        switchroo(foobar, foobaz); 
        flibroo(foobar, foobaz);
        swaproo(foobar, foobaz);
    }
}