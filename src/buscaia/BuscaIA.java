/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaia;

import java.util.Arrays;


public class BuscaIA {

    /**
     * @param args the command line arguments
     */
    //Primeiro trabalho de IA: Desenvolver três métodos de busca entre dois pontos//
    public static void main(String[] args) {
        BuscaLargura bl = new BuscaLargura();
        System.out.println(bl.BuscaEmLargura("Itaipu", "Centro"));
    }
    
}
