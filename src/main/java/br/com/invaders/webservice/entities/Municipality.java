package br.com.invaders.webservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "municipality")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Municipality {


    @Id
    @Column(name = "municipio_id")
    private Long id;
    @Column(name = "municipio")
    private String municipality;
    @Column(name = "state_id")
    private int stateId;
    private String uf;

    public Municipality() {
    }

    public Long getId() {
        return id;
    }

    public String getMunicipality() {
        return municipality;
    }

    public int getStateId() {
        return stateId;
    }

    public String getUf() {
        return uf;
    }
}
