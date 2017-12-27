/*
 * Assignment 6B
 * Brian Kalinowski
 * Question Combinations(chap. 6)
 */
package combinationssolver;

import java.util.*;
import java.math.BigInteger;

public class CombinationsSolver{
    
//recursive method to find the factorial value
    public static BigInteger factorial(BigInteger num){
        if(num.equals(BigInteger.ZERO)){
            return BigInteger.ONE;
        }else{
            BigInteger nMin = factorial(num.subtract(BigInteger.ONE));
            return num.multiply(nMin);
        }
    }
        
//recursive method for the combinations formula
    public static BigInteger Combinations(BigInteger target, BigInteger total){
        if(target.equals(BigInteger.ZERO)){
            return BigInteger.ONE;
        }
        else if(total.equals(target)){
            return BigInteger.ONE;
        }else{
            return Combinations(target.subtract(BigInteger.ONE), 
                    total.subtract(BigInteger.ONE)).add(Combinations(target, total.subtract(BigInteger.ONE)));
        }
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        System.out.println("_____Recursive Factorial Tests_____\n");
        System.out.println("_____Testing  Factorial Method_____");
        System.out.println("Enter in an Integer: ");
        BigInteger test = input.nextBigInteger();
        System.out.println("Factorial of " + test + " is: " + factorial(test) + "\n");
        
        System.out.println("_____Combinations Test_____");
        System.out.println("How many total options?: ");
        BigInteger opt = input.nextBigInteger();
        
        System.out.println("Enter in a subset: ");
        BigInteger set = input.nextBigInteger();
        System.out.println("");         

        System.out.println("There are " + Combinations(set,opt) + " ways of choosing " 
                + set + " things from a total set of " + opt + " things.");     
      
    }
    
}
 