package br.eb.ime.labprog3.cinemark;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author arthurfernandes
 */
@XStreamAlias("film")
public class Filme {
    
    private final Integer filmeId;
    private final String nome;
    private final String genero;
    private final String classificacaoIndicativa;
    private final String distribuidora;
    private final String duracao;
    
    public Filme(Integer filmeId, String nome, String genero, String classificacaoIndicativa,String distribuidora,String duracao){
        this.filmeId = filmeId;
        this.nome = nome;
        this.genero = genero;
        this.classificacaoIndicativa = classificacaoIndicativa;
        this.distribuidora = distribuidora;
        this.duracao = duracao;
    }
    
    public Integer getFilmeId(){
        return this.filmeId;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public String getGenero(){
        return this.genero;
    }
    
    public String getClassificacaoIndicativa(){
        return this.classificacaoIndicativa;
    }
    
    public String getDistribuidora(){
        return this.distribuidora;
    } 

    public String getDuracao(){
        return this.duracao;
    }
}
