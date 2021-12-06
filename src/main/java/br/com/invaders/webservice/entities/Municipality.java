package br.com.invaders.webservice.entities;

import javax.persistence.Column;
import javax.persistence.Id;

public class Municipality {


    @Id
    @Column(name = "municipio_id")
    private int id;
    @Column(name = "municipio")
    private String municipality;
    @Column(name = "state_id")
    private int stateId;
    private String uf;

    public Municipality() {
    }

    public int getId() {
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
