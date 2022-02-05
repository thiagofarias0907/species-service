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
    private long acre;
    private long alagoas;
    private long amapa;
    private long amazonas;
    private long bahia;
    private long ceara;
    private long distrito_Federal;
    private long espirito_Santo;
    private long goias;
    private long maranhao;
    private long mato_Grosso;
    private long mato_Grosso_do_Sul;
    private long minas_Gerais;
    private long para;
    private long paraiba;
    private long parana;
    private long pernambuco;
    private long piaui;
    private long rio_de_Janeiro;
    private long rio_Grande_do_Norte;
    private long rio_Grande_do_Sul;
    private long rondonia;
    private long roraima;
    private long santa_Catarina;
    private long sao_Paulo;
    private long sergipe;
    private long tocantins;

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
                ", \"acre\":\"" + acre +  "\""+
                ", \"alagoas\":\"" + alagoas +  "\""+
                ", \"amapa\":\"" + amapa +  "\""+
                ", \"amazonas\":\"" + amazonas +  "\""+
                ", \"bahia\":\"" + bahia +  "\""+
                ", \"ceara\":\"" + ceara +  "\""+
                ", \"distrito_Federal\":\"" + distrito_Federal +  "\""+
                ", \"espirito_Santo\":\"" + espirito_Santo +  "\""+
                ", \"goias\":\"" + goias +  "\""+
                ", \"maranhao\":\"" + maranhao +  "\""+
                ", \"mato_Grosso\":\"" + mato_Grosso +  "\""+
                ", \"mato_Grosso_do_Sul\":\"" + mato_Grosso_do_Sul +  "\""+
                ", \"minas_Gerais\":\"" + minas_Gerais +  "\""+
                ", \"para\":\"" + para +  "\""+
                ", \"paraiba\":\"" + paraiba +  "\""+
                ", \"parana\":\"" + parana +  "\""+
                ", \"pernambuco\":\"" + pernambuco +  "\""+
                ", \"piaui\":\"" + piaui +  "\""+
                ", \"rio_de_Janeiro\":\"" + rio_de_Janeiro +  "\""+
                ", \"rio_Grande_do_Norte\":\"" + rio_Grande_do_Norte +  "\""+
                ", \"rio_Grande_do_Sul\":\"" + rio_Grande_do_Sul +  "\""+
                ", \"rondonia\":\"" + rondonia +  "\""+
                ", \"roraima\":\"" + roraima +  "\""+
                ", \"santa_Catarina\":\"" + santa_Catarina +  "\""+
                ", \"sao_Paulo\":\"" + sao_Paulo +  "\""+
                ", \"sergipe\":\"" + sergipe +  "\""+
                ", \"tocantins\":\"" + tocantins +  "\""+
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
        return acre;
    }

    public long getAlagoas() {
        return alagoas;
    }

    public long getAmapa() {
        return amapa;
    }

    public long getAmazonas() {
        return amazonas;
    }

    public long getBahia() {
        return bahia;
    }

    public long getCeara() {
        return ceara;
    }

    public long getDistrito_Federal() {
        return distrito_Federal;
    }

    public long getEspirito_Santo() {
        return espirito_Santo;
    }

    public long getGoias() {
        return goias;
    }

    public long getMaranhao() {
        return maranhao;
    }

    public long getMato_Grosso() {
        return mato_Grosso;
    }

    public long getMato_Grosso_do_Sul() {
        return mato_Grosso_do_Sul;
    }

    public long getMinas_Gerais() {
        return minas_Gerais;
    }

    public long getPara() {
        return para;
    }

    public long getParaiba() {
        return paraiba;
    }

    public long getParana() {
        return parana;
    }

    public long getPernambuco() {
        return pernambuco;
    }

    public long getPiaui() {
        return piaui;
    }

    public long getRio_de_Janeiro() {
        return rio_de_Janeiro;
    }

    public long getRio_Grande_do_Norte() {
        return rio_Grande_do_Norte;
    }

    public long getRio_Grande_do_Sul() {
        return rio_Grande_do_Sul;
    }

    public long getRondonia() {
        return rondonia;
    }

    public long getRoraima() {
        return roraima;
    }

    public long getSanta_Catarina() {
        return santa_Catarina;
    }

    public long getSao_Paulo() {
        return sao_Paulo;
    }

    public long getSergipe() {
        return sergipe;
    }

    public long getTocantins() {
        return tocantins;
    }
}
