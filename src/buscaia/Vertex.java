/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaia;

import java.util.LinkedList;

public class Vertex {

    private String nomeDaRua;
    private double heuristica;
    private Vertex pai;
    private final LinkedList<Referencia> referencias = new LinkedList<>();

    public LinkedList<Referencia> getReferencias() {
        return referencias;
    }

    public Vertex() {
    }

    public Vertex(String name, double heuristica, Vertex pai) {
        this.nomeDaRua = name;
        this.heuristica = heuristica;
        this.pai = pai;

    }

    public Vertex(String name, double heuristica) {
        this.nomeDaRua = name;
        this.heuristica = heuristica;
    }

    public void add(long id, double latitude, double longitude) {
        Referencia ref = new Referencia(id, latitude, longitude);
        referencias.add(ref);
    }

    public String getName() {
        return nomeDaRua;
    }

    public void setName(String name) {
        this.nomeDaRua = name;
    }

    public double getHeuristica() {
        return heuristica;
    }

    public void setHeuristica(double heuristica) {
        this.heuristica = heuristica;
    }

    public Vertex getPai() {
        return pai;
    }

    public void setPai(Vertex pai) {
        this.pai = pai;
    }

    public double getLatitudeCentral() {
        return getReferenciaCentral().getLatitude();
    }

    public double getLongitudeCentral() {
        return getReferenciaCentral().getLongitude();
    }

    public Referencia getReferenciaCentral() {
        int count = referencias.size();
        return referencias.get((int) (count / 2));
    }

}
