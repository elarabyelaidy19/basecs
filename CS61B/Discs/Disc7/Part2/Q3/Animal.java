class Animal { 
    int speak(Dog a) {
        return 1;
    }

    int speak(Animal a) {
        return 2;
    }



    public static void main(String[] args) {
        Animal animal = new Animal(); 
        Animal dog = new Dog();
        Animal poodle  = new Poodle();
        
        compare(animal, dog);
        compare(dog, dog); 
        compare(poodle, dog);

    }
}  