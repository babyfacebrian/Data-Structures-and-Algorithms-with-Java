/*
 * Assignment 8B
 * Brian Kalinowski
 * Question 35
 */
package sortingalgorithms;

import java.util.*;

public class SortingAlgorithms {
    
    public static void printArray(int a[]){
       for(int i=0; i<a.length; i++){
         if(i % 5 == 0){
             System.out.println();
         }
         System.out.print(a[i] + ", ");
       }
       System.out.println("\n");
     }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("How many Integers would you like to sort?");
        int size = input.nextInt();
        
        int Randomtest[] = new int[size];
        int Randomtest2[] = new int[size];
        
        
        RandomIntegers rtest = new RandomIntegers(size,100);
        RandomIntegers stest = new RandomIntegers(size,100);
        Randomtest = rtest.getArray();
        Randomtest2 = stest.getArray();
     
        
        System.out.println("_____Unsorted Integers_____");
        printArray(Randomtest);
        
        System.out.println("_____Bubble Sort_____");
        BubbleSort.bubbleSort(Randomtest);
        System.out.println("Bubble Sorted Array: ");
        printArray(Randomtest);
        
//        System.out.println("_____Unsorted Integers_____");
//        printArray(Randomtest2);
//        
//        System.out.println("_____Selection Sort_____");
//        BubbleSort.bubbleSort(Randomtest2);
//        System.out.println("Selection Sorted Array: ");
//        printArray(Randomtest2);
        

    }
    
}
