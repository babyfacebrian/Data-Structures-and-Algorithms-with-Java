/*
 * Assignment 9B
 * Brian Kalinowski
 * Question 37
 */
package graphtest;

import java.util.*;

public class WeightedGraph {
    
    private Listing vertex[];
    private int edge[][];
    private int weight[][];
    private int max, vertices;
    
    public WeightedGraph(int n){
        vertex = new Listing[n];
        edge = new int[n][n];
        weight = new int[n][n];
        max = n;
        vertices = 0;
        
    }
    
    public void weighingFactor(int fromVertex, int toVertex){
       Scanner input = new Scanner(System.in);
       System.out.println("Enter in the weighting factor of this edge: (default is 1)");
       System.out.println("Weight from " +  vertex[fromVertex].toString() + " to " + vertex[toVertex].toString());
       int factor = input.nextInt();
       
       if(factor == 1){
           weight[fromVertex][toVertex] = 1;
       }else{
           weight[fromVertex][toVertex] = factor;
       }
    }
    
    public boolean insertVertex(int vertexNumber, Listing newListing){
        if(vertexNumber >= max){
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
        weighingFactor(fromVertex,toVertex);
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
            System.out.println("Weight of Edge: " + weight[fromVertex][toVertex]);
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
        weight[fromVertex][toVertex] = 0;
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
            if(edge[vertexNumber][column] == 1){
                System.out.println("Edge: " + vertex[vertexNumber].toString() + " Flies to: " + vertex[column].toString() 
                + "\nWeight of Edge: " + weight[vertexNumber][column]);
            }
        }
    }
}
