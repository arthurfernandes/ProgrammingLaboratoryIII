/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.eb.ime.labprog3.cinemark;

import java.util.Objects;

/**
 *
 * @author arthurfernandes
 */
public class Cidade {
    private final Integer cidadeId;
    private final String nome;
    
    public Cidade(Integer cidadeId,String nome){
        this.cidadeId = cidadeId;
        this.nome = nome;
    }
    
    public Integer getCidadeId(){
        return this.cidadeId;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj.getClass().equals(this.getClass())){
            Cidade cidade = (Cidade) obj;
            if((cidade.getCidadeId() == this.cidadeId) && (cidade.getNome().equalsIgnoreCase(this.nome))){
                return true;
            }
        }
        
        return false;
    }

    @Override
    public int hashCode() {
        int hash = this.cidadeId;
        return hash;
    }
}
