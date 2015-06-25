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
import org.jgrapht.UndirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleGraph;
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
     //Criar um metodo que Graph creation
    private  SimpleWeightedGraph<Vertex, DefaultEdge> createStringGraph() {
        SimpleWeightedGraph<Vertex, DefaultEdge> g = new SimpleWeightedGraph<Vertex, DefaultEdge>(DefaultEdge.class);
        
        
        Vertex avbeiramar = new Vertex("Avenida Beira Mar",Math.random()*100);
        String rosas = "Rua das Rosas";
        String camelias = "Rua das Camelias";
        String cravos = "Rua dos Cravos";
        String margaridas = "Rua das Margaridas";
        String ipes = "Rua dos Ipes";
        String violetas = "Rua das Violetas";
        String hortencias = "Rua das Hortencias";
        String geranios = "Rua das Geranios";
        String tulipas = "Rua das Tulipas";
        String matiasSandri = "Rua das Matias Sandri";
        String papoulas = "Rua das Papolas";
        String acacias = "Rua das Acacias";
        String jasmins = "Rua dos Jamins";
        String magnolias = "Rua das Magnolias";
        String lirios = "Rua dos Lirios";
        String begonias = "Rua das Begonias";
        String orquideas = "Rua das Orquideas";
        String perpetuas = "Rua das Perpetuas";
        String petuinas = "Rua das Petuinas";
        String manacas = "Rua dos Manacas";
        
        // add the vertices
        
        g.addVertex(avbeiramar);
        g.addVertex(rosas);
        g.addVertex(camelias);
        g.addVertex(cravos);
        g.addVertex(margaridas);
        g.addVertex(ipes);
        g.addVertex(violetas);
        g.addVertex(hortencias);
        g.addVertex(geranios);
        g.addVertex(tulipas);
        g.addVertex(matiasSandri);
        g.addVertex(begonias);
        g.addVertex(lirios);
        g.addVertex(magnolias);
        g.addVertex(jasmins);
        g.addVertex(acacias);
        g.addVertex(papoulas);
        g.addVertex(perpetuas);
         g.addVertex(petuinas);
        g.addVertex(manacas);

        // add edges to create a circuit
        g.addEdge(avbeiramar, orquideas);
        g.addEdge(avbeiramar, matiasSandri);
        g.addEdge(avbeiramar, papoulas);
        g.addEdge(orquideas,avbeiramar);
        g.addEdge(perpetuas,avbeiramar);
        g.addEdge(avbeiramar, perpetuas);
        g.addEdge(matiasSandri,avbeiramar);
        g.addEdge(papoulas,avbeiramar);
        g.addEdge(orquideas, rosas);
        g.addEdge(orquideas, camelias);
        g.addEdge(orquideas, ipes);
        g.addEdge(orquideas, violetas);
        g.addEdge(orquideas, margaridas);
        g.addEdge(orquideas, hortencias);
        g.addEdge(orquideas, begonias);
        g.addEdge(rosas, orquideas);
        g.addEdge(camelias,orquideas);
        g.addEdge(ipes,orquideas);
        g.addEdge(violetas,orquideas);
        g.addEdge(margaridas,orquideas);
        g.addEdge(hortencias,orquideas);
        g.addEdge(begonias,orquideas);
        g.addEdge(begonias, hortencias);
        g.addEdge(hortencias, begonias);
        g.addEdge(hortencias, matiasSandri);
        g.addEdge(matiasSandri, hortencias);
        g.addEdge(rosas, matiasSandri);
        g.addEdge(rosas, jasmins);
        g.addEdge(rosas, acacias);
        g.addEdge(rosas, papoulas);
        g.addEdge(rosas,perpetuas);
        g.addEdge(perpetuas,rosas);
        g.addEdge(jasmins, rosas);
        g.addEdge(matiasSandri, rosas);
        g.addEdge(papoulas, rosas);
        g.addEdge(acacias, rosas);
        g.addEdge(camelias, cravos);
        g.addEdge(cravos, camelias);
        g.addEdge(perpetuas,camelias);
        g.addEdge(camelias,perpetuas);
        g.addEdge(perpetuas,cravos);
        g.addEdge(cravos,perpetuas);
        g.addEdge(perpetuas,margaridas);
        g.addEdge(margaridas,perpetuas);
        g.addEdge(perpetuas,ipes);
        g.addEdge(ipes,perpetuas);
        g.addEdge(cravos,matiasSandri);
        g.addEdge(matiasSandri,cravos);
        g.addEdge(camelias,matiasSandri);
        g.addEdge(matiasSandri,camelias);
        g.addEdge(margaridas,matiasSandri);
        g.addEdge(matiasSandri,margaridas);
        g.addEdge(ipes,matiasSandri);
        g.addEdge(matiasSandri,ipes);
        g.addEdge(violetas,matiasSandri);
        g.addEdge(matiasSandri,violetas);
        g.addEdge(magnolias, cravos);
        g.addEdge(cravos, magnolias);
        g.addEdge(camelias, magnolias);
        g.addEdge(magnolias, camelias);
        g.addEdge(margaridas, magnolias);
        g.addEdge(magnolias, margaridas);
        g.addEdge(petuinas, cravos);
        g.addEdge(cravos, petuinas);
        g.addEdge(petuinas, camelias);
        g.addEdge(camelias, petuinas);
        g.addEdge(margaridas, manacas);
        g.addEdge(manacas, margaridas);
        g.addEdge(magnolias, ipes);
        g.addEdge(ipes, magnolias);
        g.addEdge(ipes, manacas);
        g.addEdge(manacas, ipes);
        g.addEdge(geranios,matiasSandri);
        g.addEdge(matiasSandri,geranios);
        g.addEdge(lirios,ipes);
        g.addEdge(ipes,lirios);
        g.addEdge(violetas,lirios);
        g.addEdge(lirios,violetas);
        g.addEdge(tulipas,matiasSandri);
        g.addEdge(matiasSandri,tulipas);
        g.addEdge(lirios,matiasSandri);
        g.addEdge(matiasSandri,lirios);
        
        return g;
    }   
}
