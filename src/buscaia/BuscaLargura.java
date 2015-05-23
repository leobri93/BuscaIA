/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaia;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import javax.swing.tree.TreeNode;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.UndirectedGraph;
import org.jgrapht.graph.SimpleGraph;

/**
 *
 * @author Leonardo
 */
public class BuscaLargura {

    UndirectedGraph<String, DefaultEdge> stringGraph = createStringGraph();
    
    public String BuscaEmLargura (String start, String end){
        if(stringGraph.containsVertex(start) && stringGraph.containsVertex(end)){
            
            Set<DefaultEdge> tempRetorno = stringGraph.edgesOf(start);
            Queue<DefaultEdge> vizinhos = new LinkedList<>();
            vizinhos.addAll(tempRetorno);
            List<String> visitados = new ArrayList<>();
            visitados.add(start);
            DefaultEdge temp = null;
            while (!vizinhos.isEmpty()){
                if(!visitados.contains(vizinhos.peek())){
                    temp = vizinhos.poll();
                    System.out.println(temp);
                }
                visitados.add(stringGraph.getEdgeSource(temp));
                if(stringGraph.getEdgeTarget(temp).equals(end)){
                   //Caminho;
                    return "Show!";
                }
                else{
                    vizinhos.addAll(stringGraph.edgesOf(stringGraph.getEdgeTarget(temp)));
                }
            }
        }
        return null;
    }
    
    public Set<DefaultEdge> retornaOrigem(String origem){
        Object[] teste2 = stringGraph.edgeSet().toArray();
        System.out.println(teste2[0].toString());
        System.out.println(teste2[1].toString());
        System.out.println(teste2[2].toString());
        System.out.println(teste2[3].toString());
        Set<DefaultEdge> teste = stringGraph.edgeSet();
        Set<DefaultEdge> retorno = null;
        for(DefaultEdge atual:teste){
            if(stringGraph.getEdgeSource(atual).equals(origem)){
                retorno.add(atual);
            }
        }
        return retorno;
    }
    
    

    private static UndirectedGraph<String, DefaultEdge> createStringGraph() {
        UndirectedGraph<String, DefaultEdge> g
                = new SimpleGraph<String, DefaultEdge>(DefaultEdge.class);
        
        String Itaipu = "Itaipu";
        String Sao_Francisco = "Sao Francisco";
        String Icarai = "Icarai";
        String Centro = "Centro";
        String Charitas = "Charitas";

        // add the vertices
        g.addVertex(Itaipu);
        g.addVertex(Sao_Francisco);
        g.addVertex(Icarai);
        g.addVertex(Centro);
        g.addVertex(Charitas);

        // add edges to create a circuit
        g.addEdge(Itaipu, Sao_Francisco);
        g.addEdge(Sao_Francisco, Icarai);
        g.addEdge(Sao_Francisco, Charitas);
        g.addEdge(Icarai, Centro);

        return g;
    }
}
