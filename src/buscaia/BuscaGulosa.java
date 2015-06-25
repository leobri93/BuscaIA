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
import org.jgrapht.graph.SimpleWeightedGraph;

public class BuscaGulosa {

    //Graph definition
    SimpleWeightedGraph<Vertex, DefaultWeightedEdge> graph = GraphCreation.createVertexGraph();
    

    public String BuscaGulosa(String start, String end) {
        List<Vertex> frontier = new LinkedList<>();
        List<Vertex> expanded = new LinkedList<>();

        Vertex initialVertex = searchByName(start,graph);
        Vertex finalVertex = searchByName(end,graph);
        if (initialVertex == null || finalVertex == null) {
            return "Não existe um dos vertices";
        }

        frontier.add(initialVertex);

        
        while (!expanded.contains(finalVertex)) {

            Vertex removed = frontier.remove(0);

            Set<DefaultWeightedEdge> temp = graph.edgesOf(removed);
            //Loop para pegar cada aresta e adicionar a vizinhos somente as arestas que tem start como source
            List<DefaultWeightedEdge> arestas = new LinkedList<>();
            for (DefaultWeightedEdge each : temp) {
                if (graph.getEdgeSource(each).getName().equals(initialVertex.getName())) {
                    arestas.add(each);
                }
            }
            
            for (DefaultWeightedEdge atual : arestas) {
                if ((!frontier.contains(graph.getEdgeTarget(atual))) && !expanded.contains(graph.getEdgeTarget(atual))) {
                    frontier.add(searchByName(graph.getEdgeTarget(atual).getName(),graph));
                }

            }
            if(!expanded.contains(removed)){
                expanded.add(removed);
            }
            ordenaFrontier(frontier);
        }
        return "existe";
    }

    private Vertex searchByName(String name, SimpleWeightedGraph<Vertex, DefaultWeightedEdge> graph) {
        for (Vertex noAtual : graph.vertexSet()) {
            if (noAtual.getName().equals(name)) {
                return noAtual;
            }
        }
        return null;
    }

    private void ordenaFrontier(List<Vertex> lista) {
        Vertex temp;
        for (int i = 0; i < lista.size()-1; i++) {
            if (lista.get(i).getHeuristica() > lista.get(i+1).getHeuristica()) {
                temp = lista.get(i+1);
                lista.set(i, temp);
                lista.set(i+1, lista.get(i));
            }

        }
    }
}
