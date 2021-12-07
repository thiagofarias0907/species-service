package br.com.invaders.webservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "kingdom")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Kingdom {

    @Id
    @Column(name = "kingdom_id")
    private Long id;
    private String kingdom;

    public Kingdom() {
    }

    public Long getId() {
        return id;
    }

    public String getKingdom() {
        return kingdom;
    }
}
