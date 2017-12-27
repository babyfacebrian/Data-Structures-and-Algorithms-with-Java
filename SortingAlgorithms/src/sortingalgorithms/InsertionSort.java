/*
 * Assignment 8B
 * Brian Kalinowski
 * Question 35
 */
package sortingalgorithms;


public class InsertionSort {
    
    public static void insertionSort(int arr[]){
        int swaps = 0;
        int comparisons = 0;
        
        int size = arr.length;
        for(int i=1; i<size; i++){
            int key = arr[i];
            int value = i-1;
            comparisons++;
            while(value>=0 && arr[value] > key){
                comparisons++;
                arr[value+1] = arr[value];
                value--;
                
            }
            arr[value+1] = key;
            swaps++;
        }
        System.out.println("Number of swaps: " + swaps);
        System.out.println("Number of compairsons: " + comparisons);
    }
}
