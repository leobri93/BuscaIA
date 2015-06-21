/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaia;

import java.util.LinkedList;

public class Vertex {

    private String nomeDaRua;
    private int peso;
    private Vertex pai;
    private final LinkedList<Referencia> referencias = new LinkedList<>();

    public LinkedList<Referencia> getReferencias() {
        return referencias;
    }

    public Vertex() {
    }

    public Vertex(String name, int peso, Vertex pai) {
        this.nomeDaRua = name;
        this.peso = peso;
        this.pai = pai;
        
    }

    public Vertex(String name, int peso) {
        this.nomeDaRua = name;
        this.peso = peso;
    }
    
    public void add(long id , double latitude, double longitude) {
        Referencia ref = new Referencia(id, latitude, longitude);
        referencias.add(ref);
    }

    public String getName() {
        return nomeDaRua;
    }

    public void setName(String name) {
        this.nomeDaRua = name;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public Vertex getPai() {
        return pai;
    }

    public void setPai(Vertex pai) {
        this.pai = pai;
    }

}
