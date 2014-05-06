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
public class FilmeBuilder {
    
    private Integer filmeId = 0;
    private String nome = "";
    private String genero = "";
    private String classificacaoIndicativa = "";
    private String distribuidora = "";
    private String duracao = ""; 
            
    public FilmeBuilder(){
        
    }
    
    public Filme geraFilme(){
        return new Filme(filmeId,nome,genero,classificacaoIndicativa,distribuidora,duracao);
    }
    
    public void comFilmeId(String filmeId){
        try{
            this.filmeId = Integer.parseInt(filmeId);
        }
        catch(NumberFormatException e){
            this.filmeId = 0;
        }
        
    }
    
    public void comNome(String nome){
        this.nome = nome;
    }
    
    public void comGenero(String genero){
        this.genero = genero;
    }
    
    public void comClassificacaoIndicativa(String classificacaoIndicativa){
        this.classificacaoIndicativa = classificacaoIndicativa;
    }
    
    public void comDistribuidora(String distribuidora){
        this.distribuidora = distribuidora;
    }
    
    public void comDuracao(String duracao){
        this.duracao = duracao;
    }
}
