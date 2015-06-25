/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaia;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;


public class GraphCreation {

    /**
     * Retorna um Grafo preenchido com todos os nós e suas arestas
     *
     * @return
     * @throws FileNotFoundException
     */
    public static SimpleWeightedGraph<Vertex, DefaultWeightedEdge> createGraph() throws IOException {
        //cria um objeto da classe FileReader
        FileReader f = new FileReader();
        //recebe o conjunto de nós com as informações preenchidas
        List<Vertex> nos = f.reader();
        SimpleWeightedGraph<Vertex, DefaultWeightedEdge> graph = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
        
        List<Vertex> copia = new LinkedList<>();
        List<Referencia> tempList = new LinkedList<>();
        
        copia.addAll(nos);
        for (Vertex temp : nos) {
            try {
                copia.add((Vertex) temp.clone());
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(GraphCreation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        //itera sobre o conjunto de nós para adiciona-los no grafo 
        for (Vertex noAtual : copia) {
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
                    tempList.addAll(no.getReferencias());
                    for (Referencia ref : tempList) {
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
                    tempList.removeAll(tempList);
                }
            }
        }
        //retorna o grafo preenchido com nós e arestas
        return graph;
    }
}