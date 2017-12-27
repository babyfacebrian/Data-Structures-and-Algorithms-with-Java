/*
 * Assignment 8B
 * Brian Kalinowski
 * Question 35
 */
package sortingalgorithms;

import java.util.*;

public class BubbleSort {
    
    public static void bubbleSort(int[] arr){
        boolean filp = true;
        int pass = 1;
        int swapTotal= 0; 
        int comTotal=0;
        
        while(filp){
           int swapCount=0;
           int comCount=0;
                    
           filp = false;
           System.out.println("______Pass #: " + pass + "_____");
            for(int x=arr.length-1; x>0; x--){
                comCount++;                               
                if(arr[x] < arr[x-1]){
                     int temp = arr[x];
                     arr[x] = arr[x-1];
                     arr[x-1] = temp;
                     filp = true;
                     swapCount++;
                }
             }
            pass++;
            System.out.println("swaps: " + swapCount);
            System.out.println("compairsons: " + comCount);
            swapTotal += swapCount;
            comTotal += comCount;
        }
        
         System.out.println("\nTotal swaps: " + swapTotal);
         System.out.println("Total compairsons: " + comTotal);
        
        }
    }
    

    

   