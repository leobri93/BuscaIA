/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaia;

public class Vertex {
    String name;
    int peso;
    Vertex pai;

    public Vertex(String name, int peso, Vertex pai) {
        this.name = name;
        this.peso = peso;
        this.pai = pai;
    }

    public Vertex() {
    }

    public Vertex(String name, int peso) {
        this.name = name;
        this.peso = peso;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
