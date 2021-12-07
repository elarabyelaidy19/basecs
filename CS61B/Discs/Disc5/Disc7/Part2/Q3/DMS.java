import java.util.Comparator;

public class DMS implements Comparator<Animal> {
    
    public int compare(Animal a1, Animal a2) { 
        int first = a1.speak(new Animal()); 
        int second = a2.speak(new Animal());
        int third = a1.speak(new Dog()); 
        int fourth = a2.speak(new Dog());
        
        if (first == second && third == fourth) {
            return 0;
        } else if (first > second && third > fourth) {
            return 1;
        } else {
            return -1;
        }

    }
}
