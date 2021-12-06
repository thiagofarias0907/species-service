package br.com.invaders.webservice.controller;

import org.json.JSONObject;

import java.util.List;

public interface Controller<T> {


    public List<T> getAll();

    public List<T> insertAll(List<T> list);

    public JSONObject getEstatisticas();

//    RF13	A aplicação deve se capturar dados da fonte de dados original
//    RF14	A aplicação deve permitir listar todas as espécies registradas
//    RF15	A aplicação deve permitir listar todas as ocorrências de uma espécie da lista
//    RF16	A aplicação deve permitir listar todas as ocorrências próximas a uma localização
//    RF17	A aplicação deve permitir buscar informações técnicas existentes sobre uma espécie
//    RF18	A aplicação deve calcular estatísticas de frequência sobre as ocorrências de espécies
//    RF19	A aplicação deve calcular estatísticas de frequência temporal sobre as ocorrências de espécies
//    RF20	A aplicação deve listar espécies por filtros de reino, espécie ou estado de ocorrência



}
