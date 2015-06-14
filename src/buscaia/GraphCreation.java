/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaia;

import java.io.FileNotFoundException;
import java.util.Set;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;


public class GraphCreation {
    public SimpleDirectedWeightedGraph<Vertex, DefaultWeightedEdge> createGraph() throws FileNotFoundException{
        FileReader f = new FileReader();
        Set<Vertex> nós = f.reader();
        SimpleDirectedWeightedGraph<Vertex, DefaultWeightedEdge> graph = new SimpleDirectedWeightedGraph<>(DefaultWeightedEdge.class);
        for (Vertex nóAtual : nós) {
            graph.addVertex(nóAtual);
        }
        
        return graph;
    }
}
