/*
 * Assignment 8B
 * Brian Kalinowski
 * Question 35
 */
package sortingalgorithms;

import java.util.*;

public class RandomIntegers {
    
    private Random randomInteger;
    private int testArray[];
    
    public RandomIntegers(int n, int bound){
        
        long seed = System.currentTimeMillis();
        randomInteger = new Random(seed);
        
        testArray = new int[n];
        for(int i=0; i<n; i++){
            testArray[i] = randomInteger.nextInt(bound);
        }
    }
    
    public int[] getArray(){
        return testArray;
    }
}
