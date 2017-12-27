/*
 * Assignment 5D
 * Brian Kalinowski
 * Question 48
 */
package collegehash;

import java.util.*;
import java.io.*;
import java.text.*;

public class studentHash {
  
    private Hashtable<Integer,Student> college;
    private static final double p = 0.33;
    
    public studentHash(int max){
        
        // sets the primary storage area to appropriate percentage of max size
        int prime = (int) Math.round(max + (p * max));
        
        // fixes loading factor to 0.75
        this.college = new Hashtable<>(prime);
    }
    
    void insert() throws Exception{
        Student node = Student.input();
        if(college.get(node.getID()) != null){
            throw new Exception("Studnet ID is already filled");
        }
        college.put(node.getID(), node);
    }
    
    Student fetch(int key)throws Exception{
        if(college.get(key) == null){
            throw new Exception("NULL: studnet not in database");
        }        
        return college.get(key).deepCopy();
    }
    
    void delete(int key) throws Exception{
        if(college.get(key) == null){
            throw new Exception("NULL: student not in database");
        } 
        college.remove(key);
    }
    
    void update(int key) throws Exception{
        if(college.get(key) == null){
            throw new Exception("NULL: student not in database, insert before updating");
        } 
        Student newStudent = Student.input();
        college.remove(key);
        college.put(key, newStudent);
    }
    
    String output(){
       StringBuilder output = new StringBuilder();
       for(int key : college.keySet()){
           if(college.get(key) != null){
               output.append(college.get(key).toString());
               output.append("\n");
           }
        }
        return output.toString();
    }

}
