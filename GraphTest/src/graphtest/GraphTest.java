/*
 * Assignment 9B
 * Brian Kalinowski
 * Question 36 & 37
 */
package graphtest;

import java.util.*;

public class GraphTest {

    public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
        
      SimpleGraph flyUS = new SimpleGraph(5);
      WeightedGraph flyUSWeighted = new WeightedGraph(5);   
        
//add the hub cities to the graph as vertices
        Listing v0 = new Listing("Chicago");
        Listing v1 = new Listing("New York");
        Listing v2 = new Listing("Austin");
        Listing v3 = new Listing("Los Angeles");
        Listing v4 = new Listing("San Francisco");

        flyUS.insertVertex(0, v0);
        flyUS.insertVertex(1, v1);
        flyUS.insertVertex(2, v2);
        flyUS.insertVertex(3, v3);
        flyUS.insertVertex(4, v4);     
        
// Chicago flys everywhere
        flyUS.insertEdge(0,1);
        flyUS.insertEdge(0,2);
        flyUS.insertEdge(0,3);
        flyUS.insertEdge(0,4);
// NYC to LA and LA to nyc
        flyUS.insertEdge(1,3);
        flyUS.insertEdge(3,1);

// San Francisco to LA and nyc
       flyUS.insertEdge(4,3);
       flyUS.insertEdge(4,1); 

// Austin to LA and Chicago
        flyUS.insertEdge(2,0);
        flyUS.insertEdge(2,3);

        System.out.println("_____SIMPLE GRAPH TESTS_____\n");
        
        System.out.println("_____Testing Fetch Vertex_____");
        System.out.println("Enter in a vertex number: (0-4)");
        int fetchTest = input.nextInt();
        System.out.println(flyUS.fetchVertex(fetchTest));
        
        System.out.println("_____Testing Fetch Edge_____\n");
        System.out.println("Enter in a vertex number: (0-4)");
        int fetchEdge = input.nextInt();
        flyUS.fetchEdge(fetchTest, fetchEdge);
        
        
        System.out.println("_____Testing Update Vertex_____");
        System.out.println("Enter in a vertex number: (0-4)");
        int updateTest = input.nextInt();
        flyUS.showVertex(updateTest);
        
        Listing vUpdate = new Listing("Cleveland");
        flyUS.updateVertex(updateTest, vUpdate);
        flyUS.showVertex(updateTest);
        
        System.out.println("_____Testing Update Edge_____");
        
        System.out.println("Enter in a vertex number: (0-4)");
        int edgeFrom = input.nextInt();
        flyUS.showEdges(edgeFrom);
        
        System.out.println("Choose a destination city from above to change: ");
        int edgeTo = input.nextInt();
        
        flyUS.updateEdge(edgeFrom, edgeTo);
        flyUS.showEdges(edgeFrom);
        
        System.out.println("_____Testing Delete Vertex_____");
        System.out.println("Enter in a vertex number: (0-4)");
        int delete = input.nextInt();
        flyUS.showVertex(delete);
        flyUS.deleteVertex(delete);
        flyUS.showVertex(delete);

        System.out.println("_____Testing Delete Edge_____");
        System.out.println("Enter in a vertex number: (0-4)");
        int deleteEdge = input.nextInt();
        flyUS.showEdges(deleteEdge);
        System.out.println("Choose a destination city from above to change: ");
        int deleteTo = input.nextInt();
        
        flyUS.deleteEdge(deleteEdge, deleteTo);
        System.out.println("_____After Delete_____");
        flyUS.showEdges(deleteEdge);
        
        System.out.println("_____WEIGHTED GRAPH TESTS_____\n");
        flyUSWeighted.insertVertex(0, v0);
        flyUSWeighted.insertVertex(1, v1);
        flyUSWeighted.insertVertex(2, v2);
        flyUSWeighted.insertVertex(3, v3);
        flyUSWeighted.insertVertex(4, v4);
// Chicago flys everywhere
        flyUSWeighted.insertEdge(0,1);
        flyUSWeighted.insertEdge(0,2);
        flyUSWeighted.insertEdge(0,3);
        flyUSWeighted.insertEdge(0,4);
// NYC to LA and LA to nyc
        flyUSWeighted.insertEdge(1,3);
        flyUSWeighted.insertEdge(3,1);

// San Francisco to LA and nyc
       flyUSWeighted.insertEdge(4,3);
       flyUSWeighted.insertEdge(4,1); 

// Austin to LA and Chicago
        flyUSWeighted.insertEdge(2,0);
        flyUSWeighted.insertEdge(2,3);
        
        System.out.println("_____Testing Fetch Vertex_____\n");
        System.out.println(flyUS.fetchVertex(0));
        
        System.out.println("_____Testing Fetch Edge_____\n");
        flyUSWeighted.fetchEdge(0, 1);
        
        System.out.println("_____Testing Update Vertex_____");
        flyUSWeighted.showVertex(2);
        
        flyUSWeighted.updateVertex(2, vUpdate);
        flyUSWeighted.showVertex(2);
        
        System.out.println("_____Testing Update Edge_____");
        flyUSWeighted.showEdges(2);
        flyUSWeighted.updateEdge(2, 0);
        flyUSWeighted.showEdges(2);
       
        System.out.println("_____Testing Delete Vertex_____");
        flyUSWeighted.showVertex(2);
        flyUSWeighted.deleteVertex(2);
        flyUSWeighted.showVertex(2);

        System.out.println("_____Testing Delete Edge_____");
        flyUSWeighted.showEdges(4);
        flyUSWeighted.deleteEdge(4, 1);
        System.out.println("_____After Delete_____");
        flyUSWeighted.showEdges(4);
       
    }
    
}
