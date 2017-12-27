/*
 * Assignment 7B
 * Brian Kalinowski
 * Question 30/31
 */
package collegebinarytree;

import java.util.*;
import java.io.*;
import java.text.*;

public class CollegeBinaryTree {
    
    private static void prompt(){
        System.out.println("Choose a option:");
        System.out.println("1 : Insert a student");
        System.out.println("2 : Fetch students info");
        System.out.println("3 : Delete a students info");
        System.out.println("4 : Update a students info");
        System.out.println("5 : Print all students");
        System.out.println("6 : Exit College Database");
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
    
    private static void processOption(int opt, studentBinaryTree tree){
        Scanner input = new Scanner(System.in);
        
        switch(opt){
            case 1:
                try{  
                    tree.insert();
                }catch(Exception e){
                    System.out.println(e.toString());
                }
                break;
            case 2:{
                System.out.println("Enter in a Students Name: ");
                String key = input.nextLine();
                try{
                    System.out.println("Fetched: " + tree.fetch(key).toString());
                }catch (Exception e){
                    System.out.println(e.toString());
                }
                break;
            }
            case 3:{
                System.out.println("Enter in a Students Name: "); 
                String key = input.nextLine();
                try{
                    System.out.println("Deleting Student: " + key);   
                    tree.delete(key);
                }catch (Exception e){
                    System.out.println(e.toString());
                }
                break;
            }
            case 4:{
                System.out.println("Enter in a Students Name: "); 
                String key = input.nextLine();
                try{
                    tree.update(key);
                }catch (Exception e){
                    System.out.println(e.toString());
                }
                break;
            }
            case 5:{
                System.out.println("_______Students_______");
                tree.output();
                break;
            }
            case 6:{
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Student Database using A Binary Search Tree\n");
        
        studentBinaryTree test = new studentBinaryTree();
        
        System.out.println("How many students would you like to add?");
        int inital = input.nextInt();
        for(int i=1; i<=inital; i++){
            try{
                test.insert();
            }catch (Exception e){
                System.out.println(e.toString());
            }
        }
        System.out.println("_____Database Operations_____");
        while(true){
            try{
                prompt();
                int opt = getOption();
                processOption(opt,test);
            }catch (Exception e) {
                System.out.println(e);
                }
            } 
        
    }
    
}
