/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaia;

/**
 *
 * @author thais_maiolino
 */
public class Referencia {
    private double latitude;
    private double longitude;
    private int id;

    public Referencia(int id, double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.id = id;
    }    

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
