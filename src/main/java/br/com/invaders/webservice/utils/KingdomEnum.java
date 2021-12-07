package br.com.invaders.webservice.utils;

public enum KingdomEnum {

    Animalia("Animalia",1),
    Monera  ("Monera",2),
    Plantae ("Plantae",3),
    Protista("Protista",4);


    private int id;
    private String kingdom;


    KingdomEnum(String kingdom,int id) {
        this.id = id;
        this.kingdom = kingdom;
    }

    public int getId() {
        return id;
    }
}
