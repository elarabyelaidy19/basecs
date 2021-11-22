package Q1;
public class Person {
    void speakTo(Person p) { System.out.println("Kudos"); } 
    void watch(Person p) { System.out.println("Wow"); }

    public static void main(String[] args) {
        Person iti = new Person(); // comile 
        SoccerPlayer shivani = new Person(); // compile Error 
        Athlete shoum = new SoccerPlayer(); // compile
        Person jack = new Athlete(); // compile
        Athlete anjali = new Athlete(); //  compile
        SoccerPlayer chirasree = new SoccerPlayer(); // compile
        
        iti.watch(chirasree); // Wow
        jack.watch((SoccerPlayer) shoum); // Compile Error 
        iti.speakTo(shoum); // Kudos 
        jack.speakTo(anjali); // Kudos 
        anjali.speakTo(chirasree); // take notes
        shoum.speakTo(iti); // hmph 
        chirasree.speakTo((SoccerPlayer) shoum); // respect
        shoum.watch(iti); // comile Error
        sohum.watch((Athlete) itai); // Runtime Error
        RE((Athlete) jack).speakTo(anjali); // take notes
        ((SoccerPlayer) jack).speakTo(chirasree); // Runtime error 
        RE((Person) chirasree).speakTo(itai); // hmph
    }
}


