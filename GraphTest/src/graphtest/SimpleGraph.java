/*
 * Assignment 9B
 * Brian Kalinowski
 * Question 36
 */
package graphtest;

import java.util.*;

public class SimpleGraph {
    
    private Listing vertex[];
    private int edge[][];
    private int max, vertices;
    
    public SimpleGraph(int n){
        vertex = new Listing[n];
        edge = new int[n][n];
        max = n;
        vertices = 0;
    }
    
    public boolean insertVertex(int vertexNumber, Listing newListing){
        if(vertexNumber > max){
            return false;
        }
        vertex[vertexNumber] = newListing.deepCopy();
        vertices++;
        return true;
    }
    
    public boolean insertEdge(int fromVertex, int toVertex){
        if(vertex[fromVertex] == null || vertex[toVertex] == null){
            return false;
        }
        edge[fromVertex][toVertex] = 1;
        return true;
    }
    
    public Listing fetchVertex(int n){
        if(n>=vertices){
            return null;
        }
        return vertex[n].deepCopy();
    }
    
    public void fetchEdge(int fromVertex, int toVertex){
        if(vertex[fromVertex] == null || vertex[toVertex] == null){
            System.out.println("One or more vertex not found"); 
        }
        if(edge[fromVertex][toVertex] == 1){
            System.out.println("Edge Found: \n" + vertex[fromVertex].toString() + " Flies to: " + vertex[toVertex].toString()); 
        }else{
            System.out.println(vertex[fromVertex].toString() + " Does not fly too " + vertex[toVertex].toString());
        }
    }
    
    public boolean deleteVertex(int vertexNumber){
        if(vertex[vertexNumber] == null){
            return false;
        }
        vertex[vertexNumber] = null;
        return true;
    }
    
    public boolean deleteEdge(int fromVertex, int toVertex){
        if(vertex[fromVertex] == null || vertex[toVertex] == null){
            return false;
        }
        edge[fromVertex][toVertex] = 0;
        return true;
    }
    
    public boolean updateVertex(int vertexNumber, Listing newListing){
        deleteVertex(vertexNumber);
        vertex[vertexNumber] = newListing.deepCopy();
        return true;
    }
    
    public boolean updateEdge(int fromVertex, int toVertex){
        Scanner input = new Scanner(System.in);
        if(!deleteEdge(fromVertex,toVertex)){
            return false;
        }
        deleteEdge(fromVertex,toVertex);
        
        System.out.println("Enter in a new vertex number");
        int newflight = input.nextInt();
        
        insertEdge(fromVertex,newflight);
        return true;
    }
    
    public void showVertex(int vertexNumber){
        System.out.println(vertex[vertexNumber]);
    }
    
    public void showEdges(int vertexNumber){
        for(int column=0; column<vertices; column++){
            if(edge[vertexNumber][column] == 1 && vertex[column] != null){
                System.out.println("Edge: " + vertex[vertexNumber].toString() + " Flies to: " + vertex[column].toString());
            }
        }
    }       
}
