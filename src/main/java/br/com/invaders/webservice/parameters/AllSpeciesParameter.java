package br.com.invaders.webservice.parameters;

public class AllSpeciesParameter extends Parameter{

    private int pageSize;

    public AllSpeciesParameter(int species_type, int pageSize) {
        super(species_type);
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return super.toString()+"&pageSize=" + pageSize;
    }
}
