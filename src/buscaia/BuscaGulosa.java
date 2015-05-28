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

    public String BuscaGulosa(String start, String end) {
        List<Vertex> frontier = new LinkedList<>();
        List<Vertex> expanded = new LinkedList<>();

        Vertex initialVertex = searchVertex(start);
        Vertex finalVertex = searchVertex(end);
        if (initialVertex == null || finalVertex == null) {
            return "Não existe um dos vertices";
        }

        frontier.add(initialVertex);

        Vertex removed = null;
        while (!expanded.contains(finalVertex)) {

            removed = frontier.remove(0);

            Set<DefaultWeightedEdge> temp = stringGraph.edgesOf(removed);
            for (DefaultWeightedEdge atual : temp) {
                if ((!frontier.contains(stringGraph.getEdgeTarget(atual))) && !expanded.contains(stringGraph.getEdgeTarget(atual))) {
                    frontier.add(searchVertex(stringGraph.getEdgeTarget(atual).getName()));
                }else if((!frontier.contains(stringGraph.getEdgeTarget(atual)))){
                    
                }

            }
            expanded.add(removed);

            ordenaFrontier(frontier);

        }
        return "existe";
    }
//Graph creation

    private static SimpleDirectedWeightedGraph<Vertex, DefaultWeightedEdge> createStringGraph() {
        SimpleDirectedWeightedGraph<Vertex, DefaultWeightedEdge> g = new SimpleDirectedWeightedGraph<>(DefaultWeightedEdge.class);
        Vertex Itaipu = new Vertex("Itaipu", 4);
        Vertex SaoFrancisco = new Vertex("São Francisco", 10);
        Vertex Icarai = new Vertex("Icaraí", 12);
        Vertex Centro = new Vertex("Centro", 15);
        Vertex Charitas = new Vertex("Charitas", 23);

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
        for (Vertex atual : vertices) {
            if (atual.getName().equals(name)) {
                return atual;
            }
        }
        return null;
    }

    private void ordenaFrontier(List<Vertex> lista) {
        Vertex temp;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getPeso() > lista.get(i++).getPeso()) {
                temp = lista.get(i++);
                lista.set(i, lista.get(i++));
                lista.set(i, temp);
            }

        }
    }
}
