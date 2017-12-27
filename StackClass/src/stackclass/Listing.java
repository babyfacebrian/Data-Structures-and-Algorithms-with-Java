/*
 * Assignment 3B
 * Brian Kalinowski
 * Question # 41
 */
package stackclass;

import java.util.*;
import java.io.*;
import java.text.*;


public class Listing
{ private String name;  // key field
   private String address;
   private String number;
   
     public Listing()
  {  name = "";
     address = "";
     number = "";
  }
   public Listing(String n, String a, String num )
  {  this.name = n;
      this.address = a;
      this.number = num;
  }
   public String toString( )
   {   return("Name is " + name +
                    "\nAddress is " + address +
                    "\nNumber is " + number + "\n");
   }
   public Listing deepCopy( )
   {  Listing clone = new Listing(name, address, number);
      return clone;
   }
   public int compareTo(String targetKey)
   {  return(name.compareTo(targetKey));
   }
   
   public void input( ){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter in a name: ");
        name = input.nextLine();
        
        System.out.print("Enter in a address: ");
        address = input.nextLine();
        
        System.out.print("Enter in phone number: ");
        number = input.nextLine();
   }

} 