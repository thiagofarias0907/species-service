package br.com.invaders.webservice.entities;

import javax.persistence.Column;
import javax.persistence.Id;

public class Kingdom {

    @Id
    @Column(name = "kingdom_id")
    private int id;
    private String kingdom;

    public Kingdom() {
    }

    public int getId() {
        return id;
    }

    public String getKingdom() {
        return kingdom;
    }
}
