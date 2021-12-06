package br.com.invaders.webservice.utils;

import java.util.HashMap;
import java.util.Map;

public class SpeciesKeys {

    Map<String,String> hashMap = new HashMap();
    
    public SpeciesKeys() {
        
        hashMap.put("genus_id","genusId");
        hashMap.put("genus","genus");
        hashMap.put("species_id","id");
        hashMap.put("species_itis_id","speciesItisId");
        hashMap.put("species","species");
        hashMap.put("scientific_name","scientificName");
        hashMap.put("author","author");
        hashMap.put("subspecies","subspecies");
        hashMap.put("sub_author","subAuthor");
        hashMap.put("image_credit","imageCredit");
        hashMap.put("morphophysiology_description","morphophysiologyDescription");
        hashMap.put("native_distribution_area","nativeDistributionArea");
        hashMap.put("origin","origin");
        hashMap.put("natural_environment","naturalEnvironment");
        hashMap.put("economic_use","economicUse");
        hashMap.put("world_invasive_places","worldInvasivePlaces");
        hashMap.put("invasion_preferential_environments","invasionPreferentialEnvironments");
        hashMap.put("biodiversity_impact","biodiversityImpact");
        hashMap.put("economic_impact","economicImpact");
        hashMap.put("social_impact","socialImpact");
        hashMap.put("health_impact","healthImpact");
        hashMap.put("confirmed","confirmed");
        hashMap.put("biblio_id","biblioId");
        hashMap.put("abundance_id","abundanceId");
        hashMap.put("risk_analysis","riskAnalysis");
        hashMap.put("physical_control","physicalControl");
        hashMap.put("chemical_control","chemicalControl");
        hashMap.put("control_biological","controlBiological");
        hashMap.put("prevention","prevention");
        hashMap.put("prevention_MMA","preventionMMA");
        hashMap.put("risk_analysis_type","riskAnalysisType");
        hashMap.put("log_update","logUpdate");
        hashMap.put("user_update","userUpdate");
        hashMap.put("date_update","dateUpdate");
        hashMap.put("user_delete","userDelete");
        hashMap.put("date_delete","dateDelete");
        hashMap.put("user_check","userCheck");
        hashMap.put("date_check","dateCheck");
        hashMap.put("kingdom","kingdom");
        hashMap.put("family","family");
        hashMap.put("image_name","imageName");
        hashMap.put("eicat_bibliography_id","eicatBibliographyId");
        hashMap.put("eicat_date","eicatDate");
        hashMap.put("seicat_bibliography_id","seicatBibliographyId");
        hashMap.put("seicat_date","seicatDate");
        hashMap.put("pending_analysis","pendingAnalysis");
        hashMap.put("riskAnalysis","riskAnalysis");
        hashMap.put("vocConfidence","vocConfidence");
        hashMap.put("early_detection_measures","earlyDetectionMeasures");
        hashMap.put("species_type","speciesType");
        hashMap.put("species_type_array","speciesTypeArray");
        hashMap.put("dataCommonNames","dataCommonNames");
        hashMap.put("dataSynonyms","dataSynonyms");
        hashMap.put("taxonomyGenus","taxonomyGenus");
        hashMap.put("relBiologicalForm","relBiologicalForm");
        hashMap.put("relReproduction","relReproduction");
        hashMap.put("relSpread","relSpread");
        hashMap.put("relDiet","relDiet");
        hashMap.put("relRoute","relRoute");
        hashMap.put("relVector","relVector");
        hashMap.put("relBibliography","relBibliography");
        hashMap.put("relEconomicUse","relEconomicUse");
        hashMap.put("relImpacts","relImpacts");
        hashMap.put("relPrefInvEnv","relPrefInvEnv");
        hashMap.put("dataIntroduction","dataIntroduction");
        hashMap.put("relProjects","relProjects");
        hashMap.put("relDistribution","relDistribution");
        hashMap.put("relContacts","relContacts");
        hashMap.put("relPathwaysCdb","relPathwaysCdb");
        hashMap.put("relVectorsCdb","relVectorsCdb");
        hashMap.put("relEicat","relEicat");
        hashMap.put("relSeicat","relSeicat");
        hashMap.put("relImpactMechanismEicat","relImpactMechanismEicat");
        hashMap.put("relImpactMechanismSeicat","relImpactMechanismSeicat");
        hashMap.put("vocConfidenceEicat","vocConfidenceEicat");
        hashMap.put("vocConfidenceSeicat","vocConfidenceSeicat");
        hashMap.put("species_id_array","speciesIdArray");
        hashMap.put("common_name","commonName");
        hashMap.put("synonymous","synonymous");
        hashMap.put("biological_form_id","biologicalFormId");
        hashMap.put("biological_form_id_array","biologicalFormIdArray");
        hashMap.put("reproduction_id","reproductionId");
        hashMap.put("diet_id","dietId");
        hashMap.put("spread_id","spreadId");
        hashMap.put("economic_use_id","economicUseId");
        hashMap.put("economic_use_id_array","economicUseIdArray");
        hashMap.put("pref_inv_env_id","prefInvEnvId");
        hashMap.put("pref_inv_env_id_array","prefInvEnvIdArray");
        hashMap.put("introduction_type_id","introductionTypeId");
        hashMap.put("cause_introduction_id","causeIntroductionId");
        hashMap.put("location","location");
        hashMap.put("intro_data","introData");
        hashMap.put("impact_id","impactId");
        hashMap.put("impact_id_array","impactIdArray");
        hashMap.put("municipio_id","municipioId");
        hashMap.put("state_id","stateId");
        hashMap.put("protected_area","protectedArea");
        hashMap.put("habitat","habitat");
        hashMap.put("route_id","routeId");
        hashMap.put("kingdom_id","kingdomId");
        hashMap.put("pathways_cdb_id","pathwaysCdbId");
        hashMap.put("vectors_cdb_id","vectorsCdbId");
        hashMap.put("vector_id","vectorId");
        hashMap.put("eicat_confidence_id","eicatConfidenceId");
        hashMap.put("seicat_confidence_id","seicatConfidenceId");
    }

