/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaia;


import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;



public class BuscaGulosa {
    
      //Graph definition
      SimpleDirectedWeightedGraph<String, DefaultWeightedEdge> stringGraph = createStringGraph();
      
      public void BuscaGulosa(String start, String end){
          //get the neighbours of the starting node
          Set<DefaultWeightedEdge> temp = stringGraph.edgesOf(start);
          //put the neighbours in a List
          List<DefaultWeightedEdge> vizinhos;
          vizinhos = new LinkedList<>();
          vizinhos.addAll(temp);
          
      }
//Graph creation
      private static SimpleDirectedWeightedGraph<String, DefaultWeightedEdge> createStringGraph() {
      SimpleDirectedWeightedGraph<String, DefaultWeightedEdge>  g = new SimpleDirectedWeightedGraph<>(DefaultWeightedEdge.class); 
            
        String Itaipu = "Itaipu";
        String Sao_Francisco = "Sao Francisco";
        String Icarai = "Icarai";
        String Centro = "Centro";
        String Charitas = "Charitas";

        // add the vertices
        g.addVertex(Itaipu);
        g.addVertex(Sao_Francisco);
        g.addVertex(Icarai);
        g.addVertex(Centro);
        g.addVertex(Charitas);

        // add edges to create a circuit
        g.setEdgeWeight(g.addEdge(Itaipu, Sao_Francisco), 5);
        g.setEdgeWeight(g.addEdge(Sao_Francisco, Icarai), 12);
        g.setEdgeWeight(g.addEdge(Sao_Francisco, Charitas), 15);
        g.setEdgeWeight(g.addEdge(Charitas, Centro), 30);
        g.setEdgeWeight(g.addEdge(Icarai, Centro), 10);
        
        return g;
    }
}
