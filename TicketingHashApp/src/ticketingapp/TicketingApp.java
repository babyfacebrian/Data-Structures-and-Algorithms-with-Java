/*
 * Assignment 5B
 * Brian Kalinowski
 * Quesiton 40
 */
package ticketingapp;

import java.util.*;
import java.io.*;
import java.text.*;

public class TicketingApp {
    
    private static void prompt() {
        System.out.println("Please Select a Option:");
        System.out.println("1 : Insert ticket entry");
        System.out.println("2 : Fetch ticket entry");
        System.out.println("3 : Update ticket entry");
        System.out.println("4 : Delete ticket entry");
        System.out.println("5 : Display all tickets");
        System.out.println("6 : Exit");
    }
    
    private static int getOption() throws Exception {
        Scanner input = new Scanner(System.in);
        int option = input.nextInt();
        
        if(option != 1 && option !=2  && option != 3 && option != 4 &&
                option != 5 && option != 6){
            throw new Exception("Not a valid choice");
        }
        return option;
    }
    
    private static void processOption(int opt, StadiumHash event){
        Scanner input = new Scanner(System.in);
        switch(opt){
            case 1:
                try{
                    event.insert();
                }catch (Exception e){
                    System.out.println(e.toString());
                }
                break;
            case 2: {
                System.out.println("Enter in a ticket number to fetch");
                int ticket = input.nextInt();
                try{
                    System.out.println(event.fetch(ticket));
                }catch (Exception e) {
                    System.out.println(e.toString());
                }
                break;
            }
            case 3: {
                System.out.println("Enter in a ticket number to update");
                int ticket = input.nextInt();
                try {
                    event.update(ticket);
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
                break;
            }
            case 4: {
                System.out.println("Enter in a ticket number to delete");
                int ticket = input.nextInt();
                try {
                    event.delete(ticket);
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
                break;
            }
            case 5:{
                System.out.println("__________Filled Seats___________");
                System.out.println(event.toString());
                break;
            }
            case 6: {
                System.exit(0);
            }
        }
    }
    
    public static void main(String[] args) {
       
        StadiumHash event = new StadiumHash();
        
        System.out.println("Ticket DataBase with Perfect Hashing\n");
        System.out.println("Enter in inital ticket data for 3 seats: ");
        
        for(int i=0; i<=2; i++){
            try{
                event.insert();
            }catch (Exception e) {
                System.out.println(e);
            }
        }
        System.out.println("-----Database Operations-----");
        while(true){
            try{
                prompt();
                int opt = getOption();
                processOption(opt,event);
            }catch (Exception e) {
                System.out.println(e);
                }
            }    
    
    }  
}
