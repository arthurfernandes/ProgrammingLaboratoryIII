/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.eb.ime.labprog3.tam;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author arthurfernandes
 */
@Entity
@Table(name = "trecho")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trecho.findAll", query = "SELECT t FROM Trecho t"),
    @NamedQuery(name = "Trecho.findByAeroportoOrigem", query = "SELECT t FROM Trecho t WHERE t.trechoPK.aeroportoOrigem = :aeroportoOrigem"),
    @NamedQuery(name = "Trecho.findByAeroportoDestino", query = "SELECT t FROM Trecho t WHERE t.trechoPK.aeroportoDestino = :aeroportoDestino"),
    @NamedQuery(name = "Trecho.findByCodigoVoo", query = "SELECT t FROM Trecho t WHERE t.codigoVoo = :codigoVoo"),
    @NamedQuery(name = "Trecho.findByPreco", query = "SELECT t FROM Trecho t WHERE t.preco = :preco")})
public class Trecho implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TrechoPK trechoPK;
    @Column(name = "codigoVoo")
    private String codigoVoo;
    @Column(name = "preco")
    private Integer preco;
    @JoinColumn(name = "aeroportoOrigem", referencedColumnName = "aeroportoSigla", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Aeroporto aeroporto;
    @JoinColumn(name = "aeroportoDestino", referencedColumnName = "aeroportoSigla", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Aeroporto aeroporto1;

    public Trecho() {
    }

    public Trecho(TrechoPK trechoPK) {
        this.trechoPK = trechoPK;
    }

    public Trecho(String aeroportoOrigem, String aeroportoDestino) {
        this.trechoPK = new TrechoPK(aeroportoOrigem, aeroportoDestino);
    }

    public TrechoPK getTrechoPK() {
        return trechoPK;
    }

    public void setTrechoPK(TrechoPK trechoPK) {
        this.trechoPK = trechoPK;
    }

    public String getCodigoVoo() {
        return codigoVoo;
    }

    public void setCodigoVoo(String codigoVoo) {
        this.codigoVoo = codigoVoo;
    }

    public Integer getPreco() {
        return preco;
    }

    public void setPreco(Integer preco) {
        this.preco = preco;
    }

    public Aeroporto getAeroporto() {
        return aeroporto;
    }

    public void setAeroporto(Aeroporto aeroporto) {
        this.aeroporto = aeroporto;
    }

    public Aeroporto getAeroporto1() {
        return aeroporto1;
    }

    public void setAeroporto1(Aeroporto aeroporto1) {
        this.aeroporto1 = aeroporto1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (trechoPK != null ? trechoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trecho)) {
            return false;
        }
        Trecho other = (Trecho) object;
        if ((this.trechoPK == null && other.trechoPK != null) || (this.trechoPK != null && !this.trechoPK.equals(other.trechoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.eb.ime.labprog3.tam.Trecho[ trechoPK=" + trechoPK + " ]";
    }
    
}