    public Map<String, String> getHashMap() {
        return hashMap;
    }

    //
//
//            "genusId"
//                    "genus"
//                    "speciesId"
//                    "speciesItisId"
//                    "species"
//                    "scientificName"
//                    "author"
//                    "subspecies"
//                    "subAuthor"
//                    "imageCredit"
//                    "morphophysiologyDescription"
//                    "nativeDistributionArea"
//                    "origin"
//                    "naturalEnvironment"
//                    "economicUse"
//                    "worldInvasivePlaces"
//                    "invasionPreferentialEnvironments"
//                    "biodiversityImpact"
//                    "economicImpact"
//                    "socialImpact"
//                    "healthImpact"
//                    "confirmed"
//                    "biblioId"
//                    "abundanceId"
//                    "riskAnalysis"
//                    "physicalControl"
//                    "chemicalControl"
//                    "controlBiological"
//                    "prevention"
//                    "preventionMMA"
//                    "riskAnalysisType"
//                    "logUpdate"
//                    "userUpdate"
//                    "dateUpdate"
//                    "userDelete"
//                    "dateDelete"
//                    "userCheck"
//                    "dateCheck"
//                    "kingdom"
//                    "family"
//                    "imageName"
//                    "eicatBibliographyId"
//                    "eicatDate"
//                    "seicatBibliographyId"
//                    "seicatDate"
//                    "pendingAnalysis"
//                    "riskAnalysis"
//                    "vocConfidence"
//                    "earlyDetectionMeasures"
//                    "speciesType"
//                    "speciesTypeArray"
//                    "dataCommonNames"
//                    "dataSynonyms"
//                    "taxonomyGenus"
//                    "relBiologicalForm"
//                    "relReproduction"
//                    "relSpread"
//                    "relDiet"
//                    "relRoute"
//                    "relVector"
//                    "relBibliography"
//                    "relEconomicUse"
//                    "relImpacts"
//                    "relPrefInvEnv"
//                    "dataIntroduction"
//                    "relProjects"
//                    "relDistribution"
//                    "relContacts"
//                    "relPathwaysCdb"
//                    "relVectorsCdb"
//                    "relEicat"
//                    "relSeicat"
//                    "relImpactMechanismEicat"
//                    "relImpactMechanismSeicat"
//                    "vocConfidenceEicat"
//                    "vocConfidenceSeicat"
//                    "speciesIdArray"
//                    "commonName"
//                    "synonymous"
//                    "biologicalFormId"
//                    "biologicalFormIdArray"
//                    "reproductionId"
//                    "dietId"
//                    "spreadId"
//                    "economicUseId"
//                    "economicUseIdArray"
//                    "prefInvEnvId"
//                    "prefInvEnvIdArray"
//                    "introductionTypeId"
//                    "causeIntroductionId"
//                    "location"
//                    "introData"
//                    "impactId"
//                    "impactIdArray"
//                    "municipioId"
//                    "stateId"
//                    "protectedArea"
//                    "habitat"
//                    "routeId"
//                    "kingdomId"
//                    "pathwaysCdbId"
//                    "vectorsCdbId"
//                    "vectorId"
//                    "eicatConfidenceId"
//                    "seicatConfidenceId"
}
