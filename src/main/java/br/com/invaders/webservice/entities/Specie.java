package br.com.invaders.webservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "specie")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Specie {

    @Id
    @Column(name = "species_id")
    private Long id;
    @Column(name = "kingdom_id")
    private String kingdomId;
    private String kingdom	 ;
    private String phyllum	 ;
    @Column(name = "class_name")
    private String className ;
    private String oorder	 ;
    private String family	 ;
    private String genus	 ;
    @Column(name = "scientific_name")
    private String scientificName ;
    private String author	;
    @Column(name = "morphophysiology_description")
    @Lob
    private String morphophysiology;
    @Lob
    @Column(name = "native_distribution_area")
    private String nativeDistributionArea;
    @Lob
    @Column(name = "natural_environment")
    private String naturalEnvironment;
    @Lob
    @Column(name = "economic_use")
    private String economicUse;
    @Lob
    @Column(name = "world_invasive_places")
    private String worldInvasivePlaces;
    @Lob
    @Column(name = "invasion_preferential_environments")
    private String invasionPreferentialEnvironments;
    @Lob
    @Column(name = "biodiversity_impact")
    private String biodiversityImpact;
    @Lob
    @Column(name = "economic_impact")
    private String economicImpact;
    @Lob
    @Column(name = "social_impact")
    private String socialImpact;
    @Lob
    @Column(name = "health_impact")
    private String health_impact;
    @Column(name = "abundance_id")
    private int abundanceId;
    @Lob
    @Column(name = "risk_analysis")
    private String riskAnalysis;
    @Lob
    @Column(name = "physical_control")
    private String physicalControl;
    @Lob
    @Column(name = "chemical_control")
    private String chemicalControl;
    @Lob
    @Column(name = "control_biological")
	private String controlBiological;
    @Lob
    @Column(name = "prevention")
	private String prevention;
    @Lob
    @Column(name = "risk_analysis_type")
	private String riskAnalysisType;
    @Column(name = "date_update")
	private String dateUpdate;
    @Lob
    @Column(name = "species_type")
	private String speciesType;
    @Lob
    @Column(name = "common_name")
	private String commonName;
    @Lob
    @Column(name = "habitat")
	private String habitat;
    @Column(name = "route_id")
	private int routeId;

    public Specie(){

    }

    public Specie(Long id, String scientificName) {
        this.id = id;
        this.scientificName = scientificName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKingdomId() {
        return kingdomId;
    }

    public void setKingdomId(String kingdomId) {
        this.kingdomId = kingdomId;
    }

    public String getKingdom() {
        return kingdom;
    }

    public void setKingdom(String kingdom) {
        this.kingdom = kingdom;
    }

    public String getPhyllum() {
        return phyllum;
    }

    public void setPhyllum(String phyllum) {
        this.phyllum = phyllum;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getOorder() {
        return oorder;
    }

    public void setOorder(String oorder) {
        this.oorder = oorder;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getGenus() {
        return genus;
    }

    public void setGenus(String genus) {
        this.genus = genus;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMorphophysiology() {
        return morphophysiology;
    }

    public void setMorphophysiology(String morphophysiology) {
        this.morphophysiology = morphophysiology;
    }

    public String getNativeDistributionArea() {
        return nativeDistributionArea;
    }

    public void setNativeDistributionArea(String nativeDistributionArea) {
        this.nativeDistributionArea = nativeDistributionArea;
    }

    public String getNaturalEnvironment() {
        return naturalEnvironment;
    }

    public void setNaturalEnvironment(String naturalEnvironment) {
        this.naturalEnvironment = naturalEnvironment;
    }

    public String getEconomicUse() {
        return economicUse;
    }

    public void setEconomicUse(String economicUse) {
        this.economicUse = economicUse;
    }

    public String getWorldInvasivePlaces() {
        return worldInvasivePlaces;
    }

    public void setWorldInvasivePlaces(String worldInvasivePlaces) {
        this.worldInvasivePlaces = worldInvasivePlaces;
    }

    public String getInvasionPreferentialEnvironments() {
        return invasionPreferentialEnvironments;
    }

    public void setInvasionPreferentialEnvironments(String invasionPreferentialEnvironments) {
        this.invasionPreferentialEnvironments = invasionPreferentialEnvironments;
    }

    public String getBiodiversityImpact() {
        return biodiversityImpact;
    }

    public void setBiodiversityImpact(String biodiversityImpact) {
        this.biodiversityImpact = biodiversityImpact;
    }

    public String getEconomicImpact() {
        return economicImpact;
    }

    public void setEconomicImpact(String economicImpact) {
        this.economicImpact = economicImpact;
    }

    public String getSocialImpact() {
        return socialImpact;
    }

    public void setSocialImpact(String socialImpact) {
        this.socialImpact = socialImpact;
    }

    public String getHealth_impact() {
        return health_impact;
    }

    public void setHealth_impact(String health_impact) {
        this.health_impact = health_impact;
    }

    public int getAbundanceId() {
        return abundanceId;
    }

    public void setAbundanceId(int abundanceId) {
        this.abundanceId = abundanceId;
    }

    public String getRiskAnalysis() {
        return riskAnalysis;
    }

    public void setRiskAnalysis(String riskAnalysis) {
        this.riskAnalysis = riskAnalysis;
    }

    public String getPhysicalControl() {
        return physicalControl;
    }

    public void setPhysicalControl(String physicalControl) {
        this.physicalControl = physicalControl;
    }

    public String getChemicalControl() {
        return chemicalControl;
    }

    public void setChemicalControl(String chemicalControl) {
        this.chemicalControl = chemicalControl;
    }

    public String getControlBiological() {
        return controlBiological;
    }

    public void setControlBiological(String controlBiological) {
        this.controlBiological = controlBiological;
    }

    public String getPrevention() {
        return prevention;
    }

    public void setPrevention(String prevention) {
        this.prevention = prevention;
    }

    public String getRiskAnalysisType() {
        return riskAnalysisType;
    }

    public void setRiskAnalysisType(String riskAnalysisType) {
        this.riskAnalysisType = riskAnalysisType;
    }

    public String getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(String dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public String getSpeciesType() {
        return speciesType;
    }

    public void setSpeciesType(String speciesType) {
        this.speciesType = speciesType;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }
}
