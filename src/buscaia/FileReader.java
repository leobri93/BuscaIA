/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaia;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class FileReader {

    public Set<Vertex> reader() throws FileNotFoundException {
        Set<Vertex> nos = new HashSet();
        File arq = new File("C:\\Users\\Leonardo\\Downloads\\map(1).osm");
        try (Scanner scan = new Scanner(arq)) {
            //Padrao para comecar a ler uma rua
            Pattern openWay = Pattern.compile("([w][a][y][ ][i][d][=].\\d+)");
            //Padrao para encerrar a leitura de uma rua
            Pattern closeWay = Pattern.compile("(\\[w][a][y])");
            //Padrao para leitura de um ref
            Pattern ref = Pattern.compile("([r][e][f][=].\\d+)");
            //Ler o arquivo
            while (scan.hasNextLine()) {
                //Encontra uma rua
                String openW = scan.findInLine(openWay);
                if (openW != null) {
                    //Tratamento para pegar o ID da rua
                    openW = openW.replace("way id=\"", "");
                    //Pega o nome da Rua
                    String nomeDaRua = nomeRua(openW);

                    //Enquanto nao encerrar a leitura da rua
                    while (!scan.findInLine(closeWay).equals("\\way")) {
                        //Procura por um ref
                        String refString = scan.findInLine(ref);
                        //Se encontrar
                        if (refString != null) {
                            //Trata a string para pegar o ID
                            refString = refString.replace("ref=\"", "");
                            Vertex atual = new Vertex();
                            //Adiciona o ID ao vertice
                            atual.setId(Integer.parseInt(refString));
                            //Adiciona a latitude a longitude a um vertice
                            latLongReturn(refString, atual);
                            //Adiciona o nome da rua ao vertice
                            atual.setName(nomeDaRua);
                            //Adiciona na colecao
                            nos.add(atual);
                        }
                        scan.nextLine();
                    }

                }
                scan.nextLine();
            }
        }
        return nos;
    }

    /**
     * Seta a latitude e longitude do ID no vertice. 
     * @param refString
     * @param atual 
     */
    private void latLongReturn(String refString, Vertex atual) {
        File arq = new File("C:\\Users\\Leonardo\\Downloads\\map(1).osm");
        try (Scanner scan = new Scanner(arq)) {
            
            //Padrao de reconhecimento de latitude e longitude
            Pattern lat = Pattern.compile("([l][a][t][=][\"][-]?(?:\\d*\\.)?\\d+)");
            Pattern lon = Pattern.compile("([l][o][n][=][\"][-]?(?:\\d*\\.)?\\d+)");
            
            //Percorre o arquivo
            while (scan.hasNextLine()) {
                //Pega o iD da linha atual
                String idAtual = scan.findInLine(Pattern.compile("([ ][i][d][=].\\d+)"));
                
                if (idAtual != null) {
                    //Trata o string para pegar somente o ID
                    idAtual = idAtual.replace(" id=\"", "");
                    //Se ID atual for igual ao passado como parametro
                    if (idAtual.equals(refString)) {
                        
                        //Pega a latitude e longitude
                        String latitude = scan.findInLine(lat);
                        String longitude = scan.findInLine(lon);
                        
                        //Trata os strings para pegar somente as coordenadas
                        latitude = latitude.replace("lat=\"", "");
                        longitude = longitude.replace("lon=\"", "");
                        
                        //Seta a latitude e longitude 
                        atual.setLatitude(Integer.parseInt(latitude));
                        atual.setLongitude(Integer.parseInt(longitude));
                        break;
                    }
                }
                scan.nextLine();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Função que retorna o nome da rua referente ao ID passado por parametro
     * @param openW
     * @return 
     */
    private String nomeRua(String openW) {
        File arq = new File("C:\\Users\\Leonardo\\Downloads\\map(1).osm");
        try (Scanner scan = new Scanner(arq)) {
            //Cria os padroes para inicio da leitura da rua e para o nome da rua
            Pattern openWay = Pattern.compile("([w][a][y][ ][i][d][=].\\d+)");
            Pattern nomeDaRua = Pattern.compile("([n][a][m][e][\"][ ][v][=].+[A-Za-z])");
            
            while (scan.hasNextLine()) {
                //Busca por leitura da rua
                String idAtual = scan.findInLine(openWay);

                if (idAtual != null) {
                    //Trata a string da rua
                    idAtual = idAtual.replace("way id=\"", "");
                    
                    //Se o ID da rua lida for igual ao ID passado por parametro
                    if (idAtual.equals(openW)) {
                        while (scan.hasNextLine()) {
                            //Procura pelo padrao do nome da rua
                            String rua = scan.findInLine(nomeDaRua);
                            if (rua != null) {
                                //Trata nome da rua
                                rua = rua.replace("name\" v=\"", "");
                                return rua;
                            }
                            scan.nextLine();
                        }

                    }
                    scan.nextLine();
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
