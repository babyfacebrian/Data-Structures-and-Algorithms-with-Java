/*
 * Assignment 5D
 * Brian Kalinowski
 * Question 48
 */
package collegehash;


import java.util.*;
import java.io.*;
import java.text.*;


public class Student {
    private int IDnumber;
    private String name;
    private double gpa;

    public Student(int id, String n, double gpa) {
        this.IDnumber = id;
        this.name = n;
        this.gpa = gpa;
    }

   @Override
    public String toString() {
        return ("ID: " + this.IDnumber + ", " + "Name: " + this.name + ", " + " GPA: "+ this.gpa);
    } 

    public Student deepCopy(){
        Student clone = new Student(IDnumber, name, gpa);
        return clone;
    }
    
    public int getID(){
        return this.IDnumber;
    }

    static Student input() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter ID Number: ");
        int id = input.nextInt();
        System.out.println("Enter Name: ");
        String n = input.next();
        System.out.println("Enter GPA: ");
        double gpa = input.nextDouble();
        return new Student(id, n, gpa);
    }
}
