package Disc7;

public class OHRequest {
    public String name; 
    public String description; 
    public OHRequest next; 

    public OHRequest(String name, String description, OHRequest next) {
        this.name = name; 
        this.description = description; 
        this.next = next; 
    }
}