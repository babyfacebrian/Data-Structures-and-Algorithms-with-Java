/*
 * Assignment 5B
 * Brian Kalinowski
 * Quesiton 40
 */
package ticketingapp;

import java.util.*;
import java.io.*;
import java.text.*;

public class Ticket {
    
    private int seat;
    private String name;    

    
    public Ticket(int key, String n){
        this.seat = key;
        this.name = n;
    }
    
    @Override
    public String toString(){
        return("Seat Number: " + seat + " \n" +"Name: " + name + " \n");
    } 

    public Ticket deepCopy(){
        Ticket tick = new Ticket(seat, name);
        return tick;
    }

    public int getTarget(){
        return this.seat;
    }   

    public String getName(){
        return this.name;
    }
    
    public static Ticket input() throws Exception{
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter in Ticket Number: ");
        int num = input.nextInt();
        
        if(num > 100_000 || num < 2_000){
            throw new Exception("Not a valid ticket number");
        }
        System.out.println("Enter Ticket Holders Name: ");
        String n = input.next();
        return new Ticket(num, n);
        
    }
    
}
