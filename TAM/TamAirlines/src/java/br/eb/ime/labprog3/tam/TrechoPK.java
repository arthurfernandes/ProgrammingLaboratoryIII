/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.eb.ime.labprog3.tam;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author arthurfernandes
 */
@Embeddable
public class TrechoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "aeroportoOrigem")
    private String aeroportoOrigem;
    @Basic(optional = false)
    @Column(name = "aeroportoDestino")
    private String aeroportoDestino;

    public TrechoPK() {
    }

    public TrechoPK(String aeroportoOrigem, String aeroportoDestino) {
        this.aeroportoOrigem = aeroportoOrigem;
        this.aeroportoDestino = aeroportoDestino;
    }

    public String getAeroportoOrigem() {
        return aeroportoOrigem;
    }

    public void setAeroportoOrigem(String aeroportoOrigem) {
        this.aeroportoOrigem = aeroportoOrigem;
    }

    public String getAeroportoDestino() {
        return aeroportoDestino;
    }

    public void setAeroportoDestino(String aeroportoDestino) {
        this.aeroportoDestino = aeroportoDestino;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aeroportoOrigem != null ? aeroportoOrigem.hashCode() : 0);
        hash += (aeroportoDestino != null ? aeroportoDestino.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrechoPK)) {
            return false;
        }
        TrechoPK other = (TrechoPK) object;
        if ((this.aeroportoOrigem == null && other.aeroportoOrigem != null) || (this.aeroportoOrigem != null && !this.aeroportoOrigem.equals(other.aeroportoOrigem))) {
            return false;
        }
        if ((this.aeroportoDestino == null && other.aeroportoDestino != null) || (this.aeroportoDestino != null && !this.aeroportoDestino.equals(other.aeroportoDestino))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.eb.ime.labprog3.tam.TrechoPK[ aeroportoOrigem=" + aeroportoOrigem + ", aeroportoDestino=" + aeroportoDestino + " ]";
    }
    
}
