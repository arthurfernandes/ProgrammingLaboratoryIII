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
public class CinemaBuilder {
    
    private Integer cinemaId = 0;
    private String nome = "";
    private String latitude = "";
    private String longitude = "";
    private String endereco = "";
    private Cidade cidade = new Cidade(0,"");
    private String numeroSalas = "";
    
    public CinemaBuilder(){
        
    }
    
    public Cinema geraCinema(){
        return new Cinema(cinemaId, nome,latitude,longitude, endereco, cidade,numeroSalas);
    }
    
    public void comCinemaId(String cinemaId){
        try{
            this.cinemaId = Integer.parseInt(cinemaId);
        }
        catch(NumberFormatException e){
            this.cinemaId = 0;
        }
    }
    
    public void comNome(String nome){
        this.nome = nome;
    }
    
    public void comLatitude(String latitude){
        this.latitude = latitude;
    }
    
    public void comLongitude(String longitude){
        this.longitude = longitude;
    }
    
    public void comEndereco(String endereco){
        this.endereco = endereco;
    }
    
    public void comCidade(Cidade cidade){
        this.cidade = cidade;
    }
    
    public void comNumeroSalas(String numeroSalas){
        this.numeroSalas = numeroSalas;
    }
    
}
