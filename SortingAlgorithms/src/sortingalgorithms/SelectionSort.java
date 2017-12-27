/*
 * Assignment 8B
 * Brian Kalinowski
 * Question 35
 */
package sortingalgorithms;


public class SelectionSort {
    
    public static void selectionSort(int arr[]){
        boolean swapped = false;
        int swaps = 0;
        int comparisons = 0;
        
        for(int i=0; i<arr.length-1; i--){
            int min = i;
            for(int j=1; j<=i; j++){
                comparisons++;
                if(arr[j] > arr[min]){
                    min = j;
                    int temp = arr[min];
                    arr[min] = arr[i];
                    arr[i] = temp;
                    swapped=true;
                    swaps++;
                    comparisons++;
                }
            }
            
        }
        System.out.println("Number of swaps: " + swaps);
        System.out.println("Number of compairsons: " + comparisons);
    
     }    
}

