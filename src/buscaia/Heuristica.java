/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaia;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;

/**
 *
 * @author Leonardo
 */
public class Heuristica {
    
    
    public int retornaPesoVertice(Vertex v){
        return v.getPeso();
    }
    
    public int retornaPesoAresta(SimpleDirectedWeightedGraph<Vertex, DefaultWeightedEdge> sg, DefaultWeightedEdge d){
        return 0;
    }
}
