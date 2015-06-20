/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaia;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Set;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;

public class GraphCreation {

    /**
     * Retorna um Grafo preenchido com todos os nós e suas arestas
     *
     * @return
     * @throws FileNotFoundException
     */
    public static SimpleDirectedWeightedGraph<Vertex, DefaultWeightedEdge> createGraph() throws FileNotFoundException {
        //cria um objeto da classe FileReader
        FileReader f = new FileReader();
        //recebe o conjunto de nós com as informações preenchidas
        Set<Vertex> nos = f.reader();
        SimpleDirectedWeightedGraph<Vertex, DefaultWeightedEdge> graph = new SimpleDirectedWeightedGraph<>(DefaultWeightedEdge.class);
        //itera sobre o conjunto de nós para adiciona-los no grafo 
        for (Vertex noAtual : nos) {
            //adiciona o nó atual no grafo se ele nao existir
            if (!graph.containsVertex(noAtual)) {
                graph.addVertex(noAtual);
            }
            //remove o nó atual do conjunto
            nos.remove(noAtual);
            //caso o conjunto de nós não esteja vazio
            if (!nos.isEmpty()) {
                //percorre novamente o conjunto para adicionar as arestas
                for (Vertex no : nos) {
                    //Percorre o conjunto
                    for (Referencia ref : no.getReferencias()) {
                        //caso o id do nó atual seja igual ao id de algum outro nó do conjunto
                        if (noAtual.getReferencias().contains(ref)) {
                            //Se esse no nao existir no grafo ele é adicionado
                            if (!graph.containsVertex(no)) {
                                graph.addVertex(no);
                            }
                            //Adiciona a aresta
                            graph.addEdge(no, noAtual);
                        }
                    }
                }
            }
        }
        //retorna o grafo preenchido com nós e arestas
        return graph;
    }
}
