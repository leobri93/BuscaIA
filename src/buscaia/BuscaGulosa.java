/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaia;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;

public class BuscaGulosa {

    //Graph definition
    SimpleDirectedWeightedGraph<Vertex, DefaultWeightedEdge> graph = GraphCreation.createGraph();
    List<Vertex> vertices = new LinkedList<>();

    public String BuscaGulosa(String start, String end) {
        Queue<Vertex> frontier = new LinkedList<>();
        List<Vertex> expanded = new LinkedList<>();
        //Busca no grafo pela rua com nome star e coloca em initialVertex
        Vertex initialVertex = searchVertex(start);
        //Busca no grafo pela rua com nome end e coloca em finalVertex
        Vertex finalVertex = searchVertex(end);
        //Se eles não existirem
        if (initialVertex == null || finalVertex == null) {
            //Se um dos vertices não existir
            return "Não existe um dos vertices";
        }

        //Adiciona o vertice inicial ao frontier
        frontier.add(initialVertex);

        Vertex removedFromFrontier = null;
        while (!expanded.contains(finalVertex)) {

            //Se não tem ninguem no frontier
            if (frontier.isEmpty()) {
                //Erro
                return "Não encontrado";
            }

            //Remove o primeiro da fila do frontier
            //removed = frontier.remove(0);
            removedFromFrontier = frontier.poll();

            //Se o no removido do frontier for a solução
            if (removedFromFrontier.equals(end)) {
                //Retorna a solução
                return "Solução";
            }
            //Adiciona removedFromFrontier no expanded
            expanded.add(removedFromFrontier);

            //Pega todas as arestas com origem no removedFromFrontier
            Set<DefaultWeightedEdge> temp = graph.edgesOf(removedFromFrontier);

            //Percorre todas as arestas removidas
            for (DefaultWeightedEdge atual : temp) {
                //Se o destino da aresta não esta no frontier nem no expanded
                if ((!frontier.contains(graph.getEdgeTarget(atual))) && !expanded.contains(graph.getEdgeTarget(atual))) {
                    //Passa o nome do target pro searchVertex para ele retornar o vertex com esse nome e add no frontier
                    frontier.add(searchVertex(graph.getEdgeTarget(atual).getName()));
                } else if ((frontier.contains(graph.getEdgeTarget(atual)) && (heuristica1(graph.getEdgeTarget(atual), finalVertex) < heuristica1(atual, finalVertex)))) {

                }

            }
            expanded.add(removedFromFrontier);

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
            if (lista.get(i).getHeuristica() > lista.get(i++).getHeuristica()) {
                temp = lista.get(i++);
                lista.set(i, lista.get(i++));
                lista.set(i, temp);
            }

        }
    }
    
    private double heuristica1(Vertex no, Vertex end){
        return 0;
    }
}
