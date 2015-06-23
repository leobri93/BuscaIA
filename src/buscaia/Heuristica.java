/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaia;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

/**
 *
 * @author Leonardo
 */
public class Heuristica {

    SimpleWeightedGraph<Vertex, DefaultWeightedEdge> graph;
    int tipoHeuristica = 0;

    Heuristica(SimpleWeightedGraph<Vertex, DefaultWeightedEdge> pGraph) {
        this.graph = pGraph;
    }
    
    Heuristica(SimpleWeightedGraph<Vertex, DefaultWeightedEdge> pGraph, int tipoHeuristica) {
        this.graph = pGraph;
        this.tipoHeuristica = tipoHeuristica;
    }
    
    public void setTipoHeuristica(int tipoHeuristica){
        this.tipoHeuristica = tipoHeuristica;
    }

    public double retornaPesoVertice(Vertex v) {
        return v.getHeuristica();
    }

    public double retornaPesoAresta(SimpleWeightedGraph<Vertex, DefaultWeightedEdge> sg, DefaultWeightedEdge d) {
        return sg.getEdgeWeight(d);
    }
    
    /**
     * Recebe um Vertex e retorna a heuristca de acordo com o tipo de heurística passado
     * 
     * @param atual
     * @param end
     * @return 
     */
    public double heuristica(Vertex atual, Vertex end){
        if(tipoHeuristica == 1){
           return heuristica1(atual, end);
        }
        if(tipoHeuristica == 2){
            return heuristica2(atual, end);
        }
        return 0;
    }

    /**
     * Recebe um Vertex e retorna a heuristca (Distância Euclidiana)
     *
     * @param atual Vertex a ser calculada a heuristica
     * @param end Vertex final (Objetivo a ser encontrado o caminho)
     * @return
     */
    private double heuristica1(Vertex atual, Vertex end) {
        double diferencaX = end.getLongitudeCentral() - atual.getLongitudeCentral();
        double diferencaY = end.getLatitudeCentral() - atual.getLatitudeCentral();
        return Math.pow(((diferencaX * diferencaX) + (diferencaY * diferencaY)), 1 / 2);
    }

    /**
     * Recebe um Vertex e retorna a heuristca ()
     * 
     * @param atual Vertex a ser calculada a heuristica
     * @param end Vertex final (Objetivo a ser encontrado o caminho)
     * @return 
     */
    private double heuristica2(Vertex atual, Vertex end) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
