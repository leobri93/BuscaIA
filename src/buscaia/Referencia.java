/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaia;

public class Referencia {
    private double latitude;
    private double longitude;
    private long id;

    public Referencia(long id, double latitude, double longitude) {
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
