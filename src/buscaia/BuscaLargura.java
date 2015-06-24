/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaia;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
//import org.jgrapht.graph.DefaultEdge;
//import org.jgrapht.UndirectedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;
//import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.graph.SimpleWeightedGraph;

public class BuscaLargura {

    //UndirectedGraph<String, DefaultEdge> stringGraph = createStringGraph();
    public List<String> BuscaEmLargura(String startRoad, String endRoad) throws IOException {
        //cria um grafo com as informações provenientes do arquivo
        SimpleWeightedGraph<Vertex, DefaultWeightedEdge> graph = GraphCreation.createGraph();

        //cria os vertices Inicio e Fim
        Vertex start = searchByName(startRoad, graph);
        Vertex end = searchByName(endRoad, graph);

        if (start != null && end != null) {
            // retorna as arestas dos vizinhos de start
            Set<DefaultWeightedEdge> tempRetorno = graph.edgesOf(start);
            // Cria uma fila de vizinhos e adiciona os vizinhos
            Queue<DefaultWeightedEdge> vizinhos = new LinkedList<>();

            //Loop para pegar cada aresta e adicionar a vizinhos somente as arestas que tem start como source
            for (DefaultWeightedEdge each : tempRetorno) {
                if (graph.getEdgeSource(each).equals(start)) {
                    vizinhos.add(each);
                }
            }
            //vizinhos.addAll(tempRetorno);

            //cria uma lista de vistados e adiciona o nó inicial
            List<Vertex> visitados = new ArrayList<>();
            visitados.add(start);
            DefaultWeightedEdge temp = null;
            //Enquanto tem vizinhos
            while (!vizinhos.isEmpty()) {
                //Se o vizinho nao foi visitado
                if (!visitados.contains(graph.getEdgeTarget(vizinhos.peek()))) {
                    temp = vizinhos.poll();
                    //Seta o pai do proximo vertice
                    graph.getEdgeTarget(temp).setPai(graph.getEdgeSource(temp));
                    //Adiciona o vizinho aos visitados
                    visitados.add(graph.getEdgeTarget(temp));
                }
                //Se chegou ao fim
                if (graph.getEdgeTarget(temp).equals(end)) {
                    //
                    return path(graph.getEdgeTarget(temp));
                } else {
                    //Se não chegou ao fim, adiciona as arestas a partir do target a lista de vizinhos
                    for (DefaultWeightedEdge each : graph.edgesOf(graph.getEdgeTarget(temp))) {
                        //Se a origem da aresta for igual ao destino de temp e vizinhos não contem o destino da aresta e o destino da aresta não foi vizitado.
                        if (graph.getEdgeSource(each).equals(graph.getEdgeTarget(temp)) && !vizinhos.contains(graph.getEdgeTarget(each)) && !visitados.contains(graph.getEdgeTarget(each))) {
                            vizinhos.add(each);
                        }
                    }
                    //vizinhos.addAll(graph.edgesOf(graph.getEdgeTarget(temp)));
                }
            }
        }
        return null;
    }

    private List<String> path(Vertex end) {

        List<String> list = new LinkedList<>();
        list.add(end.getName());
        Vertex temp = end.getPai();
        while (temp != null) {
            list.add(temp.getName());
            temp = temp.getPai();
        }
        return list;
    }

    //Criar um metodo que 
//    //Graph creation
//    private static UndirectedGraph<String, DefaultEdge> createStringGraph() {
//        UndirectedGraph<String, DefaultEdge> g
//                = new SimpleGraph<String, DefaultEdge>(DefaultEdge.class);
//        
//        String Itaipu = "Itaipu";
//        String Sao_Francisco = "Sao Francisco";
//        String Icarai = "Icarai";
//        String Centro = "Centro";
//        String Charitas = "Charitas";
//
//        // add the vertices
//        g.addVertex(Itaipu);
//        g.addVertex(Sao_Francisco);
//        g.addVertex(Icarai);
//        g.addVertex(Centro);
//        g.addVertex(Charitas);
//
//        // add edges to create a circuit
//        g.addEdge(Itaipu, Sao_Francisco);
//        g.addEdge(Sao_Francisco, Icarai);
//        g.addEdge(Sao_Francisco, Charitas);
//        g.addEdge(Icarai, Centro);
//
//        return g;
//    }
    private Vertex searchByName(String name, SimpleWeightedGraph<Vertex, DefaultWeightedEdge> graph) {
        for (Vertex noAtual : graph.vertexSet()) {
            if (noAtual.getName().equals(name)) {
                return noAtual;
            }
        }
        return null;
    }
}
