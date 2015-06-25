package buscaia;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

public class BuscaAEstrela {

    public List<String> buscaAEstrela(String pStart, String pEnd) throws IOException {
        SimpleWeightedGraph<Vertex, DefaultWeightedEdge> graph = GraphCreation.createGraph();

        Vertex start = searchByName(pStart, graph);
        Vertex end = searchByName(pEnd, graph);

        if (start != null && end != null) {
            
            Queue<Frontier> frontier = new LinkedList<>();
            List<Vertex> visitados = new LinkedList<>();
            
            visitados.add(start);
            Vertex atual = frontier.poll().getVertice();
            
            List<Frontier> listaDesordenada = new LinkedList<>();
            
            while(!atual.equals(end)){
                for(DefaultWeightedEdge aresta : graph.edgesOf(atual)){
                    if(graph.getEdgeSource(aresta).equals(atual)){
                        Frontier tempFrontier = new Frontier(graph.getEdgeTarget(aresta), graph.getEdgeWeight(aresta)+graph.getEdgeTarget(aresta).getHeuristica());
                        listaDesordenada.add(tempFrontier);
                    }
                }
                insereOrdenadoNoFrontier(listaDesordenada, frontier);
                
            }
        }

        return null;
    }

    private Vertex searchByName(String name, SimpleWeightedGraph<Vertex, DefaultWeightedEdge> graph) {
        for (Vertex noAtual : graph.vertexSet()) {
            if (noAtual.getName().equals(name)) {
                return noAtual;
            }
        }
        return null;
    }

    private void insereOrdenadoNoFrontier(List<Frontier> listaDesordenada, Queue<Frontier> frontier) {
        while(!frontier.isEmpty()){
            listaDesordenada.add(frontier.poll());
        }
        Frontier[] arrayDeFrontier = new 
        Sort. ordena = new Sort();
    }

}
