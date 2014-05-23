/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.eb.ime.labprog3.tam;

/**
 *
 * @author arthurfernandes
 */
public class Trecho {
    private final int idTrecho;
    private final int idAeroportoOrigem;
    private final int idAeroportoDestino;
    private String aeroportoOrigemNome;

    private String aeroportoDestinoNome;
    private final String duracao;
    private final float preco;
    private final String numeroVoo;
    
    public int getIdTrecho(){
        return idTrecho;
    }
    
    public int getIdAeroportoOrigem() {
        return idAeroportoOrigem;
    }

    public int getIdAeroportoDestino() {
        return idAeroportoDestino;
    }
    
    public String getAeroportoOrigemNome() {
        return aeroportoOrigemNome;
    }

    public void setAeroportoOrigemNome(String aeroportoOrigemNome) {
        this.aeroportoOrigemNome = aeroportoOrigemNome;
    }

    public String getAeroportoDestinoNome() {
        return aeroportoDestinoNome;
    }

    public void setAeroportoDestinoNome(String aeroportoDestinoNome) {
        this.aeroportoDestinoNome = aeroportoDestinoNome;
    }
    public String getDuracao() {
        return duracao;
    }

    public float getPreco() {
        return preco;
    }

    public String getNumeroVoo() {
        return numeroVoo;
    }

    public Trecho(int idTrecho,int idAeroportoOrigem, int idAeroportoDestino, String duracao, float preco, String numeroVoo) {
        this.idTrecho = idTrecho;
        this.idAeroportoOrigem = idAeroportoOrigem;
        this.idAeroportoDestino = idAeroportoDestino;
        this.duracao = duracao;
        this.preco = preco;
        this.numeroVoo = numeroVoo;
    }
    
}
