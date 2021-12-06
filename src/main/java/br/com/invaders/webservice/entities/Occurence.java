package br.com.invaders.webservice.entities;

import javax.persistence.Column;
import javax.persistence.Id;

public class Occurence {


//    @Id
//    private int id;

    @Column(name = "scientific_name")
    private Specie scientificName;
    private String latitude;
    private String longitude;

    @Column(name = "latitude_decimal")
    private String latitudeDecimal;
    @Column(name = "longitude_decimal")
    private String longitudeDecimal;
    private String datum;
    private String zone;
    private String band;
//    private String coord_unit;
//    private String coord_utm_x;
//    private String coord_utm_y;
//    private String data_source;
    private String location;
    @Column(name = "")
    private String protected_area;
//    private Municipality municipio;
//    private State state;
    private String municipio;
    private String state;

    public Occurence() {
    }

    public Specie getScientificName() {
        return scientificName;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getLatitudeDecimal() {
        return latitudeDecimal;
    }

    public String getLongitudeDecimal() {
        return longitudeDecimal;
    }

    public String getDatum() {
        return datum;
    }

    public String getZone() {
        return zone;
    }

    public String getBand() {
        return band;
    }

    public String getLocation() {
        return location;
    }

    public String getProtected_area() {
        return protected_area;
    }

    public String getMunicipio() {
        return municipio;
    }

    public String getState() {
        return state;
    }
}
