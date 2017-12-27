/*
 * Assignment 8B
 * Brian Kalinowski
 * Question 35
 */
package sortingalgorithms;


public class MergeSort{
    
    public  static int swaps = 0;
    public static int comparisons = 0;
    
    public static void getStats(){
        System.out.println("Number of swaps: " + swaps);
        System.out.println("Number of compairsons: " + comparisons);
    }
    
    public static void mergeSort(int arr[], int left, int right){
        
        if(left < right){
            int mid = (left + right)/2;
            mergeSort(arr,left,mid);
            mergeSort(arr,mid+1,right);
            merge(arr,left,mid,right);
        }
    }            

    public static void merge(int arr[], int left, int mid, int right){
        
        int size1 = mid-left+1;
        int size2 = right - mid;
        
        int[] leftTemp = new int[size1];
        int[] rightTemp = new int[size2];
        
        for(int i=0; i<size1; i++){
            leftTemp[i] = arr[left + i];
        } 
        for(int x=0; x<size2; x++){
            rightTemp[x] = arr[mid + 1 + x];
        }
        
        int leftIndex = 0;
        int rightIndex = 0;
        int returnIndex = left;
        
        while((leftIndex < size1) && (rightIndex < size2)){
            
            if(leftTemp[leftIndex] <= rightTemp[rightIndex]){
                arr[returnIndex] = leftTemp[leftIndex];
                leftIndex++;
                swaps++;
                
            }else{
                arr[returnIndex] = rightTemp[rightIndex];
                rightIndex++;
                swaps++;
            }
            returnIndex++;
            comparisons++;        
        }
        
        while(leftIndex < size1){
            arr[returnIndex] = leftTemp[leftIndex];
            leftIndex++;
            returnIndex++;
            swaps++;
            comparisons++;
        }
        
        while(rightIndex < size2){
            arr[returnIndex] = rightTemp[rightIndex];
            rightIndex++;
            returnIndex++;
            swaps++;
            comparisons++;
        }
    }
}

