/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaia;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
//import org.jgrapht.graph.DefaultEdge;
//import org.jgrapht.UndirectedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;
//import org.jgrapht.graph.SimpleGraph;


public class BuscaLargura {

    //UndirectedGraph<String, DefaultEdge> stringGraph = createStringGraph();
    
    public String BuscaEmLargura (String startRoad, String endRoad) throws FileNotFoundException{
        //cria um grafo com as informações provenientes do arquivo
        SimpleDirectedWeightedGraph<Vertex, DefaultWeightedEdge> graph = GraphCreation.createGraph();
        
        //cria os vertices Inicio e Fim
        Vertex start = new Vertex();
        Vertex end = new Vertex();
        
        //set o nome das ruas nos respectivos vertices
        start.setName(startRoad);
        end.setName(endRoad);
        
        if(graph.containsVertex(start) && graph.containsVertex(end)){
            Set<DefaultWeightedEdge> tempRetorno = graph.edgesOf(start);
            Queue<DefaultWeightedEdge> vizinhos = new LinkedList<>();
            vizinhos.addAll(tempRetorno);
            List<Vertex> visitados = new ArrayList<>();
            visitados.add(start);
            DefaultWeightedEdge temp = null;
            while(!vizinhos.isEmpty()){
                if(!visitados.contains(vizinhos.peek())){
                    temp = vizinhos.poll();
                }
                visitados.add(graph.getEdgeSource(temp));
                if(graph.getEdgeTarget(temp).equals(end)){
                    //falta o caminho
                    return "Show";
                }else{
                    vizinhos.addAll(graph.edgesOf(graph.getEdgeTarget(temp)));
                }
            }
        }
//        if(stringGraph.containsVertex(start) && stringGraph.containsVertex(end)){
//            
//            Set<DefaultEdge> tempRetorno = stringGraph.edgesOf(start);
//            Queue<DefaultEdge> vizinhos = new LinkedList<>();
//            vizinhos.addAll(tempRetorno);
//            List<String> visitados = new ArrayList<>();
//            visitados.add(start);
//            DefaultEdge temp = null;
//            while (!vizinhos.isEmpty()){
//                if(!visitados.contains(vizinhos.peek())){
//                    temp = vizinhos.poll();
//                    System.out.println(temp);
//                }
//                visitados.add(stringGraph.getEdgeSource(temp));
//                if(stringGraph.getEdgeTarget(temp).equals(end)){
//                   //Caminho;
//                    return "Show!";
//                }
//                else{
//                    vizinhos.addAll(stringGraph.edgesOf(stringGraph.getEdgeTarget(temp)));
//                }
//            }
//        }
        return null;
    }
    
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
}
