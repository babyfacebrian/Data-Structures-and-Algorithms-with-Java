/*
 * Binary search by hand.
 */
package binarysearch;

import java.util.*;
import java.io.*;
import java.text.*;

public class BinarySearch {
    
    public static int numBinarySearch(int arr[],int target){
        
        Arrays.sort(arr); // sorting the array before any operaitons.
        int low = 0;
        int high = arr.length - 1;
        
        while(low <= high){
            int mid = low + (high-1)/2;        
            
// If target is greater than the midpoint, ignore the left(small) half
            if(arr[mid] < target){
                low = mid + 1;
            }
// If the target is smaller than the midpoint ignore the right(large) half 
            else if (arr[mid] > target){
                high = mid -1 ;
            }
            else{
                return mid;
            }
        }
        return -1;             
    }
    
    public static int StringBinarySearch(String arr[], String target){
        Arrays.sort(arr);
        int low = 0;
        int high = arr.length -1;
        
        
        while(low <= high){
            int mid = (low + high)/2;
// compare two strings lexicographically  
// Check if target is present at the midpoint
            
// If target is greater than the midpoint, ignore the left(small) half
            if(arr[mid].compareTo(target) < 0){
                low = mid + 1;
            }
            else if(arr[mid].compareTo(target) > 0){
                high = mid - 1;
            }
// If the target is smaller than the midpoint ignore the right(large) half 
            else{
                 return mid;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        int arraySize = 6; // edit to add more.????????????
        
        int[] numbers = new int[arraySize];        
        for(int i=0; i<numbers.length; i++){
            System.out.println("enter number: ");
            numbers[i] = input.nextInt();
        }
        System.out.println("Enter in the number to search:");
        
        int targetNum = input.nextInt();
        int numIndex = numBinarySearch(numbers, targetNum);
        
        System.out.println("Binary seach on numbers");
        System.out.println("the number is at index: " + numIndex);
        System.out.println("The number is: " + numbers[numIndex]);
        
       
        String[] names = new String[arraySize];
        for(int i=0; i<names.length; i++){
            System.out.println("enter a name: ");
            names[i] = input.next();
        }
        System.out.println("Enter in the name to search:");
       
        String targetName = input.next();
        int stringIndex = StringBinarySearch(names, targetName);
       
        System.out.println("Binary seach on Strings");
        System.out.println("the number is at index: " + stringIndex);
        System.out.println("the name is: " + names[stringIndex]);
     
     }

}