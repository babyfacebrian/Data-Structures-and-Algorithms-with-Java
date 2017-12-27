/*
 * Assignment 5B
 * Brian Kalinowski
 * Quesiton 40
 */
package ticketingapp;

import java.util.Arrays;

public class StadiumHash {
    
    private static final int min = 2_000;
    private Ticket[] stadium;
    
    public StadiumHash(){
        this.stadium = new Ticket[98_001];
    }
    
    public void insert() throws Exception{
        Ticket node = Ticket.input();
        int pseudoKey = node.getTarget() - min;
        if(this.stadium[pseudoKey] != null){
            throw new Exception("Seat number already taken");
        }
        this.stadium[pseudoKey] = node.deepCopy();
    }
    
    public Ticket fetch(int ticket) throws Exception{
        int pseudoKey = ticket - min;
        if(this.stadium[pseudoKey] == null){
            throw new Exception("Seat number not assigned");
        }
        return this.stadium[pseudoKey].deepCopy();
    }
    
    public void delete(int ticket) throws Exception{
        int pseudoKey = ticket - min;
        if(this.stadium[pseudoKey] == null){
            throw new Exception("Ticket doesn't exist");
        }
        this.stadium[pseudoKey] = null;
    }
    
    public void update(int ticket) throws Exception{
        int pseudoKey = ticket - min;
        if(this.stadium[pseudoKey] == null){
            throw new Exception("Seat not yet filled, insert ticket data to update");
        }else{
            this.stadium[pseudoKey] = null;
        }
        Ticket node = Ticket.input();
        int keyUpdate = node.getTarget() - min;
        this.stadium[keyUpdate] = node.deepCopy();
    }
    
    public String toString(){
        StringBuilder output = new StringBuilder();
        for(Ticket T: this.stadium){
            if(T != null){
                output.append(T);
            }
        }
        return output.toString();
    }

}
