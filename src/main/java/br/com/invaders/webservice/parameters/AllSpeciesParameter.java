package br.com.invaders.webservice.parameters;

public class AllSpeciesParameter {

    private int speciesType;
    private int pageSize;

    public AllSpeciesParameter(int species_type, int pageSize) {
        this.speciesType = species_type;
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        if (speciesType > 0)
            return "?speciesType=" + speciesType +"&pageSize=" + pageSize;
        return "?speciesType=&pageSize=" + pageSize;

    }
}
