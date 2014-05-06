/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.eb.ime.labprog3.cinemark;

/**
 *
 * @author arthurfernandes
 */
public class Cinema {
    
    private final Integer cinemaId;
    private final String nome;
    private final String latitude;
    private final String longitude;
    private final String endereco;
    private final Cidade cidade;
    private final String numeroSalas;
    
    public Cinema(Integer cinemaId, String nome, String latitude, String longitude, String endereco, Cidade cidade, String numeroSalas){
        this.cinemaId = cinemaId;
        this.nome = nome;
        this.latitude = latitude;
        this.longitude = longitude;
        this.endereco = endereco;
        this.cidade = cidade;
        this.numeroSalas = numeroSalas;
    }
    
    public Integer getCinemaId(){
        return this.cinemaId;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public String getLatitude(){
        return this.latitude;
    }
    
    public String getLongitude(){
        return this.longitude;
    }
    
    public String getEndereco(){
        return this.endereco;
    }
    
    public Cidade getCidade(){
        return this.cidade;
    }
    
    public String getNumeroSalas(){
        return this.numeroSalas;
    }
    
}
