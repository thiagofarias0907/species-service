package br.com.invaders.webservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "state")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class State {

    //state_id
    @Id
    @Column(name = "state_id")
    private int id;
    private String state;
    private String uf;

    public State() {
    }

    public State(int id, String state, String uf) {
        this.id = id;
        this.state = state;
        this.uf = uf;
    }

    public int getId() {
        return id;
    }

    public String getState() {
        return state;
    }

    public String getUf() {
        return uf;
    }
}
