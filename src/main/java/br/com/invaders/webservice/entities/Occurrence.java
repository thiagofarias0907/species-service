package br.com.invaders.webservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "occurrence")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Occurrence {

    @ManyToOne()
    @JoinColumn(name="scientific_name", referencedColumnName = "scientific_name",nullable=false,unique=false)
    Specie specie;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(name = "scientific_name")
//    private String scientificName;
    private String latitude;
    private String longitude;

    @Column(name = "latitude_decimal")
    private String latitudeDecimal;
    @Column(name = "longitude_decimal")
    private String longitudeDecimal;
    private String location;
    @Column(name = "protected_area")
    private String protectedArea;
    private String municipio;
    private String state;

    public Occurrence() {
    }

//    public String getScientificName() {
//        return scientificName;
//    }

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

    public String getLocation() {
        return location;
    }

    public String getProtectedArea() {
        return protectedArea;
    }

    public String getMunicipio() {
        return municipio;
    }

    public String getState() {
        return state;
    }

    @Override
    public String toString() {
        return "Occurrence{" +
                "id=" + id +
//                ", scientificName='" + scientificName + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitudeDecimal='" + latitudeDecimal + '\'' +
                ", longitudeDecimal='" + longitudeDecimal + '\'' +
                ", location='" + location + '\'' +
                ", protectedArea='" + protectedArea + '\'' +
                ", municipio='" + municipio + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

    public Specie getSpecie() {
        return specie;
    }

    public void setSpecie(Specie specie) {
        this.specie = specie;
    }
}
