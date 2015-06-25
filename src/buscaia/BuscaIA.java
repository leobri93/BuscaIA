/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaia;

import java.io.FileNotFoundException;
import java.io.IOException;




public class BuscaIA {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    //Primeiro trabalho de IA: Desenvolver três métodos de busca entre dois pontos//
    public static void main(String[] args) throws IOException {
        BuscaGulosa bl = new BuscaGulosa();
        System.out.println(bl.BuscaGulosa("Rua das Margaridas", "Rua dos Cravos"));
//        for(String atual: bl.BuscaGulosa("Rua das Margaridas", "Rua dos Cravos")){
//            System.out.println(atual);
//        }
        
    }
    
}
