/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaia;

public class Vertex {

    private String name;
    private int peso;
    private Vertex pai;
    private double latitude;
    private double longitude;
    private int id;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Vertex() {
    }

    public Vertex(String name, int peso, Vertex pai) {
        this.name = name;
        this.peso = peso;
        this.pai = pai;
    }

    public Vertex(String name, double latitude, double longitude, int id) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.id = id;
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
