/*
 * Assignment 9B
 * Brian Kalinowski
 * Question 36
 */
package graphtest;

// definition of a hub city (a vertex)

public class Listing{  
    
    private String name;
    
    public Listing(String n){
        name=n;
    }
    
    public String toString(){  
        return(name);
    }
    
    public Listing deepCopy(){  
        Listing clone = new Listing(name);
        return clone;
    }
}
