package Disc7;

public class TYIterator extends OHIterator{ 
    public TYIterator(OHRequest queue) { 
        super(queue); 
    }

    @Override 

    public OHRequest next() { 
        OHRequest result = super.next(); 
        
        if(result != null && result.description.contains("Thank u ")) 
            result = super.next(); 

        return result;
    }
    

}