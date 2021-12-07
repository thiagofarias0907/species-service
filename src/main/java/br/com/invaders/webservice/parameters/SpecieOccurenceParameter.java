package br.com.invaders.webservice.parameters;

public class SpecieOccurenceParameter  extends  Parameter{

    private int[] species_id_array;

    public SpecieOccurenceParameter(int[] species_id_array, int species_type) {
        super(species_type);
        this.species_id_array = species_id_array;
    }

    @Override
    public String toString() {
        return super.toString()+"&species_id_array=" + species_id_array.toString().substring(1,species_id_array.length-1);
    }
}
