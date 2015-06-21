/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class FileReader {

    public Set<Vertex> reader() throws IOException {
        Set<Vertex> nos = new HashSet();
        File arq = new File("C:\\Users\\Leonardo\\Downloads\\map.osm");
        String sPath = arq.getPath().replace(".", "(2).");
        Path path = Paths.get(sPath);
        Files.copy(arq.toPath(), path, REPLACE_EXISTING);
        try (Scanner scan = new Scanner(arq)) {
            //Padrao para comecar a ler uma rua
            Pattern openWay = Pattern.compile("([w][a][y][ ][i][d][=].\\d+)");
            //Padrao para encerrar a leitura de uma rua
            Pattern closeWay = Pattern.compile("([/][w][a][y])");
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
                    String nomeDaRua = nomeRua(openW, sPath);
                    Vertex atual = new Vertex();
                    //Adiciona o nome da rua ao vertice
                    atual.setName(nomeDaRua);
                    //Enquanto nao encerrar a leitura da rua
                    String closeW = scan.findInLine(closeWay);
                    // closeW.equals("\\way")
                    while (closeW == null ) {
                        closeW = scan.findInLine(closeWay);
                        //Procura por um ref
                        String refString = scan.findInLine(ref);
                        //Se encontrar
                        if (refString != null) {
                            //Trata a string para pegar o ID
                            refString = refString.replace("ref=\"", "");
                            //Adiciona a latitude a longitude a um vertice
                            latLongReturn(refString, atual, sPath);
                        }
                        scan.nextLine();
                    }
                    //Adiciona na colecao
                    nos.add(atual);
                }
                scan.nextLine();
            }
        }catch(IOException ex){
            Logger.getLogger(FileReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nos;
    }

    /**
     * Seta a latitude e longitude do ID no vertice.
     *
     * @param refString
     * @param atual
     */
    private void latLongReturn(String refString, Vertex atual, String path) {
        File arq = new File(path);
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
                        if (latitude != null && longitude != null && refString != null) {
                            //Seta a latitude, longitude e ID
                            atual.add(Long.parseLong(refString), Double.parseDouble(latitude), Double.parseDouble(longitude));
                            return;
                        }
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
     *
     * @param openW
     * @return
     */
    private String nomeRua(String openW, String path) {
        File arq = new File(path);
        try (Scanner scanner = new Scanner(arq)) {
            //Cria os padroes para inicio da leitura da rua e para o nome da rua
            Pattern openWay = Pattern.compile("([w][a][y][ ][i][d][=].\\d+)");
            Pattern nomeDaRua = Pattern.compile("([n][a][m][e][\"][ ][v][=].+[A-Za-z])");

            while (scanner.hasNextLine()) {
                //Busca por leitura da rua
                String idAtual = scanner.findInLine(openWay);

                if (idAtual != null) {
                    //Trata a string da rua
                    idAtual = idAtual.replace("way id=\"", "");

                    //Se o ID da rua lida for igual ao ID passado por parametro
                    if (idAtual.equals(openW)) {
                        while (scanner.hasNextLine()) {
                            //Procura pelo padrao do nome da rua
                            String rua = scanner.findInLine(nomeDaRua);
                            if (rua != null) {
                                //Trata nome da rua
                                rua = rua.replace("name\" v=\"", "");
                                return rua;
                            }
                            scanner.nextLine();
                        }

                    }

                }
                scanner.nextLine();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
