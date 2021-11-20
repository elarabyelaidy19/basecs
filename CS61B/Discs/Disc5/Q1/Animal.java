package Q1;
public class Animal {
    public String name, noise; 
    public int age;  

    public Animal(String name, int age) { 
        this.name = name; 
        this.age = age; 
        this.noise = "Huh";
    }

    public void greet() { 
        System.out.println("Animal " + name + " says: " +this.noise); 
    }

    public void play(){ 
        System.out.println("Woo it is so much fun being an animal!");
    }






    public static void main(String[] args) { 
        Animal a = new Animal("Bob", 5);  
        Cat c =new Cat("Garfield", 6); 
        Dog d = new Dog("Fido", 7); 

        a.greet();  
        c.greet();
        d.greet();
        c.play(); 
        c.play(":)"); 

        a = c;  
        ((Cat) a).greet(); 
        ((Cat) a).play("Meow"); 
        ((Cat) a).play(":)"); 
        // a.play(24); 
        ((Dog) a).play(24);
        a.greet();
        // c = a;
    }


}