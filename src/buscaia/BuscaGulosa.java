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
      SimpleDirectedWeightedGraph<Vertex, DefaultWeightedEdge> stringGraph = createStringGraph();
      List<Vertex> vertices = new LinkedList<>();
      public String BuscaGulosa(String start, String end){
          //get the neighbours of the starting node
          Vertex initialVertex = searchVertex(start);
          if(initialVertex == null){
              return "Não existe esse vertice";
          }
          Set<DefaultWeightedEdge> temp = stringGraph.edgesOf(initialVertex);
          //put the neighbours in a List
          List<DefaultWeightedEdge> vizinhos;
          vizinhos = new LinkedList<>();
          vizinhos.addAll(temp);
          return "existe";
      }
//Graph creation
      private static SimpleDirectedWeightedGraph<Vertex, DefaultWeightedEdge> createStringGraph() {
      SimpleDirectedWeightedGraph<Vertex, DefaultWeightedEdge>  g = new SimpleDirectedWeightedGraph<>(DefaultWeightedEdge.class); 
        Vertex Itaipu = new Vertex("Itaipu",4);
        Vertex SaoFrancisco = new Vertex("São Francisco",10);
        Vertex Icarai = new Vertex("Icaraí",12);
        Vertex Centro = new Vertex("Centro",15);
        Vertex Charitas = new Vertex("Charitas",23);
       
        // add the vertices
        g.addVertex(Itaipu);
        g.addVertex(SaoFrancisco);
        g.addVertex(Icarai);
        g.addVertex(Centro);
        g.addVertex(Charitas);

        // add edges to create a circuit
        g.setEdgeWeight(g.addEdge(Itaipu, SaoFrancisco), 5);
        g.setEdgeWeight(g.addEdge(SaoFrancisco, Icarai), 12);
        g.setEdgeWeight(g.addEdge(SaoFrancisco, Charitas), 11);
        g.setEdgeWeight(g.addEdge(Icarai, Centro), 10);
        
        return g;
    }

    private Vertex searchVertex(String name) {
        for(Vertex atual: vertices){
            if(atual.getName().equals(name)){
                return atual;
            }
        }
        return null;
    }
}
