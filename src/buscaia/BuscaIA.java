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
        BuscaLargura bl = new BuscaLargura();
        for(String atual: bl.BuscaEmLargura("Rua Matias Sandri", "Rua dos Cravos")){
            System.out.println(atual);
        }
        
    }
    
}
