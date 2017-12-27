/*
 * Assignment 3B
 * Brian Kalinowski
 * Question # (21)
 */
package stackclass;

import java.util.*;


public class StackClass {

    private Listing[] data;
    private int top;
    private int size;
    
    public StackClass(int s){
        this.top = -1;
        this.size = s;
        this.data = new Listing[size];
    }
    
    
    public boolean push(Listing newNode){ // new push that expands data.
        size = size +1;
        if(top == size -1){
            return false;
        }
        else{
            top = top +1;
            data = Arrays.copyOf(data, size);
            data[top] = newNode.deepCopy();
            return true;
        }
    }
    
    public Listing pop(){
        int topLocation;
        if(top == -1){
            return null;
        }
        else{
            topLocation = top;
            top = top -1;
            return data[topLocation];
        }
    }
    public int getSize(){
        return data.length;
    }
    
    public void showAll(){
        for(int i=data.length-1; i>=0; i--){
            System.out.println(data[i]);
        }
    }
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("Adding 3 listings to start (max size of stack)");
        
        
        StackClass testStack = new StackClass(3);   

        for(int i=0; i<3; i++){
            Listing stacklisting = new Listing();
            stacklisting.input();
            testStack.push(stacklisting);
        }
        System.out.println("Staring with 3 nodes and adding one we should now have a size of 6");
        System.out.println("Current size: " + testStack.getSize());

        
        System.out.println("Testing if we get an over flow\n");
        Listing extra = new Listing();
        extra.input();
        testStack.push(extra);
        
        System.out.println("New size: " + testStack.getSize());
        
        System.out.println("Lets add one more\n");
        Listing onemore = new Listing();
        onemore.input();
        testStack.push(onemore);
        
        System.out.println("New size: " + testStack.getSize());
        testStack.showAll();

    }
    
}
