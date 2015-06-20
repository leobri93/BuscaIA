/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaia;

import java.util.LinkedList;

public class Vertex {

    private String nomeDaRuda;
    private int peso;
    private Vertex pai;
    private LinkedList<Referencia> referencias;

    public LinkedList<Referencia> getReferencias() {
        return referencias;
    }

    public Vertex() {
    }

    public Vertex(String name, int peso, Vertex pai) {
        this.nomeDaRuda = name;
        this.peso = peso;
        this.pai = pai;
        this.referencias = null;
    }

    public void add(int id , double latitude, double longitude) {
        Referencia ref = new Referencia(id, latitude, longitude);
        referencias.add(ref);
    }

    public Vertex(String name, int peso) {
        this.nomeDaRuda = name;
        this.peso = peso;
    }

    public String getName() {
        return nomeDaRuda;
    }

    public void setName(String name) {
        this.nomeDaRuda = name;
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
