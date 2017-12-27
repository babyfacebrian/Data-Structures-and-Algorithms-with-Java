/*
 * Assignment 4D
 * Brian Kalinowski
 * Quesiton 32
 */
package sllqueue;

import java.util.*;
import java.io.*;
import java.text.*;

public class studentNodes {

    private String name;
    private int IDnumber;
    private double gpa;

    public studentNodes(String n, int id, double gpa) {
        this.name = n;
        this.IDnumber = id;
        this.gpa = gpa;
    }

   @Override
    public String toString() {
        return ("Name : " + this.name + ", " + " ID: " + this.IDnumber + ", " + " GPA: "+ this.gpa);
    } 

    public studentNodes deepCopy(){
        studentNodes clone = new studentNodes(name , IDnumber, gpa);
        return clone;
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getTarget(String targetKey){
        return(name.compareTo(targetKey));
    }

    static studentNodes input() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter name");
        String n = input.nextLine();
        System.out.println("enter id number");
        int id = input.nextInt();
        System.out.println("enter gpa");
        double gpa = input.nextDouble();
        return new studentNodes(n, id, gpa);
    }
}
