package br.com.invaders.webservice.parameters;

public abstract class Parameter {

    private int speciesType;
    private int pageSize;

    public Parameter(int species_type) {
        this.speciesType = species_type;
    }

    @Override
    public String toString() {
        if (speciesType > 0)
            return "?species_type=" + speciesType;
        return "?species_type=";

    }



}
