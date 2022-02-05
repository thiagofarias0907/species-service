package br.com.invaders.webservice.controller;

import org.json.JSONObject;

import java.util.List;

public interface Controller<T> {


    public List<T> getAll();

    public List<T> insertAll(List<T> list);

    public long getEstatisticas();




}
