package br.com.invaders.webservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Statistics {
    @Id
    private long species_id;
    private String scientific_name;
    private long kingdom_id;
    private String kingdom;
    private String family;
    private long total_especie;
    private long total_reino;
    private long total_familia;
    private long Acre;
    private long Alagoas;
    private long Amapá;
    private long Amazonas;
    private long Bahia;
    private long Ceara;
    private long Distrito_Federal;
    private long Espírito_Santo;
    private long Goiás;
    private long Maranhão;
    private long Mato_Grosso;
    private long Mato_Grosso_do_Sul;
    private long Minas_Gerais;
    private long Pará;
    private long Paraíba;
    private long Paraná;
    private long Pernambuco;
    private long Piauí;
    private long Rio_de_Janeiro;
    private long Rio_Grande_do_Norte;
    private long Rio_Grande_do_Sul;
    private long Rondônia;
    private long Roraima;
    private long Santa_Catarina;
    private long São_Paulo;
    private long Sergipe;
    private long Tocantins;

    public Statistics() {
    }

    @Override
    public String toString() {
        return "{" +
                "  \"species_id\":" + species_id +
                ", \"scientific_name\":\"" + scientific_name + "\""+
                ", \"kingdom_id\":" + kingdom_id +
                ", \"kingdom\":\"" + kingdom +  "\""+
                ", \"family\":\"" + family +  "\""+
                ", \"total_especie\":" + total_especie +
                ", \"total_reino\":" + total_reino +
                ", \"total_familia\":" + total_familia +
                ", \"Acre\":\"" + Acre +  "\""+
                ", \"Alagoas\":\"" + Alagoas +  "\""+
                ", \"Amapá\":\"" + Amapá +  "\""+
                ", \"Amazonas\":\"" + Amazonas +  "\""+
                ", \"Bahia\":\"" + Bahia +  "\""+
                ", \"Ceara\":\"" + Ceara +  "\""+
                ", \"Distrito_Federal\":\"" + Distrito_Federal +  "\""+
                ", \"Espírito_Santo\":\"" + Espírito_Santo +  "\""+
                ", \"Goiás\":\"" + Goiás +  "\""+
                ", \"Maranhão\":\"" + Maranhão +  "\""+
                ", \"Mato_Grosso\":\"" + Mato_Grosso +  "\""+
                ", \"Mato_Grosso_do_Sul\":\"" + Mato_Grosso_do_Sul +  "\""+
                ", \"Minas_Gerais\":\"" + Minas_Gerais +  "\""+
                ", \"Pará\":\"" + Pará +  "\""+
                ", \"Paraíba\":\"" + Paraíba +  "\""+
                ", \"Paraná\":\"" + Paraná +  "\""+
                ", \"Pernambuco\":\"" + Pernambuco +  "\""+
                ", \"Piauí\":\"" + Piauí +  "\""+
                ", \"Rio_de_Janeiro\":\"" + Rio_de_Janeiro +  "\""+
                ", \"Rio_Grande_do_Norte\":\"" + Rio_Grande_do_Norte +  "\""+
                ", \"Rio_Grande_do_Sul\":\"" + Rio_Grande_do_Sul +  "\""+
                ", \"Rondônia\":\"" + Rondônia +  "\""+
                ", \"Roraima\":\"" + Roraima +  "\""+
                ", \"Santa_Catarina\":\"" + Santa_Catarina +  "\""+
                ", \"São_Paulo\":\"" + São_Paulo +  "\""+
                ", \"Sergipe\":\"" + Sergipe +  "\""+
                ", \"Tocantins\":\"" + Tocantins +  "\""+
                '}';
    }

    public long getSpecies_id() {
        return species_id;
    }

    public String getScientific_name() {
        return scientific_name;
    }

    public long getKingdom_id() {
        return kingdom_id;
    }

    public String getKingdom() {
        return kingdom;
    }

    public String getFamily() {
        return family;
    }

    public long getTotal_especie() {
        return total_especie;
    }

    public long getTotal_reino() {
        return total_reino;
    }

    public long getTotal_familia() {
        return total_familia;
    }

    public long getAcre() {
        return Acre;
    }

    public long getAlagoas() {
        return Alagoas;
    }

    public long getAmapá() {
        return Amapá;
    }

    public long getAmazonas() {
        return Amazonas;
    }

    public long getBahia() {
        return Bahia;
    }

    public long getCeara() {
        return Ceara;
    }

    public long getDistrito_Federal() {
        return Distrito_Federal;
    }

    public long getEspírito_Santo() {
        return Espírito_Santo;
    }

    public long getGoiás() {
        return Goiás;
    }

    public long getMaranhão() {
        return Maranhão;
    }

    public long getMato_Grosso() {
        return Mato_Grosso;
    }

    public long getMato_Grosso_do_Sul() {
        return Mato_Grosso_do_Sul;
    }

    public long getMinas_Gerais() {
        return Minas_Gerais;
    }

    public long getPará() {
        return Pará;
    }

    public long getParaíba() {
        return Paraíba;
    }

    public long getParaná() {
        return Paraná;
    }

    public long getPernambuco() {
        return Pernambuco;
    }

    public long getPiauí() {
        return Piauí;
    }

    public long getRio_de_Janeiro() {
        return Rio_de_Janeiro;
    }

    public long getRio_Grande_do_Norte() {
        return Rio_Grande_do_Norte;
    }

    public long getRio_Grande_do_Sul() {
        return Rio_Grande_do_Sul;
    }

    public long getRondônia() {
        return Rondônia;
    }

    public long getRoraima() {
        return Roraima;
    }

    public long getSanta_Catarina() {
        return Santa_Catarina;
    }

    public long getSão_Paulo() {
        return São_Paulo;
    }

    public long getSergipe() {
        return Sergipe;
    }

    public long getTocantins() {
        return Tocantins;
    }
}
