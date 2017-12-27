/*
 * Assignment 4D
 * Brian Kalinowski
 * Quesiton 32
 */
package sllqueue;

import java.util.*;
import java.io.*;
import java.text.*;

public class SLLQueue {
    
    private LinkedList<studentNodes> doubleQueue;
    
    public SLLQueue(){
        this.doubleQueue = new LinkedList<studentNodes>(); 
    }
    
    public void enqueueFirst(){
        System.out.println("Enter an student to add to the FRONT of the SLL Queue:\n");
        studentNodes node = studentNodes.input();
        doubleQueue.add(0,node);
    }
    
    public void enqueueLast(){
        System.out.println("Enter an student to add to the BACK of the SLL Queue:\n");
        studentNodes node = studentNodes.input();
        doubleQueue.add(node);
    }
    
    public void dequeueFirst() throws Exception{
        if(doubleQueue.isEmpty()){
           throw new Exception("Queue Underflow Error: Queue is Empty");
        }
        studentNodes remove = doubleQueue.remove(0);
        System.out.println("REMOVED " + remove.getName() + " from the front of the queue.\n");
    }
    
    public void dequeueLast() throws Exception{
        if(doubleQueue.isEmpty()){
            throw new Exception("Queue Underflow Error: Queue is Empty");
        }
        studentNodes remove = doubleQueue.remove(doubleQueue.size()-1);
        System.out.println("REMOVED " + remove.getName() + " from the back of the queue.\n");
    }
    
    public String peekFirst() throws Exception{
        if(doubleQueue.isEmpty()){
           throw new Exception("Queue Underflow Error: Queue is Empty");
        }
        studentNodes peek = doubleQueue.get(0);
        return peek.toString();
    }
    
    public String peekLast() throws Exception{
        if(doubleQueue.isEmpty()){
           throw new Exception("Queue Underflow Error: Queue is Empty");
        }
        studentNodes peek = doubleQueue.get(doubleQueue.size()-1);
        return peek.toString();
    }
    
    public void output(){
        System.out.println("_____SLLQUEUE_____");
        for(int i=0; i<doubleQueue.size(); i++){
            System.out.println(doubleQueue.get(i).toString());
        }
    }
    
    
    public static void main(String[] args){
       
       Scanner input = new Scanner(System.in);
        
       SLLQueue test = new SLLQueue();
       
       System.out.println("Testing a double-ended singly linked list implemented as a queue structure.\n");
       System.out.println("Enter 3 students added to the front.\n");
       for(int i=1; i<=3; i++){
           test.enqueueFirst();
       }
       test.output(); 
       
       System.out.println("Enter 3 students added to the back.\n");
       for(int i=1; i<=3; i++){
           test.enqueueLast();
       }
       test.output(); 
       
       System.out.println("Testing Dequeue Front method.\n");
       try{
           test.dequeueFirst();
       }catch (Exception e){
           System.out.println(e.toString());
       }
       test.output();
       
       System.out.println("Testing Dequeue Last method.\n");
       try{
           test.dequeueLast();
       }catch (Exception e){
           System.out.println(e.toString());
       }
       test.output();
       
       System.out.println("Testing peek First method.\n");
       try{
           System.out.println(test.peekFirst());
       }catch (Exception e){
           System.out.println(e.toString());
       }
       test.output();
       
       System.out.println("Testing Peek Last method.\n");
       try{
           System.out.println(test.peekLast());
       }catch (Exception e){
           System.out.println(e.toString());
       }
       test.output();
 
    }
}
